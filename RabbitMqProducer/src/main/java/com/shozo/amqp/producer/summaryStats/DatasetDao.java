package com.shozo.amqp.producer.summaryStats;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Profile("stats")
@Repository
@Transactional
public interface DatasetDao extends JpaRepository<Dataset, Integer>{

	@Modifying
	@Query("Update Dataset d set d.statsInfo= :value where d.datasetId= :id")
	int updateStats(@Param("id") Integer id, @Param("value") String value);

}


/*{
	"eId":1,
	"name":"shozo",
	"age":20,
	"salary":3000,
	"dname":"HR",
	"dId":1
}*/