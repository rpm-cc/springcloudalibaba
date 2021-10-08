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
import org.springframework.stereotype.Service;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 10:01
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class EmployeeManagementDemo implements EmployeeManagementService {
    WeWorkRestUtil restUtil;
    @Autowired
    EmployeeManagementDemo(WeWorkRestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @Override
    public GetFollowUserListResponse getFlowUserList(String corpid, String corpsecret) {
        GetFollowUserListResponse response = restUtil.get(GetFollowUserListResponse.class,
                URL_EXTERNAL_CONTACT_GET_FOLLOW_USER_LIST, corpid, corpsecret);
        log.info("GetFollowUserListResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public AddContactWayResponse addContactWay(String corpid, String corpsecret, AddContactWayRequest request) {
        AddContactWayResponse response = restUtil.post(AddContactWayResponse.class,
                URL_ADD_CONTACT_WAY, corpid, corpsecret, request);
        log.info("response:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public GetContactWayResponse getContactWay(String corpid, String corpsecret, GetContactWayRequest request) {
        GetContactWayResponse response = restUtil.post(GetContactWayResponse.class,
                URL_GET_CONTACT_WAY, corpid, corpsecret, request);
        log.info("GetContactWayResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ListContactWayResponse listContactWay(String corpid, String corpsecret, ListContactWayRequest request) {
        ListContactWayResponse response = restUtil.post(ListContactWayResponse.class,
                URL_LIST_CONTACT_WAY, corpid, corpsecret, request);
        log.info("ContactWayList:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse updateContactWay(String corpid, String corpsecret, UpdateContactWayRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class, URL_UPDATE_CONTACT_WAY,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse delContactWay(String corpid, String corpsecret, DelContactWayRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class, URL_DEL_CONTACT_WAY,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public WeWorkResponse closeTempChat(String corpid, String corpsecret, CloseTempChatRequest request) {
        WeWorkResponse response = restUtil.post(WeWorkResponse.class, URL_CLOSE_TEMP_CHAT,
                corpid, corpsecret, request);
        log.info("WeWorkResponse:{}", JSON.toJSONString(response));
        return response;
    }

}
