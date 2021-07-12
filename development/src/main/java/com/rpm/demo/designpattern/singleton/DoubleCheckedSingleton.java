package com.rpm.demo.designpattern.singleton;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class DoubleCheckedSingleton {
    // 使用volatile 使实例尽可能的保持同步
    private volatile  static  DoubleCheckedSingleton instance;
    private DoubleCheckedSingleton(){

    }

    /**
     * 双重校验的单例模式。 double-checked locking
     * @return
     */
    public static DoubleCheckedSingleton getInstance(){
        if (instance == null) {
            //同步锁 再次进行校验
            synchronized (DoubleCheckedSingleton.class){
                if (instance == null){
                    instance  = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
    public void out(){
        System.out.println(this.toString());
    }

}
