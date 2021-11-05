package com.rpm.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.wework.api.domain.AccessToken;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 企业微信服务起api接口调用工具类 。
 * 支持 get post 方式调用。
 *
 * @author: Piming Ren
 * @date: 2021/9/29 9:41
 * @version: 1.0
 * @description:
 */
@Component
@Slf4j
public class WeWorkRestUtil {
    /**
     * <pre>
     * 获取accessToken
     * 请求方式 GET(https)
     * 详见：https://open.work.weixin.qq.com/api/doc/10013#%E7%AC%AC%E4%B8%89%E6%AD%A5%EF%BC%9A%E8%8E%B7%E5%8F%96access_token
     * </pre>
     */
    private static final String API_URI = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    RedisLockRegistry redisLockRegistry;

    /**
     * 不需要accesstoken
     *
     * @param _class
     * @param url
     * @param corpid
     * @param corpsecret
     * @param <T>
     * @return
     */
    public <T extends WeWorkResponse> T get(Class<T> _class, String url, String corpid, String corpsecret) {
        final ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, _class, corpid, corpsecret);
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse> T get(Class<T> _class, String url, String corpid, String corpsecret, Object... uriVariables) {
        final ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, _class, accessToken(corpid, corpsecret), uriVariables);
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse, E extends WeWorkRequest> T get(Class<T> _class, String url, String corpid, String corpsecret, E data) {
        Class cls = data.getClass();
        Field[] fields = cls.getDeclaredFields();
        Map<String, Object> uriVariables = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                //获取属性值
                Object value = null;
                value = field.get(data);
                if (value != null) {
                    uriVariables.put(name, value);
                }
            } catch (IllegalAccessException e) {
                log.error("{}请求参数错误", url);
            }
        }
        uriVariables.put("ACCESS_TOKEN", accessToken(corpid, corpsecret));
        final ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, _class, uriVariables);
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse, E extends WeWorkRequest> T post(Class<T> _class, String url, String corpid, String corpsecret, E data) {

        String body = JSON.toJSONString(data);
        //JSONObject object  = post(url,corpid,corpsecret,body);
        final ResponseEntity<T> responseEntity = restTemplate.postForEntity(url,
                body,
                _class,
                accessToken(corpid, corpsecret));
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse> T post(Class<T> _class, String url, String corpid, String corpsecret, Map<String, Object> data) {
        final ResponseEntity<T> responseEntity = restTemplate.postForEntity(url,
                JSON.toJSONString(data),
                _class,
                accessToken(corpid, corpsecret));
        return getT(responseEntity);
    }

    public JSONObject post(String url, String corpid, String corpsecret, String json) {
        final ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url,
                json,
                JSONObject.class,
                accessToken(corpid, corpsecret));
        return responseEntity.getBody();
    }

    private <T extends WeWorkResponse> T getT(ResponseEntity<T> responseEntity) {
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("网路错误：{}，获取失败", responseEntity.getStatusCode());
            return null;
        }
        T t = responseEntity.getBody();
        if (t.getErrcode() != 0) {
            log.error("获取失败 errorCode:{} errorMsg:{}", t.getErrcode(), t.getErrmsg());
            return t;
        }
        return t;
    }

    private String accessToken(String corpid, String corpsecret) {
        String accessTokenKey = "AccessToken:" + corpid + ":" + corpsecret;
        String accessToken = null;
        Lock lock = redisLockRegistry.obtain(accessTokenKey);
        try {
            // 设置5 秒等待超时时间 ，如果其他线程再这5秒内一支持有该锁。则获取锁失败。
            // 注意使用RedisLockRegistry 设置的锁的有效期时间，默认是一分钟。再本实力中；
            // 我设置成了10秒。在 RedisConfiguration中可以修改。
            boolean isLock = lock.tryLock(5, TimeUnit.SECONDS);
            accessToken = redisTemplate.opsForValue().get(accessTokenKey);
            if (!isLock) {
                return accessToken;
            }
            if (accessToken != null) {
                Long expire = redisTemplate.getExpire(accessTokenKey, TimeUnit.SECONDS);
                if (expire.compareTo(200L) == 1) {
                    return accessToken;
                }
            }
            AccessToken token = this.get(AccessToken.class, API_URI, corpid, corpsecret);
            accessToken = token.getAccessToken();
            log.info("AccessToken:{}", accessToken);
            redisTemplate.opsForValue().set(accessTokenKey, accessToken, 7200, TimeUnit.SECONDS);
            return accessToken;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return accessToken;
    }

}
