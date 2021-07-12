package com.rpm.demo.designpattern.factory;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}
