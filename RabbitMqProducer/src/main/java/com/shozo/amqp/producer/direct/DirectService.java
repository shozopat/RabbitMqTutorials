package com.shozo.amqp.producer.direct;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("direct")
@Service
public class DirectService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	DirectExchange exchange;
	
	public void sendMessage(String msg, String routingKey) {
		
		rabbitTemplate.convertAndSend(exchange.getName(),routingKey,msg);
	}
}
