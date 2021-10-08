package com.tencent.wework.api.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 图文消息.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-16
 */
@Data
public class Link implements Serializable {
  private static final long serialVersionUID = -8041816740881163875L;
  private String title;
  @JSONField(name="picurl")
  private String picUrl;
  private String desc;
  private String url;
}
