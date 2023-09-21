package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/hello")
    public String hello() {
        try {
            // Логируем успешное сообщение
            System.out.println("Hello, world!");
            kafkaTemplate.send("hello-topic", "Hello, world!");

            return "Hello, world!";
        } catch (Exception e) {
            // Отправляем ошибку в Kafka
            sendErrorToKafka(e);

            return "An error occurred";
        }
    }

    public void sendErrorToKafka(Exception e) {
        String errorMessage = "Error occurred: " + e.getMessage();
        kafkaTemplate.send("error-topic", errorMessage);
    }
}
