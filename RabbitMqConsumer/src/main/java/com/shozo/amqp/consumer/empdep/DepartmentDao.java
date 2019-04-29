package com.shozo.amqp.consumer.empdep;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("empdep")
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
