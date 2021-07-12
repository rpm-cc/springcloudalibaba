package com.rpm.demo.designpattern.builder;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class MealBuilder {


    public Meal prepareVegMeal(){

        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());

        return meal;
    }

    public Meal prepareNonMeal(){

        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());

        return meal;
    }
}
