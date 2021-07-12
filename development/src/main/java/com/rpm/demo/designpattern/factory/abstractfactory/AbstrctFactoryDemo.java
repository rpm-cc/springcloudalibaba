package com.rpm.demo.designpattern.factory.abstractfactory;

import com.rpm.demo.designpattern.factory.Color;
import com.rpm.demo.designpattern.factory.Shape;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class AbstrctFactoryDemo{

        public static void main(String[] args) {
            AbstractFactory colorFactory = FactoryProducer.getFactory("color");
            AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

            Color color = colorFactory.getColor(ColorFactory.BLUE);
            Shape shape = shapeFactory.getShape(ShapeFactory.CRICLE);
            color.fill();
            shape.draw();

        }
}
