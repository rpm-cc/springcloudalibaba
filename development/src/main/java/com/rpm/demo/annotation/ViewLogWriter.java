package com.rpm.demo.annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author Piming Ren
 * @Date 2021/1/28 9:13
 * @Version 1.0
 */
@Component
@Aspect
public class ViewLogWriter {

    Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("@annotation(com.rpm.demo.annotation.ViewLog)")
    public void plusPointCut(){

        System.out.println("plusPointcut");
    }


    @Before(value = "plusPointCut()&&@annotation(com.rpm.demo.annotation.ViewLog)")
    public void before(){
        System.out.println("plusPointcut  before");
    }


    @Around(value = "plusPointCut()&&@annotation(com.rpm.demo.annotation.ViewLog)")
    public  Object around(ProceedingJoinPoint point) throws Throwable {

        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();


        Annotation[] annotations  = method.getAnnotations();
        for (Annotation annotation :annotations){
         if(ViewLog.class.getName().equals(annotation.annotationType().getName()) )  {
             System.out.println("==================================");
            }

        }
       // System.out.println("plusPointcut mathPlus value "+mathPlus.value());
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志

        return result;
    }

    @After(value = "plusPointCut()&&@annotation(com.rpm.demo.annotation.ViewLog)")
    public void after(){
        System.out.println("plusPointcut after");
    }
}
