package com.diyotta.kafka.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerInterceptor<T> implements ConsumerInterceptor<String, T> {


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConsumerRecords<String, T> onConsume(ConsumerRecords<String, T> records) {
		System.out.println("in interceptor");
		return records;
	}

	@Override
	public void configure(Map<java.lang.String, ?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCommit(Map<TopicPartition, OffsetAndMetadata> arg0) {
		// TODO Auto-generated method stub
		
	}

}
