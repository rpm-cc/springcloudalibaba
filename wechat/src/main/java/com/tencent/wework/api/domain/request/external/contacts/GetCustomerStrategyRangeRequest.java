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
public class GetCustomerStrategyRangeRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 1318048802908746933L;
    @JSONField(name = "strategy_id")
    private Integer strategyId;

    private Integer limit;
    private String cursor;
    public static GetCustomerStrategyRangeRequest.Builder builder(){
        return  new GetCustomerStrategyRangeRequest.Builder();
    }
    public static class Builder {
        GetCustomerStrategyRangeRequest request;

        public Builder() {
            request = new GetCustomerStrategyRangeRequest();
        }

        public GetCustomerStrategyRangeRequest.Builder strategyId(Integer strategyId) {
            request.setStrategyId(strategyId);
            return this;
        }
        public GetCustomerStrategyRangeRequest.Builder limit(Integer limit){
            request.setLimit(limit);
            return  this;
        }

        public GetCustomerStrategyRangeRequest build() {
            return request;
        }
    }
}
