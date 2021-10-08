package com.tencent.wework.api.service;

import com.tencent.wework.api.domain.request.external.contacts.*;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.contacts.*;

/**
 * @author: Piming Ren
 * @date: 2021/9/26 18:00
 * @version: 1.0
 * @description: 对应 客户联系-> 客户管理
 */
public interface ContactsManagementService {

    /**
     * <pre>
     * 获取客户列表
     * 请求方式：GET（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92113
     * </pre>
     */
    String URL_EXTERNAL_CONTACT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/list?access_token={ACCESS_TOKEN}&userid={userid}";
    /**
     * <pre>
     * 获取客户详情
     * 请求方式：GET（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92114
     * </pre>
     */
    String URL_EXTERNAL_CONTACT_GET = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get?access_token={ACCESS_TOKEN}";


    /**
     * <pre>
     * 批量获取客户详情
     * 请求方式：POST（HTTPS）
     * 详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92994
     * </pre>
     */

    String URL_EXTERNAL_CONTACT_BATCH = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/batch/get_by_user?access_token={ACCESS_TOKEN}";

    /**
     * <pre>
     *   修改客户备注信息
     *   请求方式: POST(HTTP)
     *   详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92115
     *  </pre>
     */

    String URL_EXTERNAL_CONTACT_REMARK = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/remark?access_token={ACCESS_TOKEN}";

    /**************************************************************
     * 客户联系规则组 Customer_strategy
     **************************************************************/

    /**
     * 获取规则组列表
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/list?access_token={ACCESS_TOKEN}";

    /**
     * 获取规则组管理范围
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_GET = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/get?access_token={ACCESS_TOKEN}";

    /**
     * 获取规则组详情
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_GET_RANGE = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/get_range?access_token={ACCESS_TOKEN}";
    /**
     * 创建新的规则组
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_CREATE ="https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/create?access_token={ACCESS_TOKEN}";

    /**
     * 编辑规则组及其管理范围
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_EDIT ="https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/edit?access_token={ACCESS_TOKEN}";
      /**
     * 删除规则组
     * 请求方式: POST(HTTP)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/94883
     */
    String URL_CUSTOMER_STRATEGY_DEL ="https://qyapi.weixin.qq.com/cgi-bin/externalcontact/customer_strategy/del?access_token={ACCESS_TOKEN}";

    /**
     * 企业可通过此接口获取指定成员添加的客户列表。
     * 客户是指配置了客户联系功能的成员所添加的外部联系人。
     * 没有配置客户联系功能的成员，
     * 所添加的外部联系人将不会作为客户返回
     * @param corpid
     * @param corpsecret
     * @param userid
     * @return
     */
    ExternalContactListReponse list(String corpid, String corpsecret, String userid);

    /**
     * 获取客户详情
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    GetExternalContactResponse get(String corpid, String corpsecret, GetExternalContactRequest request);

    /**
     * 批量过去客户详情
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    BatchGetExternalContactResponse batchGet(String corpid, String corpsecret, BatchGetExternalContactRequest request);

    /**
     * 修改客户备注信息
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    WeWorkResponse updateRemark(String corpid, String corpsecret, UpdateRemarkRequest request);

    /**
     * 获取规则组列表
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    ListCustomerStrategyResponse listCustomerStrategy(String corpid, String corpsecret, ListCustomerStrategyRequest request);
    /**
     * 获取规则组详情
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    GetCustomerStrategyResponse getCustomerStrategy(String corpid, String corpsecret, GetCustomerStrategyRequest request);

    /**
     * 获取规则组管理范围
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    GetCustomerStrategyRangeResponse getRange(String corpid,String corpsecret,GetCustomerStrategyRangeRequest request);

    /**
     * 获取规则组管理范围
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    CreateCustomerStrategyResponse createCustomerStrategy(String corpid,String corpsecret,CreateCustomerStrategyRequest request);
    /**
     * 编辑规则组及其管理范围
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    WeWorkResponse editCustomerStrategy(String corpid,String corpsecret,EditCustomerStrategyRequest request);
    /**
     * 删除规则组及其管理范围
     * @param corpid     企业id
     * @param corpsecret 对应的密钥
     * @param request    请求体
     * @return
     */
    WeWorkResponse delCustomerStrategy(String corpid,String corpsecret,DelCustomerStrategyRequest request);
}
