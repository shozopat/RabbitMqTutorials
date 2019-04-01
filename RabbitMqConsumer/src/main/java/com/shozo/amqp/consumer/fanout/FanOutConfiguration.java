package com.shozo.amqp.consumer.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
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
	
	@Bean
	public Queue firstQueue() {
		return new Queue("queue1");
	}
	
	@Bean
	public Queue secondQueue() {
		return new Queue("queue2");
	}
	
	@Bean
	public Binding firstQueueBinding(FanoutExchange exchange, Queue firstQueue) {
		return BindingBuilder.bind(firstQueue).to(exchange);
	}
	
	@Bean
	public Binding secondQueueBinding(FanoutExchange exchange, Queue secondQueue) {
		return BindingBuilder.bind(secondQueue).to(exchange);
	}
	
}
