package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.request.external.contacts.BatchGetExternalContactRequest;
import com.tencent.wework.api.domain.request.external.contacts.GetExternalContactRequest;
import com.tencent.wework.api.domain.request.external.contacts.UpdateExternalContactRemarkRequest;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.contacts.BatchGetExternalContactResponse;
import com.tencent.wework.api.domain.response.external.contacts.GetExternalContactResponse;
import com.tencent.wework.api.domain.response.external.contacts.ExternalContactListReponse;
import com.tencent.wework.api.service.ContactsManagementService;
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
public class ContactsManagementDemo implements ContactsManagementService {

    WeWorkRestUtil restUtil;
    @Autowired
    ContactsManagementDemo(WeWorkRestUtil restUtil) {
        this.restUtil = restUtil;
    }
    @Override
    public ExternalContactListReponse list(String corpid, String corpsecret, String userid) {
        ExternalContactListReponse contactList = restUtil.get(ExternalContactListReponse.class,
                URL_EXTERNAL_CONTACT_LIST, corpid, corpsecret, userid);
        log.info("ExternalcontactList:{}", JSON.toJSONString(contactList));
        return contactList;
    }

    @Override
    public GetExternalContactResponse get(String corpid, String corpsecret, GetExternalContactRequest request) {
        //&external_userid={externalUserid}&cursor={cursor}
        String url = URL_EXTERNAL_CONTACT_GET;

        if (request.getExternalUserid() != null) {
            url = url + "&external_userid={externalUserid}";
        }
        if (request.getCursor() != null) {
            url = url + "&cursor={cursor}";
        }
        GetExternalContactResponse contactList = restUtil.get(GetExternalContactResponse.class, url, corpid, corpsecret, request);
        log.info("ExternalContactGetResponse:{}", JSON.toJSONString(contactList));
        return contactList;
    }

    @Override
    public BatchGetExternalContactResponse batchGet(String corpid, String corpsecret, BatchGetExternalContactRequest request) {
        BatchGetExternalContactResponse reponse = restUtil.post(BatchGetExternalContactResponse.class,
                URL_EXTERNAL_CONTACT_BATCH, corpid, corpsecret, request);
        log.info("ExternalContactListReponse:{}", reponse);
        return reponse;
    }

    @Override
    public WeWorkResponse updateCustomerRemark(String corpid, String corpsecret, UpdateExternalContactRemarkRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class, URL_EXTERNAL_CONTACT_REMARK, corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", response);
        return response;
    }
}
