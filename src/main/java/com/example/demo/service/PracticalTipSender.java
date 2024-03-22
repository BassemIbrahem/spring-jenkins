package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
@Service
public class PracticalTipSender {
	public static final String EXCHANGE_NAME = "tips_tx";
    public static final String ROUTING_KEY = "tips";
	
	private static final Logger log = LoggerFactory.getLogger(PracticalTipSender.class);
	private final RabbitTemplate rabbitTemplate;

    public PracticalTipSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendPracticalTip(User user) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, user);
        log.info("Practical Tip sent");
    }

}
