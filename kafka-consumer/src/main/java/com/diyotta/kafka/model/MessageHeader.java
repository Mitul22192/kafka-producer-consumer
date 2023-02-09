package com.diyotta.kafka.model;

import lombok.Data;

@Data
public class MessageHeader {
	
	private String key;
	private String value;

}
