package com.tencent.wework.api.domain.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/10/20 9:56
 * @version: 1.0
 * @description:
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = 8636789088859787085L;
    private Integer id;
    private String name;
    @JSONField(name = "name_en")
    private String nameEn;
    private Integer parentid;
    private Integer order;
}
