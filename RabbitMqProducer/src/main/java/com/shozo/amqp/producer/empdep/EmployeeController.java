package com.shozo.amqp.producer.empdep;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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

@Profile("empdep")
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
	
}
