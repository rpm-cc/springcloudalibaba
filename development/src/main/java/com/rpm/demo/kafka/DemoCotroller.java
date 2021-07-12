package com.rpm.demo.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class DemoCotroller {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/send")
    public String send(){
        int i= 0;
        while (i<20){
            i++;
            kafkaTemplate.send("topic1",0,"ddd","message【消息】 from topic1 is :  ["+i+"]");
            kafkaTemplate.send("topic1","message【消息】 from topic1 is :  ["+i+"]");
            if (i%10==0){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        return "send";
    }
}
