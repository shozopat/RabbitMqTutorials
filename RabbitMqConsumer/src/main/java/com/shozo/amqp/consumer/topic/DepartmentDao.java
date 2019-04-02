package com.shozo.amqp.consumer.topic;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("topic")
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
