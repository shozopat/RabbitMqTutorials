package com.shozo.amqp.consumer.empdep;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.context.annotation.Profile;

@Profile("empdep")
public class Employee implements Serializable{


	private static final long serialVersionUID = 2373041735506378127L;
	
	Integer eId;
	

	String name;
	

	Integer salary;
	

	Integer age;
	

	Integer dId;
	

	String dname;
	
	Timestamp joiningDate;

	public Employee() {
		
	}
	
	public Employee(Integer eId, String name, Integer salary, Integer age, Integer dId, String dname) {
		super();
		this.eId = eId;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.dId = dId;
		this.dname = dname;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Timestamp getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Timestamp joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee(Integer eId, String name, Integer salary, Integer age, Integer dId, String dname,
			Timestamp joiningDate) {
		super();
		this.eId = eId;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.dId = dId;
		this.dname = dname;
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", salary=" + salary + ", age=" + age + ", dId=" + dId
				+ ", dname=" + dname + ", joiningDate=" + joiningDate + "]";
	}
	
	
	
	
}
