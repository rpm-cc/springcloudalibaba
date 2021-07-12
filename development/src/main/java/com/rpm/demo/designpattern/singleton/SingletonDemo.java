package com.rpm.demo.designpattern.singleton;

/**
 * @Author Piming Ren
 * @Date 2021/3/30 9:41
 * @Version 1.0
 */
public class SingletonDemo {


    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            DoubleCheckedSingleton doubleCheckedSingleton = DoubleCheckedSingleton.getInstance();
            EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
            HungryManSingleton hungryManSingleton = HungryManSingleton.getInstance();
            LazyManSingleton lazyManSingleton = LazyManSingleton.getInstance();
            StaticSingleton staticSingleton = StaticSingleton.getInstance();
            doubleCheckedSingleton.out();
            enumSingleton.out();
            hungryManSingleton.out();
            lazyManSingleton.out();
            staticSingleton.out();

        }

    }
}
