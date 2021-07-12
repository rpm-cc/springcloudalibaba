package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信 分享位置信息 位置信息类型
 *  需要注意各家地图的经纬度有一定差异。
 */
public class Location {
    /**
     * 经度，单位double
     */
    private double longitude;
    /**
     * 纬度，单位double
     */
    private double latitude;
    /**
     * 地址信息。String类型
     */
    private String address;
    /**
     * 位置信息的title。String类型
     */
    private String title;
    /**
     * 缩放比例。Uint32类型
     */
    private int zoom;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                ", title='" + title + '\'' +
                ", zoom=" + zoom +
                '}';
    }
}
