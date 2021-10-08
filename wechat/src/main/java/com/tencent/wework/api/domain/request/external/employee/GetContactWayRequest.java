package com.tencent.wework.api.domain.request.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:09
 * @version: 1.0
 * @description:
 */
@Data
public class GetContactWayRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 4404082504821122093L;
    @JSONField(name = "config_id")
    private String configId;

    public static GetContactWayRequest.Builder builder() {
        return new GetContactWayRequest.Builder();
    }

    public static class Builder {
        GetContactWayRequest request;

        Builder() {
            request = new GetContactWayRequest();
        }

        public GetContactWayRequest.Builder configId(String configId) {
            request.setConfigId(configId);
            return this;
        }

        public GetContactWayRequest build() {
            return request;
        }

    }

}
