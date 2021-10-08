package com.tencent.wework.api.domain.response.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 16:23
 * @version: 1.0
 * @description:
 */
@Data
public class GetContactWayResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = -5143903104537371757L;
    @JSONField(name = "contact_way")
    private ContactWay contactWay;



}
