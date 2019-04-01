package com.shozo.amqp.producer.basic;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("basic")
@Service
public class BasicService {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;

	
	public void sendMessage(String msg) {
		template.convertAndSend(queue.getName(),msg);
	}

}
