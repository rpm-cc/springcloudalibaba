package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/6
 * @Version 1.0
 * 企业微信 图片类型
 */
public class Image {
    /**
     * 图片资源的md5值，供进行校验。String类型
     */
    private String md5sum;
    /**
     * 图片资源的文件大小。Uint32类型
     */
    private int filesize;
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

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public String getSdkfileid() {
        return sdkfileid;
    }

    public void setSdkfileid(String sdkfileid) {
        this.sdkfileid = sdkfileid;
    }

    @Override
    public String toString() {
        return "Image{" +
                "md5sum='" + md5sum + '\'' +
                ", filesize=" + filesize +
                ", sdkfileid='" + sdkfileid + '\'' +
                '}';
    }
}
