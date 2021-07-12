package com.rpm.demo.designpattern.singleton;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 * 绝对防止多次实例化
 */
public enum EnumSingleton {
    INSTANCE;

    public void out(){
        System.out.println(this.toString());
    }
}
