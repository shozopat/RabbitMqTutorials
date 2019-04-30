package com.shozo.amqp.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("topic")
@Service
public class TopicService {


	@RabbitListener(queues="#{indiaQueue.name}")
	public void interestedInIndia(String msg) throws InterruptedException {
		System.out.println("recieved msg for India "+msg);
	}
	
	@RabbitListener(queues="#{indiaMaharashtraQueue.name}")
	public void interestedInIndiaMaharashtra(String msg) throws InterruptedException {
		System.out.println("recieved msg for India and Maharashtra "+msg);
	}
	
	@RabbitListener(queues="#{thaneQueue.name}")
	public void interestedInThane(String msg) throws InterruptedException {
		System.out.println("recieved msg for Thane "+msg);
	}
	
	@RabbitListener(queues="#{indiaThaneQueue.name}")
	public void interestedInIndiaThane(String msg) throws InterruptedException {
		System.out.println("recieved msg for India and Thane"+msg);
	}
	
	@RabbitListener(queues="#{mumbaiQueue.name}")
	public void interestedInMumbai(String msg) throws InterruptedException {
		System.out.println("recieved msg for Mumbai "+msg);
	}
}
