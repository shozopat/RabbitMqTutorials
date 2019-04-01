package com.shozo.amqp.producer.fanout;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("fanout")
@Configuration
public class FanOutConfiguration {
	
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("fanout");
	}
}
