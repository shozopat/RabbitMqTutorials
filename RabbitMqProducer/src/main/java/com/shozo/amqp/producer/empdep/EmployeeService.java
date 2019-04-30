package com.shozo.amqp.producer.empdep;

import java.util.List;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Profile("empdep")
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	DirectExchange exchange;
	
	public void createEmployee(Employee e) {
		dao.save(e);
		rabbitTemplate.convertAndSend(exchange.getName(), "addEmp", e);
		System.out.println("send firstQueue successfull");
	}

	public List<Employee> getEmployees() {
		return dao.findAll();
	}
	
	public Employee deleteEmployee(Integer eid) {
		System.out.println("send SecondQueue successfull");
		Employee e = dao.findById(eid).get();
		dao.deleteById(eid);
		rabbitTemplate.convertAndSend(exchange.getName(), "deleteEmp", e);
		return e;
	}

}
