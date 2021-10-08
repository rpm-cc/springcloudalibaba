package com.rpm.demo;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.request.external.employee.*;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.employee.AddContactWayResponse;
import com.tencent.wework.api.domain.response.external.employee.GetContactWayResponse;
import com.tencent.wework.api.domain.response.external.employee.GetFollowUserListResponse;
import com.tencent.wework.api.domain.response.external.employee.ListContactWayResponse;
import com.tencent.wework.api.service.EmployeeManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 10:01
 * @version: 1.0
 * @description:
 */
@Slf4j
public class EmployeeManagementDemo implements EmployeeManagementService {
    WeWorkRestUtil restUtil;
    @Autowired
    EmployeeManagementDemo(WeWorkRestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @Override
    public GetFollowUserListResponse getFlowUserList(String corpid, String corpsecret) {
        GetFollowUserListResponse getFollowUserListResponse = restUtil.get(GetFollowUserListResponse.class,
                URL_EXTERNAL_CONTACT_GET_FOLLOW_USER_LIST, corpid, corpsecret);
        log.info("GetFollowUserListResponse:{}", JSON.toJSONString(getFollowUserListResponse));
        return getFollowUserListResponse;
    }

    @Override
    public AddContactWayResponse addContactWay(String corpid, String corpsecret, AddContactWayRequest request) {
        AddContactWayResponse contactWayResponse = restUtil.post(AddContactWayResponse.class,
                URL_ADD_CONTACT_WAY, corpid, corpsecret, request);
        log.info("AddContactWayResponse:{}", JSON.toJSONString(contactWayResponse));
        return contactWayResponse;
    }

    @Override
    public GetContactWayResponse getContactWay(String corpid, String corpsecret, GetContactWayRequest request) {
        GetContactWayResponse getContactWayResponse = restUtil.post(GetContactWayResponse.class,
                URL_GET_CONTACT_WAY, corpid, corpsecret, request);
        log.info("GetContactWayResponse:{}", JSON.toJSONString(getContactWayResponse));
        return getContactWayResponse;
    }

    @Override
    public ListContactWayResponse listContactWay(String corpid, String corpsecret, ListContactWayRequest request) {
        ListContactWayResponse listContactWayResponse = restUtil.post(ListContactWayResponse.class,
                URL_LIST_CONTACT_WAY, corpid, corpsecret, request);
        log.info("ContactWayList:{}", JSON.toJSONString(listContactWayResponse));
        return listContactWayResponse;
    }

    @Override
    public WeWorkResponse updateContactWay(String corpid, String corpsecret, UpdateContactWayRequest request) {
        WeWorkResponse weWorkResponse = restUtil.post(WeWorkResponse.class, URL_UPDATE_CONTACT_WAY,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(weWorkResponse));
        return weWorkResponse;
    }

    @Override
    public WeWorkResponse delContactWay(String corpid, String corpsecret, DelContactWayRequest request) {
        WeWorkResponse weWorkResponse = restUtil.post(WeWorkResponse.class, URL_DEL_CONTACT_WAY,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(weWorkResponse));
        return weWorkResponse;
    }

    @Override
    public WeWorkResponse closeTempChat(String corpid, String corpsecret, CloseTempChatRequest request) {
        WeWorkResponse weWorkResponse = restUtil.post(WeWorkResponse.class, URL_CLOSE_TEMP_CHAT,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(weWorkResponse));
        return weWorkResponse;
    }

}
