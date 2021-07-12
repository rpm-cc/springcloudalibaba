package com.rpm.demo.designpattern.bridge;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class BridgeDemo {

    public static void main(String[] args) {


        //画一个同心圆
        Shape redCircle = new Circle(10,100,100,new RedCircle());
        Shape greenCircle = new Circle(10,100,110,new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

    }
}
