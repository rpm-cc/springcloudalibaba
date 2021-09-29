package com.rpm.wechat.util;

import com.alibaba.fastjson.JSON;
import com.tencent.wework.api.domain.AccessToken;
import com.tencent.wework.api.domain.WeWorkResponse;
import com.tencent.wework.api.domain.query.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
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

    public <T extends WeWorkResponse> T get(Class<T> _class, String url, String corpid, String corpsecret) {
        final ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, _class, corpid, corpsecret);
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse, E> T get(Class<T> _class, String url, String corpid, String corpsecret, E data) {
        final ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, _class, accessToken(corpid, corpsecret), data);
        return getT(responseEntity);
    }

    public <T extends WeWorkResponse, E extends Query> T post(Class<T> _class, String url, String corpid, String corpsecret, E data) {
        final ResponseEntity<T> responseEntity = restTemplate.postForEntity(url,
                JSON.toJSONString(data),
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
        String accessToken = redisTemplate.opsForValue().get(accessTokenKey);
        if (accessToken != null) {
            Long expire = redisTemplate.getExpire(accessTokenKey, TimeUnit.SECONDS);
            if (expire.compareTo(200L) == 1) {
                return accessToken;
            }
        }
        if (redisTemplate.opsForValue().setIfAbsent("lock" + accessTokenKey, "lock")) {
            try {
                AccessToken token = this.get(AccessToken.class, API_URI, corpid, corpsecret);
                accessToken = token.getAccessToken();
                log.info("accesstoken:{}", accessToken);
                redisTemplate.opsForValue().set(accessTokenKey, accessToken, 7200, TimeUnit.SECONDS);
            } catch (Exception e) {

            } finally {
                redisTemplate.delete("lock" + accessTokenKey);
            }
            return accessToken;

        }
        return accessToken;
    }

}
