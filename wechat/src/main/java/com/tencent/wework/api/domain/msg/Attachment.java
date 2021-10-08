package com.tencent.wework.api.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chutian0124
 */
@Data
public class Attachment implements Serializable {
  private static final long serialVersionUID = -8078748379570640198L;

  @JSONField(name = "msgtype")
  private String msgType;

  private Image image;

  private Link link;

  @JSONField(name = "miniprogram")
  private MiniProgram miniProgram;

  private Video video;

  private File file;

  public void setImage(Image image) {
    this.image = image;
    this.msgType = "image";
  }

  public void setLink(Link link) {
    this.link = link;
    this.msgType = "link";
  }

  public void setMiniProgram(MiniProgram miniProgram) {
    this.miniProgram = miniProgram;
    this.msgType = "miniprogram";
  }

  public void setVideo(Video video) {
    this.video = video;
    this.msgType ="video";
  }

  public void setFile(File file ) {
    this.file = file;
    this.msgType = "file";
  }
}
