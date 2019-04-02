package com.shozo.amqp.producer.header;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("header")
@Service
public class HeaderService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	HeadersExchange exchange;
	
	public void sendMessage(String format, String type, String msg) {
		
		Message message = MessageBuilder.withBody(msg.getBytes())
									.setHeader("format", format)
									.setHeader("type", type)
									.build();
		rabbitTemplate.send(exchange.getName(), "", message);
	}
}
