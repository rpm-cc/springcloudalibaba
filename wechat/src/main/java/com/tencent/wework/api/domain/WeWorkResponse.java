package com.tencent.wework.api.domain;

import lombok.Data;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 16:39
 * @version: 1.0
 * @description:
 */
@Data
public class WeWorkResponse {

    /**
     * 出错返回码，为0表示成功，非0表示调用失败
     */
    protected int errcode = 99;

    /**
     * 返回码提示语
     */
    protected String errmsg;
}
