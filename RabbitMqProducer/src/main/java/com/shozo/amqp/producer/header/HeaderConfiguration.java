package com.shozo.amqp.producer.header;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("header")
@Configuration
public class HeaderConfiguration {
	
	@Bean
	public HeadersExchange fanout() {
		return new HeadersExchange("header");
	}
}
