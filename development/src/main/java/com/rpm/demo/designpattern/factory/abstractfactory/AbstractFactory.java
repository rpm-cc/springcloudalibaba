package com.rpm.demo.designpattern.factory.abstractfactory;

import com.rpm.demo.designpattern.factory.Color;
import com.rpm.demo.designpattern.factory.Shape;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);

}
