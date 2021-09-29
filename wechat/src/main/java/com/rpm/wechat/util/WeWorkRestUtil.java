package com.rpm.wechat.util;

import com.alibaba.fastjson.JSON;
import com.tencent.wework.api.domain.AccessToken;
import com.tencent.wework.api.domain.WeWorkResponse;
import com.tencent.wework.api.domain.query.Query;
import com.tencent.wework.api.service.AccessTokenService;
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

    public <T extends WeWorkResponse> T post(Class<T> _class, String url, String corpid, String corpsecret, Map<String,Object> data) {
        final ResponseEntity<T> responseEntity = restTemplate.postForEntity(url,
                JSON.toJSONString(data),
                _class,
                accessToken(corpid, corpsecret));
        return getT(responseEntity);
    }

    private <T extends WeWorkResponse> T getT(ResponseEntity<T> responseEntity){
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
                AccessToken token = this.get(AccessToken.class, AccessTokenService.API_URI, corpid, corpsecret);
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
