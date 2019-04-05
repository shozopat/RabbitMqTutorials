package com.shozo.amqp.producer.summaryStats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Profile("stats")
@Service
public class StatsCalculatorService {

	@Autowired
	@Qualifier("jsonTemplate")
	RabbitTemplate rabbitTemplate;

	@Autowired
	Queue queue;
	
	@Autowired
	DirectExchange exchange;
	
	@Autowired
	DatasetDao dao;
	
	@Autowired
	ObjectMapper mapper;
	
	public void sendMessage(String msg) {
		
		rabbitTemplate.convertAndSend(queue.getName(),msg);
	}

	public void calculateStats(MultipartFile multipartFile, String columns) throws IllegalStateException, IOException {
		Dataset d = new Dataset();
		d.setDatasetName(multipartFile.getOriginalFilename());
		d.setCreateDate(new Timestamp(System.currentTimeMillis()));
		Dataset dataset = dao.save(d);
		
		//String filePath = "D:\\RabbitMq\\data\\"+dataset.getDatasetId()+"-"+multipartFile.getOriginalFilename();
		String filePath = dataset.getDatasetId()+"-"+multipartFile.getOriginalFilename();
		multipartFile.transferTo(new File("D:\\RabbitMq\\data\\"+filePath));
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(() -> sendMessage(dataset.getDatasetId(), filePath, columns));
	}

	private void sendMessage(Integer datasetId, String filePath, String columns) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", String.valueOf(datasetId));
		map.put("file", filePath);
		map.put("columns", columns);
		rabbitTemplate.convertAndSend(exchange.getName(),"statsCal",map);
	}

	public List<Dataset> getDatasets() {
		return dao.findAll();
	}

	public HashMap getStatsForDataset(Integer id) throws JsonParseException, JsonMappingException, IOException {
		Dataset dataset = dao.findById(id).get();
		return mapper.readValue(dataset.getStatsInfo(), HashMap.class);
	}
}
