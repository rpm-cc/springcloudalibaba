package com.tencent.wework.api.service;

import com.tencent.wework.api.domain.request.external.employee.*;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.employee.AddContactWayResponse;
import com.tencent.wework.api.domain.response.external.employee.GetContactWayResponse;
import com.tencent.wework.api.domain.response.external.employee.GetFollowUserListResponse;
import com.tencent.wework.api.domain.response.external.employee.ListContactWayResponse;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 9:58
 * @version: 1.0
 * @description: 对应 客户联系->企业服务人员管理
 */
public interface EmployeeManagementService {
    /**
     * <pre>
     * 获取配置了客户联系功能的成员列表
     * 请求方式：GET（HTTPS）
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92571
     * </pre>
     */
    String URL_EXTERNAL_CONTACT_GET_FOLLOW_USER_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_follow_user_list?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  配置客户联系「联系我」方式
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_ADD_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/add_contact_way?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  获取企业已配置的「联系我」方式
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_GET_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get_contact_way?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  获取企业已配置的「联系我」列表
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_LIST_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/list_contact_way?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  更新企业已配置的「联系我」方式
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_UPDATE_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/update_contact_way?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  删除企业已配置的「联系我」方式
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_DEL_CONTACT_WAY = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/del_contact_way?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *  结束临时会话
     *  请求方式：POST（HTTPS）
     *  详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92572
     * </pre>
     */
    String URL_CLOSE_TEMP_CHAT = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/close_temp_chat?access_token={ACCESS_TOKEN}";
    /**
     * 获取配置了客户联系功能的成员列表
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @return 配置了客户联系功能的成员
     */
    GetFollowUserListResponse getFlowUserList(String corpid, String corpsecret);

    /**
     * 配置客户联系「联系我」方式
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    AddContactWayResponse addContactWay(String corpid, String corpsecret, AddContactWayRequest request);

    /**
     * 获取企业已配置的「联系我」方式
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    GetContactWayResponse getContactWay(String corpid, String corpsecret, GetContactWayRequest request);
    /**
     * 获取企业已配置的「联系我」列表
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    ListContactWayResponse listContactWay(String corpid, String corpsecret, ListContactWayRequest request);
    /**
     * 更新企业已配置的「联系我」方式
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    WeWorkResponse updateContactWay(String corpid, String corpsecret, UpdateContactWayRequest request);
    /**
     * 删除企业已配置的「联系我」方式
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    WeWorkResponse delContactWay(String corpid, String corpsecret, DelContactWayRequest request);

    /**
     * 结束临时会话
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    WeWorkResponse closeTempChat(String corpid,String corpsecret,CloseTempChatRequest request);
}
