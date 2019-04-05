package com.shozo.amqp.producer.summaryStats;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Profile("stats")
@RestController
@RequestMapping("stats")
public class StatsCalculatorController {

	@Autowired
	StatsCalculatorService service;
	
	@PostMapping
	public void calculateStats(@RequestParam("file") MultipartFile file, 
								@RequestParam("columns") String columns) throws IllegalStateException, IOException {
		String name = file.getName();
		String originalFilename = file.getOriginalFilename();
		System.out.println("filename "+name+" "+originalFilename);
		System.out.println("columns "+columns);
		service.calculateStats(file, columns);
	}
	
	@GetMapping
	public List<Dataset> getDatasets() {
		return service.getDatasets();
	}
	
	@GetMapping("{id}")
	public HashMap getStatsForDataset(@PathVariable("id") Integer id) throws JsonParseException, JsonMappingException, IOException {
		return service.getStatsForDataset(id);
	}
}
