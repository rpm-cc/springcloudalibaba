package com.rpm.demo.designpattern.builder;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing(){
        return new Bottle();
    }
    @Override
    public abstract  float price();
}
