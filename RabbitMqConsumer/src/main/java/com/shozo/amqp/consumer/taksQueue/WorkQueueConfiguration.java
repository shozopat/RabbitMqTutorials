package com.shozo.amqp.consumer.taksQueue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("taskqueue")
@Configuration
public class WorkQueueConfiguration {

	@Bean
	public Queue taskqueue() {
		return new Queue("taskqueue",false,false,false);
	}
}
