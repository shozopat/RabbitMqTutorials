package com.shozo.amqp.consumer.topic;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("topic")
@Service
public class TopicService {

	
	@RabbitListener(queues="#{firstQueue.name}")
	public void recieveMessage1(String msg) {
		
		System.out.println("Message recieved by Queue 1 is "+msg);
	}
	
	@RabbitListener(queues="#{secondQueue.name}")
	public void recieveMessage2(String msg) {
		
		System.out.println("Message recieved by Queue 2 is "+msg);
	}
}
