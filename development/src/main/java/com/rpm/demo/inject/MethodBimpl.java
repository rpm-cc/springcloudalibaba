package com.rpm.demo.inject;

/**
 * @author: Piming Ren
 * @date: 2021/6/25 17:43
 * @version: 1.0
 * @description:
 */
public class MethodBimpl extends  MethodAimpl{
    @Override
    public void methodB() {
        System.out.println("B---------B");
    }

    @Override
    public void methodC() {
        System.out.println("B----------C");
    }
}
