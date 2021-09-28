package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.tencent.wework.api.domain.ExternalcontactList;
import com.tencent.wework.api.service.ExternalcontactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Piming Ren
 * @date: 2021/9/28 13:57
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class ExternalcontactDemo implements ExternalcontactService {
    @Autowired
    AccessTokenDemo accessToken;
    @Override
    public ExternalcontactList list(String corpid,String secrect,String userid) {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<ExternalcontactList> responseEntity = restTemplate.getForEntity(
                CONTACT_LIST,
                ExternalcontactList.class,
                accessToken.getAccessToken(corpid, secrect),userid);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("网络错误：{}，获取失败!",responseEntity.getStatusCode());
            return null;
        }
        ExternalcontactList contactList = responseEntity.getBody();
        if (contactList.getErrcode() != 0) {
            log.error("客户群列表获取失败 errorCode:{} errorMsg:{}", contactList.getErrcode(), contactList.getErrmsg());
            return null;
        }
        log.info("ExternalcontactList:{}", JSON.toJSONString(contactList));
        return contactList;
    }
}
