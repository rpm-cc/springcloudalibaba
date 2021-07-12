package com.rpm.demo.designpattern.singleton;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class LazyManSingleton {

    private static LazyManSingleton instance;

    private LazyManSingleton(){

    }

    /**
     *   线程不安全的懒汉式
     */

    public static LazyManSingleton getInstance(){

        if(instance ==null){
            instance = new LazyManSingleton();
        }
        return instance;
    }

    /**
     * 线程安全的懒汉式
     */

    public static synchronized  LazyManSingleton getInstanceSafety(){
        if(instance != null){
            instance = new LazyManSingleton();
        }
        return instance;
    }

    public void out(){
        System.out.println(this.toString());
    }

}
