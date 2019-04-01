package com.shozo.amqp.consumer.topic;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Receiver {

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	DepartmentService departmentService;
	
	@RabbitListener(queues="#{}")
	public void incrementEmployeeCount(Employee employee) throws InterruptedException {
		System.out.println("in incrementEmployeeCount ");
		System.out.println(employee);
		departmentService.incrementEmployeeCount(employee);
	}
	
	@RabbitListener(queues="#{}")
	public void decrementEmployeeCount(Employee employee) throws InterruptedException {
		System.out.println("in decrementEmployeeCount ");
		departmentService.decrementEmployeeCount(employee);
	}

}
