package com.shozo.amqp.consumer.fanout;

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

	
	@RabbitListener(queues="#{firstQueue.name}")
	public void recieveMessage1(String msg) {
		
		System.out.println("Message recieved by Queue 1 is "+msg);
	}
	
	@RabbitListener(queues="#{secondQueue.name}")
	public void recieveMessage2(String msg) {
		
		System.out.println("Message recieved by Queue 2 is "+msg);
	}
}
