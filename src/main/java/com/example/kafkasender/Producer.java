package com.example.kafkasender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplateObject;

    public void publishToTopic(String topic, String message){
        System.out.println("Publishing to topic: " + topic);
        this.kafkaTemplate.send(topic,message);
    }

    public void publishJson(String topic, User user){
        System.out.println("Publishing to topic: " + topic);
        System.out.println("Publishing user: " + user);
        this.kafkaTemplateObject.send(topic, user);
    }
}
