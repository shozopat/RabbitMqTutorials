package com.shozo.amqp.consumer.basic;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("basic")
@Configuration
public class BasicConfiguration {

/*	@Bean
	public Queue hello() {
		return new Queue("hello",false,false,false);
	}
*/
}
