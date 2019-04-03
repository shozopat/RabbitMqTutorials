package com.shozo.amqp.consumer.header;

import java.util.Map;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.shozo.amqp.consumer.topic.Employee;

@Profile("header")
@Service
public class HeaderService {

	
	@RabbitListener(queues="warn")
	public void getWarnMsg(Message message) throws InterruptedException {
		System.out.println("in getWarnMsg ");
		Map<String, Object> headers = message.getMessageProperties().getHeaders();
		System.out.println(headers);
		System.out.println(message.getBody());
	}
	
	@RabbitListener(queues="jsonInfo")
	public void getJsonInfoMsg(Message message) throws InterruptedException {
		System.out.println("in getJsonInfoMsg ");
		Map<String, Object> headers = message.getMessageProperties().getHeaders();
		System.out.println(headers);
		System.out.println(message.getBody());
	}
}
