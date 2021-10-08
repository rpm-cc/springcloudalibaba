package com.tencent.wework.api.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 视频消息
 *
 * @author pg
 * @date 2021-6-21
 */
@Data
public class Video implements Serializable {
  private static final long serialVersionUID = -6048642921382867138L;
  @JSONField(name = "media_id")
  private String mediaId;
}
