package com.rpm.demo.flows.example.work;

import org.jeasy.flows.work.*;

/**
 * @author: Piming Ren
 * @date: 2021/7/9 10:34
 * @version: 1.0
 * @description:
 */
public class DefaultWork implements Work {
    String message ;
    public DefaultWork(String message){
        this.message  = message;
    }

    @Override
    public WorkReport execute(WorkContext workContext) {
        System.out.println(message);
        return new DefaultWorkReport(WorkStatus.COMPLETED,workContext);
    }
}
