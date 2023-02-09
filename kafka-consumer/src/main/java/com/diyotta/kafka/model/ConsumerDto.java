package com.diyotta.kafka.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;

import com.diyotta.kafka.utility.KafkaUtils;

import lombok.Data;

@Data
public class ConsumerDto<T> {
	String Topic;
	String Key;
	T Value;
	String Time;
	List<MessageHeader> messageHeaders;

	public ConsumerDto() {
		super();
	}

	public ConsumerDto(ConsumerRecord<String, T> record) {
		Topic = record.topic();
		Key = record.key();
		Value = record.value();
		Date date = new Date(record.timestamp());
		Time = KafkaUtils.formatDateToString(date, "MMM dd yyyy hh:mm:ss a", "UTC");
		messageHeaders = new ArrayList<MessageHeader>();
		for (Header header : record.headers()) {
			MessageHeader messageHeader = new MessageHeader();
			messageHeader.setKey(header.key());
			messageHeader.setValue(new String(header.value()));
			messageHeaders.add(messageHeader);
		}
	}
}