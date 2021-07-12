package com.rpm.demo.thread;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Piming Ren
 * @Date 2021/1/21 10:15
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ThreadPoolTest {
    @Autowired
    ThreadPoolExecutor executor;


    @Test
    public void simpleTest(){

       Runnable runnable = () ->{
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName());

       };

       for (int i=0;i<100;i++) {
           executor.execute(runnable);
       }

       while (true){
           try {
               Thread.sleep(1000);
               System.out.println("loop");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

}
