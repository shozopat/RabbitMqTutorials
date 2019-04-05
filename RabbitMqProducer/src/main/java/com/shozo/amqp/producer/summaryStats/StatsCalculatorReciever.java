package com.shozo.amqp.producer.summaryStats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Profile("stats")
@Service
public class StatsCalculatorReciever {
	
	@Autowired
	Queue queue;
	
	@Autowired
	DatasetDao dao;
	
	@Autowired
	ObjectMapper mapper;
	
	@RabbitListener(queues="#{resultQueue.name}")
	public void recieveStatsResult(Message message) throws IOException {
		Map<String,Object> map = mapper.readValue(message.getBody(), HashMap.class);
		Integer id = Integer.parseInt(String.valueOf(map.remove("id")));
		String str = mapper.writeValueAsString(map);
		System.out.println(str);
		dao.updateStats(id, str);
	}
}
