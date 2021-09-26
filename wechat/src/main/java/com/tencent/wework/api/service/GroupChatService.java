package com.tencent.wework.api.service;

import com.tencent.wework.api.domain.GroupChat;
import com.tencent.wework.api.domain.GroupChatList;
import com.tencent.wework.api.domain.query.GroupChatListQuery;
import com.tencent.wework.api.domain.query.GroupChatQuery;

/**
 * @author: Piming Ren
 * @date: 2021/9/24 10:23
 * @version: 1.0
 * @description:
 */
public interface GroupChatService {

    /**
     *  <pre>
     *  获取客户群列表
     *  请求方式POST(https)
     *  详见: https://open.work.weixin.qq.com/api/doc/90000/90135/92120
     *  </pre>
     */
    String GROUPCHAT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/list?access_token={access_token}";

    /**
     * <pre>
     * 获取客户群详情
     * 请求方式POST(https)
     * 详见：https://open.work.weixin.qq.com/api/doc/90000/90135/92122
     * </pre>
     */
    String GROUPCHAT = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/get?access_token={access_token}";


    /**
     * 客户群opengid转换
     * 请求方式：POST（HTTPS）
     */
    String OPENGID_TO_CHATID = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/opengid_to_chatid?access_token={access_token}";
    /**
     * 获取群聊列表
     * @param corpid 企业ID
     * @param secrect 应用密钥
     * @param query 查询条件
     * @return 返回群列表
     */
    GroupChatList getGroupchatList(String corpid, String secrect , GroupChatListQuery query);

    /**
     *  获取群详细信息
     * @param corpid 企业ID
     * @param secrect 应用密钥
     * @param query 查询条件
     * @return 群详情
     */
    GroupChat getGrroupChat(String corpid, String secrect , GroupChatQuery query);

    /**
     * 客户群opengid转换
     * @param corpid 企业ID
     * @param secrect 应用密钥
     * @param opengid 群opengid
     * @return
     */
    String opengidToChatid(String corpid, String secrect ,String opengid);
}
