package com.shozo.amqp.producer.fanout;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("fanout")
@Service
public class FanOutService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	FanoutExchange exchange;
	
	public void sendMessage(String msg) {
		
		rabbitTemplate.convertAndSend(exchange.getName(),"",msg);
	}
}
