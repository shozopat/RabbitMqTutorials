package com.shozo.amqp.producer.topic;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("topic")
@Configuration
public class TopicConfiguration {
	
	@Bean
	public DirectExchange fanout() {
		return new DirectExchange("topic");
	}
}
