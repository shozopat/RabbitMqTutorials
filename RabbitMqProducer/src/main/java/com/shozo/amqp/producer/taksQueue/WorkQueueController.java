package com.shozo.amqp.producer.taksQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("taskqueue")
@RestController
@RequestMapping("taskqueue")
public class WorkQueueController {

	@Autowired
	WorkQueueService service;
	
	@PostMapping
	public void sendMessage(@RequestBody String msg) {
		service.sendMessage(msg);
	}
}
