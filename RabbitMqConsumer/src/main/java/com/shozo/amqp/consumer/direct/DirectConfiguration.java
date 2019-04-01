package com.shozo.amqp.consumer.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
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
	
	@Bean
	public Queue firstQueue() {
		return new Queue("queue1");
	}
	
	@Bean
	public Queue secondQueue() {
		return new Queue("queue2");
	}
	
	@Bean
	public Binding firstQueueBinding(DirectExchange exchange, Queue firstQueue) {
		return BindingBuilder.bind(firstQueue).to(exchange).with("black");
	}
	
	@Bean
	public Binding secondQueueBinding(DirectExchange exchange, Queue secondQueue) {
		return BindingBuilder.bind(secondQueue).to(exchange).with("green");
	}
	
}
