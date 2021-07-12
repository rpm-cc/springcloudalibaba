package com.rpm.demo.designpattern.singleton;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 * 使用静态内部类的方式，能够达到双重校验方式的效果。而且具有更好的lazy loading效果
 */
public class StaticSingleton {

    private static class SingletonHolder{
        private static final StaticSingleton INSTANCE= new StaticSingleton();
    }

    private StaticSingleton(){

    }

    public static final StaticSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public void out(){
        System.out.println(this.toString());
    }
}
