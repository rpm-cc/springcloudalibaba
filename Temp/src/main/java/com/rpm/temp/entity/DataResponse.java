package com.rpm.temp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Piming Ren
 * @date: 2021/9/9 14:24
 * @version: 1.0
 * @description:
 */
@Data
public class DataResponse {

    private String string;

    private Integer integer;

    private Double  _double;

    private Long    _long;

    private BigDecimal bigDecimal;



}
