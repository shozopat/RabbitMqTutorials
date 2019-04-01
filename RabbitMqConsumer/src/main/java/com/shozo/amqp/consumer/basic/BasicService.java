package com.shozo.amqp.consumer.basic;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("basic")
@Service
public class BasicService {


	@RabbitListener(queues= "hello")
	public void recieveMessage(String msg) throws InterruptedException {
		System.out.println("Message recieved "+msg);
	}

}
