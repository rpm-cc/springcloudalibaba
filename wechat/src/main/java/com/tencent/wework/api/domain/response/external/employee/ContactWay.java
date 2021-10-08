package com.tencent.wework.api.domain.response.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.msg.Image;
import com.tencent.wework.api.domain.msg.Link;
import com.tencent.wework.api.domain.msg.MiniProgram;
import com.tencent.wework.api.domain.msg.Text;
import com.tencent.wework.api.domain.request.external.employee.AddContactWayRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 16:21
 * @version: 1.0
 * @description:
 */
@Data
public class ContactWay {
    @JSONField(name = "config_id")
    private String configId;
    private int type;
    private int scene;
    private int style;
    @JSONField(name = "qr_code")
    private String qrCode;
    private String remark;
    @JSONField(name = "skip_verify")
    private Boolean skipVerify;
    private String state;
    private List<String> user;
    private List<Integer> party;
    @JSONField(name = "is_temp")
    private Boolean isTemp;
    @JSONField(name = "expires_in")
    private Long expiresIn;
    @JSONField(name = "chat_expires_in")
    private Long chatExpiresIn;
    private String unionid;

    private AddContactWayRequest.Conclusion conclusions;
    @Data
    public static class Conclusion implements Serializable {
        private static final long serialVersionUID = -4668929889937000713L;
        private Text text;
        private Image image;
        private Link link;
        @JSONField(name = "miniprogram")
        private MiniProgram miniProgram;
    }
}
