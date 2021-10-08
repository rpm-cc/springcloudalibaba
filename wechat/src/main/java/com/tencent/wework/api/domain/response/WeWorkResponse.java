package com.tencent.wework.api.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 16:39
 * @version: 1.0
 * @description:
 */
@Data
public class WeWorkResponse implements Serializable {

    private static final long serialVersionUID = -7852423702770736750L;
    /**
     * 出错返回码，为0表示成功，非0表示调用失败
     */
    protected int errcode = 99;

    /**
     * 返回码提示语
     */
    protected String errmsg;


}
