package com.shozo.amqp.producer.topic;

import java.util.List;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Profile("topic")
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	TopicExchange exchange;
	
	public void createEmployee(Employee e) {
		dao.save(e);
		rabbitTemplate.convertAndSend(exchange.getName(), "add.employee", e);
		System.out.println("send firstQueue successfull");
	}

	public List<Employee> getEmployees() {
		return dao.findAll();
	}
	
	public Employee deleteEmployee(Integer eid) {
		System.out.println("send SecondQueue successfull");
		Employee e = dao.findById(eid).get();
		dao.deleteById(eid);
		rabbitTemplate.convertAndSend(exchange.getName(), "delete.employee", e);
		return e;
	}

}
