package com.tencent.wework.api.domain.response.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 14:43
 * @version: 1.0
 * @description:
 */
@Data
public class GetFollowUserListResponse extends WeWorkResponse {
    /**
     * 配置了客户联系功能的成员userid列表
     */
    @JSONField(name = "follow_user")
    private List<String> followUser;
}
