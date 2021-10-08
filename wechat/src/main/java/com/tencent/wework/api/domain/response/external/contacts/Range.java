package com.tencent.wework.api.domain.response.external.contacts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 12:04
 * @version: 1.0
 * @description:
 */
@Data
public class Range implements Serializable {
    private static final long serialVersionUID = 3703976223746618717L;
    /**
     * 节点类型，1-成员 2-部门
     */
    private Integer type ;

    /**
     * 管理范围内配置的成员userid，仅type为1时返回
     */
    private String userid;
    /**
     * 管理范围内配置的部门partyid，仅type为2时返回
     */
    private Integer partyid;
}
