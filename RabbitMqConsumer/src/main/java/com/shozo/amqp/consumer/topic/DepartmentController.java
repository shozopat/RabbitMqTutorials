package com.shozo.amqp.consumer.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("topic")
@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(consumes="application/json",produces="application/json")
	public void createDepartment(@RequestBody Department d) {
		
		departmentService.createDepartment(d);
	}
	
	@GetMapping(produces="application/json")
	public List<Department> getDepartment() {
		return departmentService.getDepartment();
	}
	
	
	@PostMapping(produces="application/json",value="test")
	public String getEmployee(@RequestBody Employee e) {
		System.out.println(e);
		return "success";
	}

}
