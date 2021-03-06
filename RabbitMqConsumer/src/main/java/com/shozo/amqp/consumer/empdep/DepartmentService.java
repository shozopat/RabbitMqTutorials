package com.shozo.amqp.consumer.empdep;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("empdep")
@Service
public class DepartmentService {

	@Autowired
	DepartmentDao dao;
	
	
	public void createDepartment(Department d) {
		dao.save(d);
	}


	public List<Department> getDepartment() {
		return dao.findAll();
	}


	public void incrementEmployeeCount(Employee employee) {
		Integer did = employee.getdId();
		Department department = dao.findById(did).get();
		Integer employeeCount = department.getEmployeeCount()+1;
		department.setEmployeeCount(employeeCount);
		dao.save(department);
	}
	
	public void decrementEmployeeCount(Employee employee) {
		Integer did = employee.getdId();
		Department department = dao.findById(did).get();
		Integer employeeCount = department.getEmployeeCount()-1;
		department.setEmployeeCount(employeeCount);
		dao.save(department);
	}

}
