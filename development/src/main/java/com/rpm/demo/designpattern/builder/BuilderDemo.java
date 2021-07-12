package com.rpm.demo.designpattern.builder;

/**
 * @Author Piming Ren
 * @Date 2021/3/30 9:40
 * @Version 1.0
 */
public class BuilderDemo {

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal vegMeal  = builder.prepareVegMeal();
        Meal nonMeal  = builder.prepareNonMeal();

        vegMeal.showItems();
        System.out.println("cost:"+vegMeal.getCost());
        nonMeal.showItems();
        System.out.println("cost:"+nonMeal.getCost());



    }
}
