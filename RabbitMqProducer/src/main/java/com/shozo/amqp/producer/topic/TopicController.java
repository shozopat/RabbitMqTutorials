package com.shozo.amqp.producer.topic;

import java.util.Map;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("topic")
@RequestMapping("producer")
@RestController
public class TopicController {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	TopicExchange topicExchange;
	
	
	@PostMapping()
	public void sendMessage(@RequestBody Map<String,String> msg) {
		
		rabbitTemplate.convertAndSend(topicExchange.getName(), msg.get("key"), msg.get("value"));

	}
}
