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
public class AddContactWayRequest extends ContactWay implements WeWorkRequest {


    public static AddContactWayRequest.Builder builder() {
        return new AddContactWayRequest.Builder();
    }

    public static class Builder {
        AddContactWayRequest request;
        Builder() {
            request = new AddContactWayRequest();
            request.setSkipVerify(true);
            request.setIsTemp(false);
        }
        public AddContactWayRequest.Builder configId(String configId){
            request.setConfigId(configId);
            return this;
        }
        public AddContactWayRequest.Builder type(Integer type){
            request.setType(type);
            return this;
        }
        public AddContactWayRequest.Builder scene(Integer scene){
            request.setScene(scene);
            return this;
        }
        public AddContactWayRequest.Builder style(Integer style){
            request.setStyle(style);
            return this;
        }
        public AddContactWayRequest.Builder remark(String remark){
            request.setRemark(remark);
            return this;
        }
        public AddContactWayRequest.Builder skipVerify(Boolean skipVerify){
            request.setSkipVerify(skipVerify);
            return this;
        }
        public AddContactWayRequest.Builder state(String state){
            request.setState(state);
            return this;
        }
        public AddContactWayRequest.Builder user(List<String> user){
            request.setUser(user);
            return this;
        }
        public AddContactWayRequest.Builder party(List<Integer> party){
            request.setParty(party);
            return this;
        }
        public AddContactWayRequest.Builder isTemp(Boolean isTemp){
            request.setIsTemp(isTemp);
            return this;
        }
        public AddContactWayRequest.Builder expiresIn(Long expiresIn){
            request.setExpiresIn(expiresIn);
            return this;
        }
        public AddContactWayRequest.Builder chatExpiresIn(Long chatExpiresIn){
            request.setChatExpiresIn(chatExpiresIn);
            return this;
        }
        public  AddContactWayRequest.Builder unionid(String unionid){
            request.setUnionid(unionid);
            return this;
        }
        public AddContactWayRequest.Builder conclusions(Conclusion conclusions){
            request.setConclusions(conclusions);
            return this;
        }
        public AddContactWayRequest build() {
            return request;
        }
    }
}
