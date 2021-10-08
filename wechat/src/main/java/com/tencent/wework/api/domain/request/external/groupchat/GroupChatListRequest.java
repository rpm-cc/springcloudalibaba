package com.tencent.wework.api.domain.request.external.groupchat;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.request.WeWorkRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/23 17:17
 * @version: 1.0
 * @description:
 */
@Data
public class GroupChatListRequest implements WeWorkRequest, Serializable {

    private static final long serialVersionUID = 1348984534736547497L;
    /**
     * 客户群跟进状态过滤。
     * 0 - 所有列表(即不过滤)
     * 1 - 离职待继承
     * 2 - 离职继承中
     * 3 - 离职继承完成
     *
     * 默认为0 有默认值，定义为int
     */
    @JSONField(name = "status_filter")
    private int statusFilter;
    /**
     * 群主过滤。
     * 如果不填，表示获取应用可见范围内全部群主的数据
     * （但是不建议这么用，如果可见范围人数超过1000人，为了防止数据包过大，会报错 81017）
     */
    @JSONField(name = "owner_filter")
    private OwnerFilter ownerFilter;
    /**
     * 用于分页查询的游标，字符串类型，由上一次调用返回，首次调用不填
     */
    private String cursor;
    /**
     * 分页，预期请求的数据量，取值范围 1 ~ 1000
     */
    private int limit;

    @Data
    public static class OwnerFilter {
        /**
         * 用户ID列表。最多100个
         */
        @JSONField(name = "userid_list")
        List<String> useridList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        GroupChatListRequest request;

        Builder() {
            request = new GroupChatListRequest();
        }

       public Builder userid(String userid) {
            OwnerFilter filter = request.getOwnerFilter();
            if (filter == null) {
                filter = new OwnerFilter();
                request.setOwnerFilter(filter);
            }
            List<String> list = filter.getUseridList();
            if (list == null) {
                list = new ArrayList<>();
                filter.setUseridList(list);
            }
            list.add(userid);
            return this;
        }

       public Builder limit(int limit) {
           request.setLimit(limit);
            return this;
        }

       public Builder cursor(String cursor) {
           request.setCursor(cursor);
            return this;
        }

       public Builder statusFilter(int status) {
           request.setStatusFilter(status);
            return this;
        }

       public GroupChatListRequest build() {
            return request;
        }

    }
}
