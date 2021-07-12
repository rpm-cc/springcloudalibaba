package com.rpm.demo.inject;

/**
 * @author: Piming Ren
 * @date: 2021/6/25 17:41
 * @version: 1.0
 * @description:
 */
public abstract class MethodAimpl implements DemoService{
    @Override
    public void methodA() {
        System.out.println("A-------A");
    }

}
