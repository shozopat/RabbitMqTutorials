package com.shozo.amqp.producer.topic;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping(consumes="application/json",produces="application/json")
	public void createDepartment(@RequestBody Employee e) {
		
		employeeService.createEmployee(e);
	}
	
	@GetMapping(produces="application/json")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	
	@DeleteMapping("{eid}")
	public Employee deleteEmployees(@PathVariable("eid") Integer eid) {
		 return employeeService.deleteEmployee(eid);
	}
	
	@GetMapping(produces="application/json",value="test")
	public List<Employee> sendEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Employee employee = new Employee(1, "shozo", 100, 28, 1, "ÏT", timestamp);
		ResponseEntity<String> postForEntity = restTemplate.postForEntity("http://localhost:8082/department/test", employee, String.class);
		String body = postForEntity.getBody();
		System.out.println(body);
		return employeeService.getEmployees();
	}
}
