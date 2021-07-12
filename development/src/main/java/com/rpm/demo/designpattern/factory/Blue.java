package com.rpm.demo.designpattern.factory;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Fill Blue color");
    }
}
