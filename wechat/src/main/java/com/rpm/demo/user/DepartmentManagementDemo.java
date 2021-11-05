package com.rpm.demo.user;

import com.alibaba.fastjson.JSON;
import com.rpm.wechat.util.WeWorkRestUtil;
import com.tencent.wework.api.domain.response.user.DepartmentListResponse;
import com.tencent.wework.api.service.user.DepartmentManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 9:52
 * @version: 1.0
 * @description:
 */
@Service
@Slf4j
public class DepartmentManagementDemo implements DepartmentManagementService {

    @Autowired
    WeWorkRestUtil restUtil;


    @Override
    public DepartmentListResponse departmentList(String corpid, String corpsecret, Integer id) {

        DepartmentListResponse response  =  restUtil.get(DepartmentListResponse.class,URL_DEPARTMENT_LIST,corpid,corpsecret,id);
        log.info("DepartmentListResponse:{}", JSON.toJSONString(response));
        return response;

    }
}
