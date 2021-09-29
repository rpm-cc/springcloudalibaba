package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.ExternalcontactList;
import com.tencent.wework.api.service.ExternalcontactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    WeWorkRestUtil restUtil;
    @Override
    public ExternalcontactList list(String corpid,String secrect,String userid) {

        ExternalcontactList contactList = restUtil.get(ExternalcontactList.class,CONTACT_LIST,corpid,secrect,userid);
        log.info("ExternalcontactList:{}", JSON.toJSONString(contactList));
        return contactList;
    }
}
