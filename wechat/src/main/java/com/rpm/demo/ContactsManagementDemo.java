package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.request.external.contacts.*;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.contacts.*;
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
        ExternalContactListReponse response = restUtil.get(ExternalContactListReponse.class,
                URL_EXTERNAL_CONTACT_LIST, corpid, corpsecret, userid);
        log.info("ExternalcontactList:{}", JSON.toJSONString(response));
        return response;
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
        GetExternalContactResponse response = restUtil.get(GetExternalContactResponse.class, url, corpid, corpsecret, request);
        log.info("ExternalContactGetResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public BatchGetExternalContactResponse batchGet(String corpid, String corpsecret, BatchGetExternalContactRequest request) {
        BatchGetExternalContactResponse response = restUtil.post(BatchGetExternalContactResponse.class,
                URL_EXTERNAL_CONTACT_BATCH, corpid, corpsecret, request);
        log.info("ExternalContactListReponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse updateRemark(String corpid, String corpsecret, UpdateRemarkRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class,
                URL_EXTERNAL_CONTACT_REMARK, corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ListCustomerStrategyResponse listCustomerStrategy(String corpid, String corpsecret, ListCustomerStrategyRequest request) {
        ListCustomerStrategyResponse response = restUtil.post(ListCustomerStrategyResponse.class,
                URL_CUSTOMER_STRATEGY_LIST, corpid, corpsecret, request);
        log.info("ListCustomerStrategyResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public GetCustomerStrategyResponse getCustomerStrategy(String corpid, String corpsecret, GetCustomerStrategyRequest request) {
        GetCustomerStrategyResponse response = restUtil.post(GetCustomerStrategyResponse.class,
                URL_CUSTOMER_STRATEGY_GET, corpid, corpsecret, request);
        log.info("GetCustomerStrategyResponse:{}", JSON.toJSONString(response));

        return response;
    }

    @Override
    public GetCustomerStrategyRangeResponse getRange(String corpid, String corpsecret, GetCustomerStrategyRangeRequest request) {
        GetCustomerStrategyRangeResponse response = restUtil.post(GetCustomerStrategyRangeResponse.class,
                URL_CUSTOMER_STRATEGY_GET_RANGE, corpid, corpsecret, request);
        log.info("GetCustomerStrategyRangeResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public CreateCustomerStrategyResponse createCustomerStrategy(String corpid, String corpsecret, CreateCustomerStrategyRequest request) {
        CreateCustomerStrategyResponse response = restUtil.post(CreateCustomerStrategyResponse.class,
                URL_CUSTOMER_STRATEGY_CREATE, corpid, corpsecret, request);
        log.info("CreateCustomerStrategyRequest:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse editCustomerStrategy(String corpid, String corpsecret, EditCustomerStrategyRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class,
                URL_CUSTOMER_STRATEGY_EDIT, corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse delCustomerStrategy(String corpid, String corpsecret, DelCustomerStrategyRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class,
                URL_CUSTOMER_STRATEGY_DEL, corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }


}
