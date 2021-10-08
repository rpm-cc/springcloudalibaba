package com.tencent.wework.api.domain.request.external.contacts;

import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 9:37
 * @version: 1.0
 * @description: 修改客户备注信息 请求体
 *
 * remark_company只在此外部联系人为微信用户时有效。
 * remark，description，remark_company，remark_mobiles和remark_pic_mediaid不可同时为空。
 * 如果填写了remark_mobiles，将会覆盖旧的备注手机号。
 * 如果要清除所有备注手机号,请在remark_mobiles填写一个空字符串(“”)。
 * remark_pic_mediaid可以通过素材管理接口获得。
 */
@Data
public class UpdateExternalContactRemarkRequest implements WeWorkRequest {

    /**
     * 企业成员的userid
     * 必填
     */
    private String userid;

    /**
     * 外部联系人userid
     * 必填
     */
    private String external_userid;
    /**
     * 此用户对外部联系人的备注，最多20个字符
     */
    private String remark;
    /**
     * 此用户对外部联系人的描述，最多150个字符
     */
    private String description;
    /**
     * 此用户对外部联系人备注的所属公司名称，最多20个字符
     */
    private String remarkCompany;

    /**
     * 此用户对外部联系人备注的手机号
     */
    private List<String> remarkMobiles;
    /**
     * 备注图片的mediaid，
     * remark_pic_mediaid可以通过素材管理接口获得。
     */
    private String remarkPicMediaid;


}
