package com.rpm.demo.user;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.response.user.UserResponse;
import com.tencent.wework.api.service.user.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 11:17
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class UserManagementDemo implements UserManagementService {
    @Autowired
    WeWorkRestUtil restUtil;
    @Override
    public UserResponse userGet(String corpid, String corpsecret, String userid) {
        UserResponse response  = restUtil.get(UserResponse.class,URL_USER_GET,corpid,corpsecret,userid);
        log.info("DepartmentListResponse:{}", JSON.toJSONString(response));
        return response;
    }
}
