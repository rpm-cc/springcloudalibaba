package com.rpm.demo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerGroupMetadata;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {



    @KafkaListener(topics = {"topic1"})
    public void OnRecive1(ConsumerRecord<String,Object> record, Consumer consumer){
        ConsumerGroupMetadata consumerGroupMetadata = consumer.groupMetadata();
        System.out.println("groupId:"+consumerGroupMetadata.groupId());
        System.out.println("simple consumer1：topic="+record.topic()+"  partition="+record.partition()+"  key="+record.key()+" value=" + record.value());
    }

}
