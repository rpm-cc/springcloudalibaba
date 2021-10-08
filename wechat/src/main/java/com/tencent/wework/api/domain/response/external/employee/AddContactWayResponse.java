package com.tencent.wework.api.domain.response.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 17:37
 * @version: 1.0
 * @description:
 */
@Data
public class AddContactWayResponse extends WeWorkResponse implements Serializable {

    @JSONField(name = "config_id")
    private String configId;@JSONField(name = "qr_code")
    private String qrCode;
}
