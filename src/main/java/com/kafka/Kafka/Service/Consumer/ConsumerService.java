package com.kafka.Kafka.Service.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    private String consumedLastMessage;
    private final List<String> consumedMessages = new ArrayList<>();

    @KafkaListener(topics = "first_topic",groupId = "group_id")
    public void consume(String message){
        consumedLastMessage=message;
        consumedMessages.add(message);
        System.out.println("lastmessage "+consumedLastMessage);
    }
    public String consumelastMessage() {
        return consumedLastMessage;
    }

    public List<String> consumeAll() {
        return new ArrayList<>(consumedMessages);
    }
}
