package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 *
 * 音频共享文档消息
 */
public class VoipDocShare {


    /**
     * 文档共享文件名称。String类型
     */
    private String filename;
    /**
     * 	共享文件的md5值。String类型
     */
    private String md5sum;
    /**
     * 共享文件的大小。Uint64类型
     */
    private long filesize;
    /**
     * 	共享文件的sdkfile，通过此字段进行媒体数据下载。String类型
     */
    private String sdkfileid;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
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
        return "VoipDocShare{" +
                "filename='" + filename + '\'' +
                ", md5sum='" + md5sum + '\'' +
                ", filesize=" + filesize +
                ", sdkfileid='" + sdkfileid + '\'' +
                '}';
    }
}
