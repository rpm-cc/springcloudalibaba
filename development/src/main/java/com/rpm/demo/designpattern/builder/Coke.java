package com.rpm.demo.designpattern.builder;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
