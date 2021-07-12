package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信  文件类型
 */
public class File {
    /**
     * 媒体资源的id信息。String类型
     */
    private String sdkfileid;
    /**
     * 	资源的md5值，供进行校验。String类型
     */
    private String md5sum;
    /**
     * 	文件名称。String类型
     */
    private String filename;
    /**
     * 文件类型后缀。String类型
     */
    private String fileext	;
    /**
     * 	文件大小。Uint32类型
     */
    private int filesize;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileext() {
        return fileext;
    }

    public void setFileext(String fileext) {
        this.fileext = fileext;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "File{" +
                "sdkfileid='" + sdkfileid + '\'' +
                ", md5sum='" + md5sum + '\'' +
                ", filename='" + filename + '\'' +
                ", fileext='" + fileext + '\'' +
                ", filesize=" + filesize +
                '}';
    }
}
