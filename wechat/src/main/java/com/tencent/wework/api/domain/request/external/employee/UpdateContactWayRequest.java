package com.tencent.wework.api.domain.request.external.employee;

import com.tencent.wework.api.domain.request.WeWorkRequest;
import com.tencent.wework.api.domain.response.external.employee.ContactWay;
import lombok.Data;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 16:06
 * @version: 1.0
 * @description:
 */
@Data
public class UpdateContactWayRequest extends ContactWay implements WeWorkRequest {


    public static UpdateContactWayRequest.Builder builder() {
        return new UpdateContactWayRequest.Builder();
    }

    public static class Builder {
        UpdateContactWayRequest request;
        Builder() {
            request = new UpdateContactWayRequest();
            request.setSkipVerify(true);
            request.setIsTemp(false);
        }
        public UpdateContactWayRequest.Builder configId(String configId){
            request.setConfigId(configId);
            return this;
        }
        public UpdateContactWayRequest.Builder style(Integer style){
            request.setStyle(style);
            return this;
        }
        public UpdateContactWayRequest.Builder remark(String remark){
            request.setRemark(remark);
            return this;
        }
        public UpdateContactWayRequest.Builder skipVerify(Boolean skipVerify){
            request.setSkipVerify(skipVerify);
            return this;
        }
        public UpdateContactWayRequest.Builder state(String state){
            request.setState(state);
            return this;
        }
        public UpdateContactWayRequest.Builder user(List<String> user){
            request.setUser(user);
            return this;
        }
        public UpdateContactWayRequest.Builder party(List<Integer> party){
            request.setParty(party);
            return this;
        }
        public UpdateContactWayRequest.Builder expiresIn(Long expiresIn){
            request.setExpiresIn(expiresIn);
            return this;
        }
        public UpdateContactWayRequest.Builder chatExpiresIn(Long chatExpiresIn){
            request.setChatExpiresIn(chatExpiresIn);
            return this;
        }
        public  UpdateContactWayRequest.Builder unionid(String unionid){
            request.setUnionid(unionid);
            return this;
        }
        public UpdateContactWayRequest.Builder conclusions(Conclusion conclusions){
            request.setConclusions(conclusions);
            return this;
        }
        public UpdateContactWayRequest build() {
            return request;
        }
    }
}
