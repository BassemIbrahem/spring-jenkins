package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class DemoApplication {
	
	public static final String EXCHANGE_NAME = "tips_tx";
    public static final String DEFAULT_PARSING_QUEUE = "default_parser_q";
    public static final String ROUTING_KEY = "tips";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	 @Bean
	    public TopicExchange tipsExchange() {
	        return new TopicExchange(EXCHANGE_NAME);
	    }

	    @Bean
	    public Queue defaultParsingQueue() {
	        return new Queue(DEFAULT_PARSING_QUEUE);
	    }

	    @Bean
	    public Binding queueToExchangeBinding() {
	        return BindingBuilder.bind(defaultParsingQueue()).to(tipsExchange()).with(ROUTING_KEY);
	    }

	    @Bean
	    public MessageConverter messageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }

	    @Bean
	    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(messageConverter());
	        return rabbitTemplate;
	    }

}
