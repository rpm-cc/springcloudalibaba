package com.rpm.demo.item;

/**
 * @author: Piming Ren
 * @date: 2021/7/12 15:06
 * @version: 1.0
 * @description:
 */
public class Item{

    private String name;
    private String belong;
    private Type type;
    private String typeName;

    enum Type{
        STRING("java.lang.String"),
        BIGDECIMAL("java.math.BigDecimal"),
        DICTIONARY("java.lang.Map");
        String typeName;
        Type(String typeName) {
            this.typeName = typeName;
        }
    }

}
