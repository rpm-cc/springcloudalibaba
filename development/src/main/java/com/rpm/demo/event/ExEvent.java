package com.rpm.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author PimingRen
 * @Date 2021/4/1
 * @Version 1.0
 */
public class ExEvent extends ApplicationEvent {

    private final String command ;

    public ExEvent(Object source,String command) {
        super(source);
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
    @Override
    public Object getSource() {
        return super.getSource();
    }
}
