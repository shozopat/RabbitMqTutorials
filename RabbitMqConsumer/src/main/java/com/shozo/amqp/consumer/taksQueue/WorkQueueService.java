package com.shozo.amqp.consumer.taksQueue;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("taskqueue")
@Service
public class WorkQueueService {


	@RabbitListener(queues= "taskqueue")
	public void recieveMessage(String msg) throws InterruptedException {
		System.out.println("Message recieved "+msg);
		List<String> list = Arrays.asList(msg.split(" "));
		String last = list.get(list.size()-1);
		for(char ch : last.toCharArray()) {
			if(ch=='.') {
				Thread.sleep(1000);
			}
		}
	}

}
