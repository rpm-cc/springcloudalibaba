package com.tencent.wework.api.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片消息.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-16
 */
@Data
public class Image implements Serializable {
  private static final long serialVersionUID = -606286372867787121L;

  @JSONField(name = "media_id")
  private String mediaId;

  @JSONField(name = "pic_url")
  private String picUrl;
}
