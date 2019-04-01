package com.shozo.amqp.producer.taksQueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("taskqueue")
@Service
public class WorkQueueService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	Queue queue;
	
	public void sendMessage(String msg) {
		
		rabbitTemplate.convertAndSend(queue.getName(),msg);
	}
}
