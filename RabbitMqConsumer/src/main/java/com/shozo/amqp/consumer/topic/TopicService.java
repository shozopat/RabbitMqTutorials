package com.shozo.amqp.consumer.topic;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("topic")
@Service
public class TopicService {

	@Autowired
	DepartmentService departmentService;
	
	@RabbitListener(queues="#{addEmployee.name}")
	public void incrementEmployeeCount(Employee employee) throws InterruptedException {
		System.out.println("in incrementEmployeeCount ");
		System.out.println(employee);
		departmentService.incrementEmployeeCount(employee);
	}
	
	@RabbitListener(queues="#{deleteEmployee.name}")
	public void decrementEmployeeCount(Employee employee) throws InterruptedException {
		System.out.println("in decrementEmployeeCount ");
		departmentService.decrementEmployeeCount(employee);
	}
}
