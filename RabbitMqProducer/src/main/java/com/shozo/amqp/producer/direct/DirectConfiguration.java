package com.shozo.amqp.producer.direct;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("direct")
@Configuration
public class DirectConfiguration {
	
	@Bean
	public DirectExchange fanout() {
		return new DirectExchange("direct");
	}
}
