
package com.diyotta.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.diyotta.kafka.model.ConsumerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaEventListener<T> {
	
	private static final Logger log = LogManager.getLogger(KafkaEventListener.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = "${kafka.topic}")
	void listenDefault(ConsumerRecord<String, T> record) {

		ConsumerDto<T> data = new ConsumerDto<>(record);
		try {
			System.out.println(objectMapper.writeValueAsString(data));

		} catch (JsonProcessingException e) {
			log.error("Error occured : ", e);
		}

	}

}