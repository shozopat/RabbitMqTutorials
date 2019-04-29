package com.shozo.amqp.consumer.empdep;

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

@Profile("empdep")
@Configuration
public class TopicConfiguration {
	
	@Bean
	public TopicExchange fanout() {
		return new TopicExchange("topic");
	}
	
	@Bean
	public Queue addEmployee() {
		return new Queue("addEmployee");
	}
	
	@Bean
	public Queue deleteEmployee() {
		return new Queue("deleteEmployee");
	}
	
	@Bean
	public Binding addEmployeeBinding(TopicExchange exchange, Queue addEmployee) {
		return BindingBuilder.bind(addEmployee).to(exchange).with("add.*");
	}
	
	@Bean
	public Binding deleteEmployeeBinding(TopicExchange exchange, Queue deleteEmployee) {
		return BindingBuilder.bind(deleteEmployee).to(exchange).with("delete.*");
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
