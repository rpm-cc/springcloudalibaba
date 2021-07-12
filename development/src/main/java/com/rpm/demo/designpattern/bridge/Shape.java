package com.rpm.demo.designpattern.bridge;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract  void draw();
}
