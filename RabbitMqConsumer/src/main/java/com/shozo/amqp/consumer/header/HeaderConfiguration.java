package com.shozo.amqp.consumer.header;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.HeadersExchangeMapConfigurer.HeadersExchangeMapBindingCreator;
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
		return new HeadersExchange("headerExchange");
	}
	
	@Bean
	public Queue jsonInfoQueue() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("format", "json");
		map.put("type", "info");
		Queue queue = new Queue("jsonInfo",true,false,false,map);
		System.out.println("autodelete "+queue.isAutoDelete());
		System.out.println("durable "+queue.isDurable());
		System.out.println("exclusive "+queue.isExclusive());
		return queue;
	}
	
	@Bean
	public Queue warnQueue() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("format", "xml");
		map.put("type", "warn");
		return new Queue("warn",true,false,false,map);
	}
	
	
	@Bean
	public HeadersExchangeMapBindingCreator jsonInfoQueueBinding(HeadersExchange exchange, Queue jsonInfoQueue) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("format", "json");
		map.put("type", "info");
		return BindingBuilder.bind(jsonInfoQueue).to(exchange).whereAll(map);
	}
	
	@Bean
	public HeadersExchangeMapBindingCreator warnQueueBinding(HeadersExchange exchange, Queue warnQueue) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("format", "xml");
		map.put("type", "warn");
		return BindingBuilder.bind(warnQueue).to(exchange).whereAny(map);
	}
	
}
