package com.shozo.amqp.consumer.topic;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	Integer id;
	
	@Column
	String dname;
	
	@Column
	String dmanager;
	
	@Column
	Integer employeeCount;
	
	public Department() {}

	public Department(Integer id, String dname, String dmanager, Integer employeeCount) {
		super();
		this.id = id;
		this.dname = dname;
		this.dmanager = dmanager;
		this.employeeCount = employeeCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDmanager() {
		return dmanager;
	}

	public void setDmanager(String dmanager) {
		this.dmanager = dmanager;
	}

	public Integer getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}
	
}
