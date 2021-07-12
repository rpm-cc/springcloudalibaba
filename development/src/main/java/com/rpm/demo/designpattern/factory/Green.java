package com.rpm.demo.designpattern.factory;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Fill Green color");
    }
}
