package com.shozo.amqp.producer.summaryStats;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("stats")
@Configuration
public class StatsCalculatorConfig {

/*	@Bean
	public Queue statsCalQueue() {
		return new Queue("statsCalQueue",false,false,false);
	}
	
	*/
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("direct");
	}
	
	@Bean
	public Queue resultQueue() {
		return new Queue("resultQueue",false,false,false);
	}
	
	@Bean
	public Binding secondQueueBinding(DirectExchange exchange, Queue resultQueue) {
		return BindingBuilder.bind(resultQueue).to(exchange).with("statsResult");
	}
	
    @Bean("jsonTemplate")
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
