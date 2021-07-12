package com.rpm.demo.designpattern.builder;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public interface Item {

    String name();
    Packing packing();
    float price();
}
