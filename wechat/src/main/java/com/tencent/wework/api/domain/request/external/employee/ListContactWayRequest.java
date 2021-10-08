package com.tencent.wework.api.domain.request.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 9:01
 * @version: 1.0
 * @description:
 */
@Data
public class ListContactWayRequest implements WeWorkRequest, Serializable {
    private static final long serialVersionUID = 2521520554363824015L;
    @JSONField(name = "start_time")
    private Long startTime;

    @JSONField(name = "end_time")
    private Long endTime;

    private String cursor;

    private Integer limit;


    public static ListContactWayRequest.Builder builder() {
        return new ListContactWayRequest.Builder();
    }

    public static class Builder {
        ListContactWayRequest request ;
        Builder(){
            request  = new ListContactWayRequest();
            request.setLimit(100);
            Long defaultStartTime = LocalDateTime.now().minusDays(90).toEpochSecond(ZoneOffset.of("+8"));
            Long defaultEndTIme  = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
            request.setStartTime(defaultStartTime);
            request.setEndTime(defaultEndTIme);

        }

        public ListContactWayRequest.Builder startTime(Long startTime){
            request.setStartTime(startTime);
            return this;
        }
        public ListContactWayRequest.Builder endTime(Long endTime){
            request.setEndTime(endTime);
            return this;
        }
        public ListContactWayRequest.Builder cursor(String cursor){
            request.setCursor(cursor);
            return this;
        }
        public ListContactWayRequest.Builder limit(Integer limit){
            request.setLimit(limit);
            return this;
        }
        public ListContactWayRequest build(){
            return request;
        }

    }
}
