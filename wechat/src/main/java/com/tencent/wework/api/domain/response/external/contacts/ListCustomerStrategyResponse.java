package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 11:11
 * @version: 1.0
 * @description:
 */
@Data
public class ListCustomerStrategyResponse extends WeWorkResponse implements Serializable {

    private static final long serialVersionUID = -2135829231133794530L;
    /**
     * 规则组id集合
     */
    private List<Strategy> strategy;
    /**
     * 分页游标，用于查询下一个分页的数据，无更多数据时不返回
     */
    @JSONField(name = "next_cursor")
    private String nextCursor;

    @Data
    public static class Strategy{
        /**
         * 规则组id
         */
        @JSONField(name = "strategy_id")
        private String strategyId;
    }
}
