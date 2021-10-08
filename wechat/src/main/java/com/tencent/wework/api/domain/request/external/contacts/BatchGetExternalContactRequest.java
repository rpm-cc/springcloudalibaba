package com.tencent.wework.api.domain.request.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/30 11:35
 * @version: 1.0
 * @description:
 */
@Data
public class BatchGetExternalContactRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 626161383992226002L;
    /**
     * 企业成员的userid列表，字符串类型，最多支持100个
     */
    @JSONField(name = "userid_list")
    private List<String> useridList;
    /**
     * 用于分页查询的游标，字符串类型，由上一次调用返回，首次调用可不填
     */
    private String cursor;
    /**
     * 返回的最大记录数，整型，最大值100，默认值50，超过最大值时取最大值
     */
    private Integer limit;


    public static BatchGetExternalContactRequest.Builder builder(){
        return  new BatchGetExternalContactRequest.Builder();
    }
    public static class Builder{
        private BatchGetExternalContactRequest request;
        Builder(){
            request = new BatchGetExternalContactRequest();
        }
        public BatchGetExternalContactRequest.Builder addUserid(String userid){
            List<String> useridList = request.getUseridList();
            if (useridList == null){
                useridList = new ArrayList<>();
                request.setUseridList(useridList);
            }
            useridList.add(userid);
            return this;
        }
        public BatchGetExternalContactRequest.Builder cursor(String cursor){
            request.setCursor(cursor);
            return this;
        }
        public BatchGetExternalContactRequest.Builder limit(Integer limit){
            request.setLimit(limit);
            return this;
        }
        public BatchGetExternalContactRequest build(){
            return request;
        }
    }
}
