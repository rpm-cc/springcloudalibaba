package com.tencent.wework.api.domain.request.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:19
 * @version: 1.0
 * @description:
 */
@Data
public class CloseTempChatRequest implements WeWorkRequest, Serializable {
    private static final long serialVersionUID = -178351902688072734L;
    /**
     * 企业成员的userid
     */
    private String userid;
    /**
     * 客户的外部联系人userid
     */
    @JSONField(name = "external_userid")
    private String externalUserid;

    public static CloseTempChatRequest.Builder builder(){
        return  new CloseTempChatRequest.Builder();
    }
    public static class Builder{
        private CloseTempChatRequest request;
        Builder(){
            request = new CloseTempChatRequest();
        }

        public CloseTempChatRequest.Builder userid(String userid){
            request.setUserid(userid);
            return this;
        }
        public CloseTempChatRequest.Builder externalUserid(String externalUserid){
            request.setExternalUserid(externalUserid);
            return this;
        }

        public CloseTempChatRequest build(){
            return request;
        }
    }
}
