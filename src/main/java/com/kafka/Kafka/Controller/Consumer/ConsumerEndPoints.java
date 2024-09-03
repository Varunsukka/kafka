package com.kafka.Kafka.Controller.Consumer;

import com.kafka.Kafka.Service.Consumer.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class ConsumerEndPoints {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumeAll")
    public List<String> consumeAll(){
        List<String> allMessages= consumerService.consumeAll();
        return allMessages;
    }

    @GetMapping("/consumeLastMessage")
    public String consumelastMessage(){
        String lastMessage = consumerService.consumelastMessage();
        return lastMessage !=null? "last consumed message: " +lastMessage: "no Consumed Messages";
        }

}
