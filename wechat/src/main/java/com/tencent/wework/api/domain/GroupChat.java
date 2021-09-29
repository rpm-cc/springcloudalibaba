package com.tencent.wework.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 17:50
 * @version: 1.0
 * @description:
 */
@Data
public class GroupChat extends WeWorkResponse implements Serializable {

    private static final long serialVersionUID = 1246332723145909576L;
    /**
     * 客户群详情
     */
    @JSONField(name = "group_chat")
    private GroupChatRoom groupChat;

    @Data
    public static class GroupChatRoom{
        /**
         * 客户群ID
         */
        @JSONField(name = "chat_id")
        private String chatId;
        /**
         * 群名
         */
        private String name;
        /**
         * 群主ID
         */
        private String owner;
        /**
         * 	群的创建时间  秒
         */
        @JSONField(name = "create_time")
        private Long createTime;
        /**
         * 群公告
         */
        private String notice;
        /**
         *群成员列表
         */
        @JSONField(name = "member_list")
        private List<Member> memberList;
        /**
         * 一个群中的管理员
         */
        @JSONField(name = "admin_list")
        private List<RoomAdmin> adminList;

    }
    @Data
    public static class Member {
        /**
         * 群成员id
         */
        private String userid;
        /**
         * 成员类型。
         * 1 - 企业成员
         * 2 - 外部联系人
         */
        private int type;
        /**
         * 外部联系人在微信开放平台的唯一身份标识（微信unionid），
         * 通过此字段企业可将外部联系人与公众号/小程序用户关联起来。
         * 仅当群成员类型是微信用户（包括企业成员未添加好友），
         * 且企业或第三方服务商绑定了微信开发者ID有此字段。查看绑定方法
         */
        private String unionid;
        /**
         * 入群时间  秒
         */
        @JSONField(name = "join_time")
        private Long joinTime;
        /**
         *入群方式。
         * 1 - 由群成员邀请入群（直接邀请入群）
         * 2 - 由群成员邀请入群（通过邀请链接入群）
         * 3 - 通过扫描群二维码入群
         */
        @JSONField(name = "join_scene")
        private Long joinScene;
        /**
         * 邀请者。目前仅当是由本企业内部成员邀请入群时会返回该值
         */
        private Invitor invitor;
        /**
         * 在群里的昵称
         */
        @JSONField(name = "group_nickname")
        private String groupNickname;
        /**
         * 名字。仅当 need_name = 1 时返回
         * 如果是微信用户，则返回其在微信中设置的名字
         * 如果是企业微信联系人，则返回其设置对外展示的别名或实名
         */
        private String name;
    }

    @Data
    public static class RoomAdmin {
        /**
         * 群成员id
         */
        private String userid;
    }

    @Data
    public static class Invitor {
        /**
         * 邀请者的userid
         */
        private String userid;
    }

}
