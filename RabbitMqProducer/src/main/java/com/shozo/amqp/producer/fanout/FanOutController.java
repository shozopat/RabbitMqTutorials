package com.shozo.amqp.producer.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("fanout")
@RestController
@RequestMapping("producer")
public class FanOutController {

	@Autowired
	FanOutService service;
	
	@PostMapping
	public void sendMessage(@RequestBody String msg) {
		service.sendMessage(msg);
	}
}
