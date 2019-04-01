package com.shozo.amqp.producer.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("basic")
@RestController
@RequestMapping("producer")
public class BasicController {

	@Autowired
	BasicService service;
	
	@PostMapping
	public void sendMessage(@RequestBody String msg) {
	
		service.sendMessage(msg);
	}
}
