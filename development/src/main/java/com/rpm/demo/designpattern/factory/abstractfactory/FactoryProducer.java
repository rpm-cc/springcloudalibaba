package com.rpm.demo.designpattern.factory.abstractfactory;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class FactoryProducer {


    public static AbstractFactory getFactory(String choice){

        if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }

       return  null;
    }
}
