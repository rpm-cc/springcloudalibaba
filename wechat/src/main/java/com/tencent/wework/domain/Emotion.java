package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信  表情
 */
public class Emotion {
    /**
     * 表情类型，png或者gif.1表示gif 2表示png。Uint32类型
     */
    private int type;
    /**
     * 表情图片宽度。Uint32类型
     */
    private int width;
    /**
     * 表情图片高度。Uint32类型
     */
    private int height;
    /**
     * 媒体资源的id信息。String类型
     */
    private String sdkfileid;
    /**
     * 资源的md5值，供进行校验。String类型
     */
    private String md5sum;
    /**
     * 资源的文件大小。Uint32类型
     */
    private int imagesize;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSdkfileid() {
        return sdkfileid;
    }

    public void setSdkfileid(String sdkfileid) {
        this.sdkfileid = sdkfileid;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public int getImagesize() {
        return imagesize;
    }

    public void setImagesize(int imagesize) {
        this.imagesize = imagesize;
    }

    @Override
    public String toString() {
        return "Emotion{" +
                "type=" + type +
                ", width=" + width +
                ", height=" + height +
                ", sdkfileid='" + sdkfileid + '\'' +
                ", md5sum='" + md5sum + '\'' +
                ", imagesize=" + imagesize +
                '}';
    }
}
