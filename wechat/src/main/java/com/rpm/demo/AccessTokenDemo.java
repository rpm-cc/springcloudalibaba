package com.rpm.demo;


import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.AccessToken;
import com.tencent.wework.api.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 16:03
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class AccessTokenDemo implements AccessTokenService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    WeWorkRestUtil weWorkRestUtil;

    /**
     * get accesstoken
     * @param corpid
     * @param corpsecret
     * @return
     */
    @Override
    public  String getAccessToken(String corpid,String corpsecret){
        String accessTokenKey  = "AccessToken:"+corpid+":"+corpsecret;
        String accessToken = redisTemplate.opsForValue().get(accessTokenKey);
        if (accessToken != null){
           Long expire =  redisTemplate.getExpire(accessTokenKey, TimeUnit.SECONDS);
           if (expire.compareTo(200L)==1){
               return accessToken;
           }
        }
        if (redisTemplate.opsForValue().setIfAbsent("lock"+accessTokenKey,"lock")) {

            try {
                AccessToken token  = weWorkRestUtil.get(AccessToken.class,API_URI,corpid,corpsecret);
                accessToken = token.getAccessToken();
                log.info("accesstoken:{}", accessToken);
                redisTemplate.opsForValue().set(accessTokenKey, accessToken, 7200, TimeUnit.SECONDS);
            }catch (Exception e ){

            }finally {
                redisTemplate.delete("lock"+accessTokenKey);
            }
            return accessToken;

        }
        return accessToken;
    }

}
