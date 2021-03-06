package com.shozo.amqp.consumer.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("topic")
@Configuration
public class TopicConfiguration {
	
	@Bean
	public TopicExchange fanout() {
		return new TopicExchange("topic");
	}
	
	@Bean
	public Queue indiaQueue() {
		return new Queue("india");
	}
	
	
	@Bean
	public Queue indiaMaharashtraQueue() {
		return new Queue("indiaMaharashtra");
	}
	
	@Bean
	public Queue thaneQueue() {
		return new Queue("thane");
	}
	
	@Bean
	public Queue indiaThaneQueue() {
		return new Queue("indiathane");
	}
	
	
	@Bean
	public Queue mumbaiQueue() {
		return new Queue("mumbai");
	}
	
	
	@Bean
	public Binding indiaQueueBinding(TopicExchange exchange, Queue indiaQueue) {
		return BindingBuilder.bind(indiaQueue).to(exchange).with("india.#");
	}
	
	@Bean
	public Binding indiaMaharashtraBinding(TopicExchange exchange, Queue indiaMaharashtraQueue) {
		return BindingBuilder.bind(indiaMaharashtraQueue).to(exchange).with("india.maharashtra.*");
	}
	
	@Bean
	public Binding thaneBinding(TopicExchange exchange, Queue thaneQueue) {
		return BindingBuilder.bind(thaneQueue).to(exchange).with("*.*.thane");
	}
	
	
	@Bean
	public Binding indiaThaneBinding(TopicExchange exchange, Queue indiaThaneQueue) {
		return BindingBuilder.bind(indiaThaneQueue).to(exchange).with("india.*.thane");
	}
	
	@Bean
	public Binding mumbaiBinding(TopicExchange exchange, Queue mumbaiQueue) {
		return BindingBuilder.bind(mumbaiQueue).to(exchange).with("*.*.mumbai");
	}
	

    @Bean
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
