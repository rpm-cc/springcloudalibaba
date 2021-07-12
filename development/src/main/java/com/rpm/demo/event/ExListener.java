package com.rpm.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author PimingRen
 * @Date 2021/4/1
 * @Version 1.0
 */
@Component
public class ExListener implements ApplicationListener<ExEvent> {
    @Override
    public void onApplicationEvent(ExEvent exEvent) {

        String none = null;
        if (1==1){
            none = exEvent.getCommand();
        }
        System.out.println("receive command is:"+none);
    }
}
