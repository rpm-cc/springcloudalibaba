package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 14:04
 * @version: 1.0
 * @description:
 */
@Data
public class GetExternalContactResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = 2963738896151631213L;
    @JSONField(name = "external_contact")
    private ExternalContact externalContact;
    /**
     * 添加了此外部联系人的企业成员
     */
    @JSONField(name = "follow_user")
    List<FollowUser> followUser;

    @JSONField(name="next_cursor")
    private String nextCursor;
}
