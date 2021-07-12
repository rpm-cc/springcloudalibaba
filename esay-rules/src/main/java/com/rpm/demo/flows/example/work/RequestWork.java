package com.rpm.demo.flows.example.work;

import org.jeasy.flows.work.Work;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;

import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/7/9 11:33
 * @version: 1.0
 * @description:
 */
public class RequestWork implements Work {
    //定义调用的接口名称集合
    List<String> requestUrl;







    @Override
    public WorkReport execute(WorkContext workContext) {
        return null;
    }
}
