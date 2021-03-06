package com.shozo.amqp.producer.empdep;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("empdep")
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}


/*{
	"eId":1,
	"name":"shozo",
	"age":20,
	"salary":3000,
	"dname":"HR",
	"dId":1
}*/