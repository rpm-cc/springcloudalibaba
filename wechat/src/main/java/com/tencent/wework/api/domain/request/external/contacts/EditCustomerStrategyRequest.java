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
public class EditCustomerStrategyRequest implements WeWorkRequest , Serializable {
    private static final long serialVersionUID = -7547659590216334027L;

    /**
     * 父规则组id， 如果当前规则组没父规则组，则为0
     */
    @JSONField(name = "strategy_id")
    private Integer strategyId;
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
     * 新增的管理范围
     */
    @JSONField(name = "range_add")
    List<Range> rangeAdd;
    /**
     * 要删除的管理范围
     */
    @JSONField(name = "range_del")
    List<Range> rangeDel;

    public static Builder builder(){
        return  new Builder();
    }
    public static class Builder{

        EditCustomerStrategyRequest request ;
        public Builder(){
            request  = new EditCustomerStrategyRequest();
        }

        public Builder strategyId(Integer strategyId){
            request.setStrategyId(strategyId);
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

        public Builder rangeAdd(Range range){
            List<Range> rangeList = request.getRangeAdd();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRangeAdd(rangeList);
            }
            rangeList.add(range);
            return this;
        }
        public Builder rangeAddList(List<Range> ranges){
            List<Range> rangeList = request.getRangeAdd();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRangeAdd(rangeList);
            }
            rangeList.addAll(ranges);
            return this;
        }
        public Builder rangeDel(Range range){
            List<Range> rangeList = request.getRangeDel();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRangeDel(rangeList);
            }
            rangeList.add(range);
            return this;
        }
        public Builder rangeDelList(List<Range> ranges){
            List<Range> rangeList = request.getRangeDel();
            if (rangeList == null){
                rangeList = new ArrayList<>();
                request.setRangeDel(rangeList);
            }
            rangeList.addAll(ranges);
            return this;
        }

        public EditCustomerStrategyRequest build(){
            return request;
        }

    }
}
