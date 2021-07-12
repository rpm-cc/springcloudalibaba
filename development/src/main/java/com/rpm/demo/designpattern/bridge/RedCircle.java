package com.rpm.demo.designpattern.bridge;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int x,int y ,int radius) {

        System.out.println("Draw a RedCircle [radius="+radius+",x="+x+",y="+y);
    }
}
