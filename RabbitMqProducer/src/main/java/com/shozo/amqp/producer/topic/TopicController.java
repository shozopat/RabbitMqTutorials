package com.shozo.amqp.producer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("topic")
@RestController
@RequestMapping("producer")
public class TopicController {

	@Autowired
	TopicService service;
	
	@PostMapping("{routingKey}")
	public void sendMessage(@RequestBody String msg, @PathVariable("routingKey") String routingKey) {
		service.sendMessage(msg,routingKey);
	}
}
