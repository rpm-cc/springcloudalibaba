package com.tencent.wework.api.domain.request.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 9:37
 * @version: 1.0
 * @description: 修改客户备注信息 请求体
 * <p>
 * remark_company只在此外部联系人为微信用户时有效。
 * remark，description，remark_company，remark_mobiles和remark_pic_mediaid不可同时为空。
 * 如果填写了remark_mobiles，将会覆盖旧的备注手机号。
 * 如果要清除所有备注手机号,请在remark_mobiles填写一个空字符串(“”)。
 * remark_pic_mediaid可以通过素材管理接口获得。
 */
@Data
public class UpdateRemarkRequest implements WeWorkRequest , Serializable {

    private static final long serialVersionUID = 5174879645831012182L;
    /**
     * 企业成员的userid
     * 必填
     */
    private String userid;

    /**
     * 外部联系人userid
     * 必填
     */
    @JSONField(name = "external_userid")
    private String externalUserid;
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
    @JSONField(name = "remark_company")
    private String remarkCompany;

    /**
     * 此用户对外部联系人备注的手机号
     */
    @JSONField(name = "remark_mobiles")
    private List<String> remarkMobiles;
    /**
     * 备注图片的mediaid，
     * remark_pic_mediaid可以通过素材管理接口获得。
     */
    @JSONField(name = "remark_pic_mediaid")
    private String remarkPicMediaid;

    public static UpdateRemarkRequest.Builder builder() {
        return new UpdateRemarkRequest.Builder();
    }

    public static class Builder {
        UpdateRemarkRequest request;

        public Builder() {
            request = new UpdateRemarkRequest();
        }

        public UpdateRemarkRequest.Builder userid(String userid) {
            request.setUserid(userid);
            return this;
        }

        public UpdateRemarkRequest.Builder externalUserid(String externalUserid) {
            request.setExternalUserid(externalUserid);
            return this;
        }

        public UpdateRemarkRequest.Builder remark(String remark) {
            request.setRemark(remark);
            return this;
        }

        public UpdateRemarkRequest.Builder remarkCompany(String remarkCompany) {
            request.setRemarkCompany(remarkCompany);
            return this;
        }

        public UpdateRemarkRequest.Builder addRemarkMobiles(String remarkMobile) {
            List<String> remarkMobiles = request.getRemarkMobiles();
            if (remarkMobiles == null) {
                remarkMobiles = new ArrayList<>();
                request.setRemarkMobiles(remarkMobiles);
            }
            remarkMobiles.add(remarkMobile);
            return this;
        }

        public UpdateRemarkRequest.Builder remarkPicMediaid(String remarkPidMediaid) {
            request.setRemarkPicMediaid(remarkPidMediaid);
            return this;
        }

        public UpdateRemarkRequest build() {
            return request;
        }

    }

}
