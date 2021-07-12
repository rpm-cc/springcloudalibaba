package com.rpm.demo.designpattern.factory.abstractfactory;

import com.rpm.demo.designpattern.factory.*;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class ColorFactory  extends AbstractFactory{

    public static final String RED = "RED";
    public static final String GREEN = "GREEN";
    public static final String BLUE  = "BLUE";

    @Override
    public  Color getColor(String colorType){

        Color color = null;

        switch (colorType){
            case RED:
                color  = new Red();
                break;
            case GREEN:
                color = new Green();
                break;
            case BLUE:
                color = new Blue();
                break;
        }
        return color;

    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }


}
