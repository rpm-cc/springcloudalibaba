package com.tencent.wework.api.service.user;

import com.tencent.wework.api.domain.response.user.UserResponse;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 9:13
 * @version: 1.0
 * @description:
 */
public interface UserManagementService {

    /**
     * 读取成员
     * <pre>
     *    请求方式：GET
     *    详见：https://open.work.weixin.qq.com/api/doc/90000/90135/90196
     * </pre>
     */
    String URL_USER_GET = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={ACCESS_TOKEN}&userid={USERID}";
    /**
     * 获取部门成员
     * <pre>
     *     请求方式：GET
     *     详见：https://open.work.weixin.qq.com/api/doc/90000/90135/90196
     * </pre>
     */
    String URL_USER_SIMPLELIST = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token={ACCESS_TOKEN}&department_id={DEPARTMENT_ID}&fetch_child={FETCH_CHILD}";
    /**
     * 获取部门成员详情
     * <pre>
     *     请求方式：GET
     *     详见：https://open.work.weixin.qq.com/api/doc/90000/90135/90196
     * </pre>
     */
    String URL_USER_LIST = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token={ACCESS_TOKEN}&department_id={DEPARTMENT_ID}&fetch_child={FETCH_CHILD}";

    /**
     *
     * @param corpid 企业id
     * @param corpsecret 通信录密钥
     * @param userid 企业成员ID
     * @return
     */
    UserResponse userGet(String corpid, String corpsecret, String userid );
}
