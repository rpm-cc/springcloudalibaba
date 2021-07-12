package com.rpm.demo.designpattern.builder;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
    @Override
    public abstract float price();
}
