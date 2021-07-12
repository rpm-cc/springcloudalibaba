package com.rpm.demo.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author PimingRen
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Meal {

    List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){

        float cost = 0.0f;
        for (Item item:items){
            cost+=item.price();
        }
        return cost;
    }


    public void showItems(){
        System.out.println("-----------------");
        for (Item item:items){

            System.out.println("Item  :"+item.name());
            System.out.println("Packing  :"+item.packing().pack());
            System.out.println("Price  :"+item.price());

        }
    }
}
