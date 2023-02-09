package com.diyotta.kafka.config;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeader;

public class KafkaProducerInterceptor implements ProducerInterceptor<String, String> {

	@Override
	public void configure(Map<String, ?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAcknowledgement(RecordMetadata arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
		// TODO Auto-generated method stub
		
		Headers headers = producerRecord.headers();
		System.out.println("in interceptor");
		headers.add(new RecordHeader("payload_type", "payload_type.value1".getBytes()));
		headers.add(new RecordHeader("trace_id", "trace_id.value1".getBytes()));
		headers.add(new RecordHeader("span_id", "span_id.value1".getBytes()));
		headers.add(new RecordHeader("correlation_id", "correlation_id.value1".getBytes()));

		return producerRecord;
	}

}
