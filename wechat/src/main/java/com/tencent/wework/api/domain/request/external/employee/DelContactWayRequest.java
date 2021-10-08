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
public class DelContactWayRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 4404082504821122093L;
    @JSONField(name = "config_id")
    private String configId;

    public static DelContactWayRequest.Builder builder() {
        return new DelContactWayRequest.Builder();
    }

    public static class Builder {
        DelContactWayRequest request;

        Builder() {
            request = new DelContactWayRequest();
        }

        public DelContactWayRequest.Builder configId(String configId) {
            request.setConfigId(configId);
            return this;
        }

        public DelContactWayRequest build() {
            return request;
        }

    }
}
