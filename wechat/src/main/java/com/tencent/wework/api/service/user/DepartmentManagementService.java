package com.tencent.wework.api.service.user;

import com.tencent.wework.api.domain.response.user.DepartmentListResponse;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 9:14
 * @version: 1.0
 * @description:
 */
public interface DepartmentManagementService {

    /**
     * 获取部门列表
     *  <pre>
     *   请求方式: POST(HTTP)
     *   详见: https://open.work.weixin.qq.com/api/doc/90000/90135/90208
     *  </pre>
     */
    String URL_DEPARTMENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token={ACCESS_TOKEN}&id={ID}";

    /**
     *
     * @param corpid  企业id
     * @param corpsecret 统续录密钥
     * @param id 部门id。获取指定部门及其下的子部门（以及及子部门的子部门等等，递归）。 如果不填，默认获取全量组织架构
     * @return
     */
    DepartmentListResponse departmentList(String corpid, String corpsecret, Integer id);
}
