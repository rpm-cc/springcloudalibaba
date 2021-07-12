package com.rpm.demo.designpattern.factory;

/**
 * @Author Piming Ren
 * @Date 2021/3/30 9:40
 * @Version 1.0
 */
public class FactoryDemo {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape(ShapeFactory.CRICLE);
        Shape square = ShapeFactory.getShape(ShapeFactory.SQUARE);
        Shape rectangle =ShapeFactory.getShape(ShapeFactory.RECTANGLE);

        circle.draw();
        square.draw();
        rectangle.draw();
    }





}
