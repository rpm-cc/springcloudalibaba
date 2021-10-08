package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 13:42
 * @version: 1.0
 * @description:
 */
@Data
public class CreateCustomerStrategyResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = -7547659590216334027L;

    /**
     * 	规则组id
     */
    @JSONField(name = "strategy_id")
    private Integer strategyId;

}
