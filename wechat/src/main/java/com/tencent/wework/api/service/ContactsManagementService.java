package com.tencent.wework.api.service;

import com.tencent.wework.api.domain.request.external.contacts.BatchGetExternalContactRequest;
import com.tencent.wework.api.domain.request.external.contacts.GetExternalContactRequest;
import com.tencent.wework.api.domain.request.external.contacts.UpdateExternalContactRemarkRequest;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.contacts.BatchGetExternalContactResponse;
import com.tencent.wework.api.domain.response.external.contacts.ExternalContactListReponse;
import com.tencent.wework.api.domain.response.external.contacts.GetExternalContactResponse;

/**
 * @author: Piming Ren
 * @date: 2021/9/26 18:00
 * @version: 1.0
 * @description:
 * 对应 客户联系-> 客户管理
 */
public interface ContactsManagementService {

      /**
     * <pre>
     * 获取客户列表
     * 请求方式：GET（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92113
     * </pre>
     */
    String URL_EXTERNAL_CONTACT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/list?access_token={access_token}&userid={userid}";
    /**
     * <pre>
     * 获取客户详情
     * 请求方式：GET（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92114
     * </pre>
     */
    String URL_EXTERNAL_CONTACT_GET = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get?access_token={access_token}";


    /**
     * <pre>
     * 批量获取客户详情
     * 请求方式：POST（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92994
     * </pre>
     */

    String URL_EXTERNAL_CONTACT_BATCH = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/batch/get_by_user?access_token={access_token}";

    /**
     * <pre>
     *   修改客户备注信息
     *   请求方式: POST(HTTP)
     *   详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92115
     *  </pre>
     */

    String URL_EXTERNAL_CONTACT_REMARK = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/remark?access_token={access_token}";


    /**
     * 企业可通过此接口获取指定成员添加的客户列表。
     * 客户是指配置了客户联系功能的成员所添加的外部联系人。
     * 没有配置客户联系功能的成员，
     * 所添加的外部联系人将不会作为客户返回
     *
     * @param corpid
     * @param corpsecret
     * @param userid
     * @return
     */
    ExternalContactListReponse list(String corpid, String corpsecret, String userid);

    /**
     * 获取客户详情
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    GetExternalContactResponse get(String corpid , String corpsecret, GetExternalContactRequest request);

    /**
     * 批量过去客户详情
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    BatchGetExternalContactResponse batchGet(String corpid, String corpsecret, BatchGetExternalContactRequest request);
    /**
     * 修改客户备注信息
     * @param corpid 企业id
     * @param corpsecret 对应的密钥
     * @param request 请求体
     * @return
     */
    WeWorkResponse updateCustomerRemark(String corpid, String corpsecret, UpdateExternalContactRemarkRequest request);

}
