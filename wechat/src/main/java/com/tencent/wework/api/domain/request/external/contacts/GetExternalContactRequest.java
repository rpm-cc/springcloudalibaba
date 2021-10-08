package com.tencent.wework.api.domain.request.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:34
 * @version: 1.0
 * @description:
 */
@Data
public class GetExternalContactRequest implements WeWorkRequest, Serializable {
    private static final long serialVersionUID = 8968844664263980481L;
    /**
     * 外部联系人的userid，注意不是企业成员的帐号
     */
    @JSONField(name = "external_userid")
    private String externalUserid;
    /**
     * 上次请求返回的next_cursor
     */
    private String cursor;

    public static GetExternalContactRequest.Builder builder(){
        return  new GetExternalContactRequest.Builder();
    }
    public static class Builder{
        private GetExternalContactRequest request;
        Builder(){
            request = new GetExternalContactRequest();
        }
        public GetExternalContactRequest.Builder externalUserid(String externalUserid){
            request.setExternalUserid(externalUserid);
            return this;
        }
        public GetExternalContactRequest.Builder cursor(String cursor){
            request.setCursor(cursor);
            return this;
        }
        public GetExternalContactRequest build(){
            return request;
        }
    }

}
