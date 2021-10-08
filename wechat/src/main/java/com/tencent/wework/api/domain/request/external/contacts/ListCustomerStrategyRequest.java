package com.tencent.wework.api.domain.request.external.contacts;

import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 10:51
 * @version: 1.0
 * @description: 获取规则组列表
 */
@Data
public class ListCustomerStrategyRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 7702175269505082896L;
    /**
     * 分页查询游标，首次调用可不填
     */
    private String cursor;
    /**
     * 分页大小,默认为1000，最大不超过1000
     */
    private Integer limit;

    public static ListCustomerStrategyRequest.Builder builder(){
        return new ListCustomerStrategyRequest.Builder();
    }
    public static class Builder {
        ListCustomerStrategyRequest request;

        public Builder() {
            request = new ListCustomerStrategyRequest();
        }

        public ListCustomerStrategyRequest.Builder cursor(String cursor) {
            request.setCursor(cursor);
            return this;
        }

        public ListCustomerStrategyRequest.Builder limit(Integer limit) {
            request.setLimit(limit);
            return this;
        }

        public ListCustomerStrategyRequest build() {
            return request;
        }
    }
}
