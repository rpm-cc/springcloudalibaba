package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 视频
 */
public class Video {
    /**
     * 资源的md5值，供进行校验。String类型
     */
    private String md5sum;
    /**
     * 语音消息大小。Uint32类型 单位字节
     * 原始json中的字段名称是  voice_size
     */
    private int voiceSize;
    /**
     * 播放长度。Uint32类型 单位 s 秒
     * 原始json中的字段名称是 play_length
     */
    private int playLength;
    /**
     * 媒体资源的id信息。String类型
     */
    private String sdkfileid;

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public int getVoiceSize() {
        return voiceSize;
    }

    public void setVoiceSize(int voiceSize) {
        this.voiceSize = voiceSize;
    }

    public int getPlayLength() {
        return playLength;
    }

    public void setPlayLength(int playLength) {
        this.playLength = playLength;
    }

    public String getSdkfileid() {
        return sdkfileid;
    }

    public void setSdkfileid(String sdkfileid) {
        this.sdkfileid = sdkfileid;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "md5sum='" + md5sum + '\'' +
                ", voiceSize=" + voiceSize +
                ", playLength=" + playLength +
                ", sdkfileid='" + sdkfileid + '\'' +
                '}';
    }
}
