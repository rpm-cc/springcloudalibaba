package com.tencent.wework.api.domain.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import com.tencent.wework.api.domain.response.external.contacts.ExternalProfile;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 10:42
 * @version: 1.0
 * @description:
 */
@Data
public class User extends WeWorkResponse {

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     */
    private String userid;
    /**
     * 成员名称；第三方不可获取，调用时返回userid以代替name；
     * 代开发自建应用需要管理员授权才返回；对于非第三方创建的成员，
     * 第三方通讯录应用也不可获取；未返回name的情况需要通过通讯录展示组件来展示名字
     */
    private String name;
    /**
     * 成员所属部门id列表，仅返回该应用有查看权限的部门id；成员授权模式下，固定返回根部门id，即固定为1
     */
    private List<Integer> department;
    /**
     * 部门内的排序值，默认为0。数量必须和department一致，
     * 数值越大排序越前面。值范围是[0, 2^32)。成员授权模式下不返回该字段
     */
    private List<Integer> order;
    /**
     * 职务信息；代开发自建应用需要管理员授权才返回；第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String position;
    /**
     * 手机号码，代开发自建应用需要管理员授权才返回；第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String mobile;
    /**
     * 性别。0表示未定义，1表示男性，2表示女性
     * todo 需要定义常量
     */
    private String gender;
    /**
     * 邮箱，代开发自建应用需要管理员授权才返回；第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String email;
    /**
     * 表示在所在的部门内是否为上级。；第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    @JSONField(name = "is_leader_in_dept")
    private List<Integer> isLeaderInDept;
    /**
     * 头像url。 第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String avatar;
    /**
     * 头像缩略图url。第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    @JSONField(name = "thumb_avatar")
    private String thumbAvatar;
    /**
     * 座机。代开发自建应用需要管理员授权才返回；第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String telephone;
    /**
     * 别名；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String alias;
    /**
     * 地址。代开发自建应用需要管理员授权才返回；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private String address;
    /**
     * 全局唯一。对于同一个服务商，不同应用获取到企业内同一个成员的open_userid是相同的，最多64个字节。仅第三方应用可获取
     */
    @JSONField(name = "open_userid")
    private String openUserid;
    /**
     * 主部门
     */
    @JSONField(name = "main_department")
    private Integer mainDepartment;
    /**
     * 扩展属性，代开发自建应用需要管理员授权才返回；
     * 第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    private Extattr extattr;
    /**
     * 激活状态: 1=已激活，2=已禁用，4=未激活，5=退出企业。
     * 已激活代表已激活企业微信或已关注微工作台（原企业号）。未激活代表既未激活企业微信又未关注微工作台（原企业号）。
     * todo 需要定义常量
     */
    private Integer status;
    /**
     * 员工个人二维码，扫描可添加为外部联系人(注意返回的是一个url，可在浏览器上打开该url以展示二维码)；
     * 第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    @JSONField(name = "qr_code")
    private String qrCode;
    /**
     * 对外职务，如果设置了该值，则以此作为对外展示的职务，否则以position来展示。
     * 代开发自建应用需要管理员授权才返回；
     * 第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    @JSONField(name = "external_position")
    private String externalPosition;
    /**
     * 成员对外属性，字段详情见对外属性；
     * 代开发自建应用需要管理员授权才返回；
     * 第三方仅通讯录应用可获取；
     * 对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    @JSONField(name = "external_profile")
    private ExternalProfile externalProfile;

    /**
     * 扩展属性，代开发自建应用需要管理员授权才返回；
     * 第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取
     */
    public static class Extattr{
        List<ExternalProfile.ExternalAttr> attrs;
    }
}
