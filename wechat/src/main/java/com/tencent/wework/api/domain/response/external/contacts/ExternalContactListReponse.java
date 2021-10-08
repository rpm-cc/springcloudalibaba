package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/28 13:59
 * @version: 1.0
 * @description:
 */
@Data
public class ExternalContactListReponse extends WeWorkResponse {

    /**
     *  获取客户列表返回的客户的id集合
     */
    @JSONField(name = "external_userid")
    List<String> externalUserid;
}
