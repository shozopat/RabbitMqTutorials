package com.shozo.amqp.producer.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("header")
@RestController
@RequestMapping("producer")
public class HeaderController {

	@Autowired
	HeaderService service;
	
	@PostMapping("{format}/{type}")
	public void sendMessage(@PathVariable("format") String format, @PathVariable("type") String type, @RequestBody String msg) {
		service.sendMessage(format,type,msg);
	}
}
