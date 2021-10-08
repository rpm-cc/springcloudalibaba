package com.tencent.wework.api.domain.response.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 13:32
 * @version: 1.0
 * @description:
 */
@Data
public class GetCustomerStrategyRangeResponse extends WeWorkResponse implements Serializable {
    private static final long serialVersionUID = -2373514755171641963L;
    private List<Range> range;
    @JSONField(name = "next_cursor")
    private String nextCursor;

}
