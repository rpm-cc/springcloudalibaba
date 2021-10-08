package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 15:03
 * @version: 1.0
 * @description:
 */
@Data
public class BatchGetExternalContactResponse extends WeWorkResponse {

    @JSONField(name = "external_contact_list")
    private List<ExternalContactList> externalContactListList;
    @JSONField(name = "next_cursor")
    private String nextCursor;
    @Data
    public static class ExternalContactList{
        @JSONField(name = "external_contact")
        private ExternalContact externalContact;
        @JSONField(name = "follow_info")
        private FollowUser followInfo;
    }
}
