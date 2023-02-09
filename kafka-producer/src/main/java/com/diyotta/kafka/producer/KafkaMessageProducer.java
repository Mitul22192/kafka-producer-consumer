package com.diyotta.kafka.producer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.diyotta.kafka.model.Book;

@Component
public class KafkaMessageProducer<T> {

	@Autowired
	private KafkaTemplate<String, T> kafkaTemplate;

	@Value("${kafka.topic}")
	String topic;

	/*
	 * public String sendMessage(Book book) { kafkaTemplate.send(topic,
	 * book.getBookName(), (T) book); return "Message Published successfully"; }
	 */

	public String sendBook(Book book) {

		List<Header> headers = new ArrayList<>();
		headers.add(new RecordHeader("payload_version", "payload_version.value".getBytes()));
		headers.add(new RecordHeader("payload_source", "payload_source.value".getBytes()));
		/*
		 * headers.add(new RecordHeader("payload_type",
		 * "payload_type.value".getBytes())); headers.add(new RecordHeader("trace_id",
		 * "trace_id.value".getBytes())); headers.add(new RecordHeader("span_id",
		 * "span_id.value".getBytes())); headers.add(new RecordHeader("correlation_id",
		 * "correlation_id.value".getBytes()));
		 */
		ProducerRecord<String, T> bar = new ProducerRecord<>(topic, 0, System.currentTimeMillis(), book.getBookName(),
				(T) book, headers);

		System.out.println("before sendBook");
		kafkaTemplate.send(bar);
		System.out.println("after sendBook");
		return book.getBookName() + " Published successfully";
	}

}
