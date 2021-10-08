package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 11:26
 * @version: 1.0
 * @description:
 */
@Data
public class CustomerStrategy implements Serializable {
    private static final long serialVersionUID = 8451506706408671007L;
    /**
     * 规则组id
     */
    @JSONField(name = "strategy_id")
    private Integer strategyId;
    /**
     * 父规则组id， 如果当前规则组没父规则组，则为0
     */
    @JSONField(name = "parent_id")
    private Integer parentId;
    /**
     * 规则组名称
     */
    @JSONField(name = "strategy_name")
    private String  strategyName;
    /**
     * 规则组创建时间戳
     */
    @JSONField(name = "create_time")
    private Long createTime;
    /**
     * 规则组管理员userid列表
     */
    @JSONField(name = "admin_list")
    List<String> adminList;
    /**
     * 基础权限
     */
    Privilege privilege;
}
