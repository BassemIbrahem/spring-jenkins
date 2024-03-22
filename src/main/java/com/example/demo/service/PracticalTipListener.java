package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.example.demo.model.User;
public class PracticalTipListener {
	
    private static final Logger log = LoggerFactory.getLogger(PracticalTipListener.class);
    public static final String DEFAULT_PARSING_QUEUE = "default_parser_q";
    
    @RabbitListener(queues = DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(User user) {
        log.info("Received message, tip is: {}", user.toString());
    }
}
