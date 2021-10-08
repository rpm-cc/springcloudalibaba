package com.tencent.wework.api.domain.request.external.contacts;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import com.tencent.wework.api.domain.response.external.contacts.Privilege;
import com.tencent.wework.api.domain.response.external.contacts.Range;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/10/8 13:42
 * @version: 1.0
 * @description:
 */
@Data
public class CreateCustomerStrategyRequest implements WeWorkRequest , Serializable {
    private static final long serialVersionUID = -7547659590216334027L;

    /**
     * 父规则组id， 如果当前规则组没父规则组，则为0
     */
    @JSONField(name = "parent_id")
    private Integer parentId;
    /**
     * 规则组名称
     */
    @JSONField(name = "strategy_name")
    private String  strategyName;
    /**
     * 规则组创建时间戳
     */
    @JSONField(name = "create_time")
    private Long createTime;
    /**
     * 规则组管理员userid列表
     */
    @JSONField(name = "admin_list")
    List<String> adminList;
    /**
     * 基础权限
     */
    Privilege privilege;
    /**
     * 管理范围
     */
    List<Range> range;

    public static Builder builder(){
        return  new Builder();
    }
    public static class Builder{

        CreateCustomerStrategyRequest request ;
        public Builder(){
            request  = new CreateCustomerStrategyRequest();
        }

        public Builder parentId(Integer parentId){
            request.setParentId(parentId);
            return this;
        }
        public Builder strategyName(String strategyName){
            request.setStrategyName(strategyName);
            return this;
        }
        public Builder addAdmin(String userid){
            List<String> adminList  = request.getAdminList();
            if (adminList == null){
                adminList = new ArrayList<>();
                request.setAdminList(adminList);
            }
            adminList.add(userid);
            return this;
        }

        public Builder adminList(List<String> admins){
            List<String> adminList  = request.getAdminList();
            if (adminList == null){
                adminList = new ArrayList<>();
                request.setAdminList(adminList);
            }
            adminList.addAll(admins);
            return this;
        }
        public Builder privilege(Privilege privilege){
            request.setPrivilege(privilege);
            return this;
        }
        public Builder addRange(Range range){
            List<Range> rangeList = request.getRange();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRange(rangeList);
            }
            rangeList.add(range);
            return this;
        }
        public Builder rangeList(List<Range> ranges){
            List<Range> rangeList = request.getRange();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRange(rangeList);
            }
            rangeList.addAll(ranges);
            return this;
        }

        public CreateCustomerStrategyRequest build(){
            return request;
        }

    }
}
