package com.example.kafka.controller;

import com.example.kafka.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private KafkaMessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("topic") String topic, @RequestParam("message") String message) {
        messageProducer.sendMessage(topic, message);
        return "Message sent to topic: " + topic;
    }
}
