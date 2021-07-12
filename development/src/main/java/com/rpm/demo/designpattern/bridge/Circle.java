package com.rpm.demo.designpattern.bridge;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 *
 * Circle 类 当作一个桥梁，讲多个实现的DrawAPI接口的具体实现，统一到一起来使用。各自的实现可以独立。
 */
public class Circle extends Shape {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;

    }

    @Override
    public void draw() {
        drawAPI.drawCircle(x,y,radius);
    }
}
