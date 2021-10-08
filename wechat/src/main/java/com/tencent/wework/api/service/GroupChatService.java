package com.tencent.wework.api.service;

import com.tencent.wework.api.domain.response.external.groupchat.GroupChatGetResponse;
import com.tencent.wework.api.domain.response.external.groupchat.GroupChatListResponse;
import com.tencent.wework.api.domain.request.external.groupchat.GroupChatListRequest;
import com.tencent.wework.api.domain.request.external.groupchat.GroupChatGetRequest;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 10:23
 * @version: 1.0
 * @description: 对应 客户联系->客户群管理
 */
public interface GroupChatService{

    /**
     *  <pre>
     *  获取客户群列表
     *  请求方式POST(https)
     *  详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92120
     *  </pre>
     */
    String URL_GROUPCHAT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/list?access_token={access_token}";

    /**
     * <pre>
     * 获取客户群详情
     * 请求方式POST(https)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92122
     * </pre>
     */
    String URL_GROUPCHAT = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/get?access_token={access_token}";


    /**
     * 客户群opengid转换
     * 请求方式：POST（HTTPS）
     */
    String URL_OPENGID_TO_CHATID = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/opengid_to_chatid?access_token={access_token}";
    /**
     * 获取群聊列表
     * @param corpid 企业ID
     * @param corpsecret 应用密钥
     * @param query 查询条件
     * @return 返回群列表
     */
    GroupChatListResponse getGroupchatList(String corpid, String corpsecret , GroupChatListRequest query);

    /**
     *  获取群详细信息
     * @param corpid 企业ID
     * @param corpsecret 应用密钥
     * @param query 查询条件
     * @return 群详情
     */
    GroupChatGetResponse getGrroupChat(String corpid, String corpsecret , GroupChatGetRequest query);

    /**
     * 客户群opengid转换
     * @param corpid 企业ID
     * @param corpsecret 应用密钥
     * @param opengid 群opengid
     * @return
     */
    String opengidToChatid(String corpid, String corpsecret ,String opengid);
}
