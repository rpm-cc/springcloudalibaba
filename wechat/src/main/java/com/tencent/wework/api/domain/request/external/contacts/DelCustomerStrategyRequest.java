package com.tencent.wework.api.domain.request.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 11:19
 * @version: 1.0
 * @description:
 */
@Data
public class DelCustomerStrategyRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 1318048802908746933L;
    @JSONField(name = "strategy_id")
    private Integer strategyId;

    public static DelCustomerStrategyRequest.Builder builder(){
        return  new DelCustomerStrategyRequest.Builder();
    }
    public static class Builder {
        DelCustomerStrategyRequest request;

        public Builder() {
            request = new DelCustomerStrategyRequest();
        }

        public DelCustomerStrategyRequest.Builder strategyId(Integer strategyId) {
            request.setStrategyId(strategyId);
            return this;
        }

        public DelCustomerStrategyRequest build() {
            return request;
        }
    }
}
