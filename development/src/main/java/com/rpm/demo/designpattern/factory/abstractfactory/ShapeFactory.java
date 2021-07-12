package com.rpm.demo.designpattern.factory.abstractfactory;

import com.rpm.demo.designpattern.factory.*;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class ShapeFactory extends AbstractFactory{

    public static final String CRICLE = "CRICLE";
    public static final String SQUARE  = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public  Shape getShape(String shapeType){
        Shape shape = null;

        switch (shapeType){
            case CRICLE:
                shape  = new Circle();
                break;
            case SQUARE:
                shape = new Square();
                break;
            case RECTANGLE:
                shape = new Rectangle();
                break;
        }

        return shape;
    }



}
