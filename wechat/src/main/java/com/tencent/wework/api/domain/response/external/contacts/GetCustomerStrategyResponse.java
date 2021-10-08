package com.tencent.wework.api.domain.response.external.contacts;

import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 11:23
 * @version: 1.0
 * @description:
 */
@Data
public class GetCustomerStrategyResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = 424492909781297020L;

    CustomerStrategy strategy;

}
