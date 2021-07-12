package com.rpm.demo.designpattern.singleton;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 *
 * 饿汉式，可能达不到懒加载，lazy loading
 */
public class HungryManSingleton {

    private static  HungryManSingleton instance = new HungryManSingleton();

    private HungryManSingleton(){

    }

    public static HungryManSingleton getInstance(){
        return instance;
    }

    public void out(){
        System.out.println(this.toString());
    }
}
