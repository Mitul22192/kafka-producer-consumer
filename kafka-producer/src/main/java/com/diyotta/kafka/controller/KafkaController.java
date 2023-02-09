package com.diyotta.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diyotta.kafka.model.Book;
import com.diyotta.kafka.producer.KafkaMessageProducer;

@RestController
public class KafkaController {
	@Autowired
	private KafkaMessageProducer<Book>  kafkaMessageProducer;
	
	@PostMapping("/pushMessage")
	public String postMessage(@RequestBody Book book) {
		return kafkaMessageProducer.sendBook(book);
	}

}
