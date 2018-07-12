package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="KeyValue")
	private String KeyValue;
	
	@Column(name="MessageValue")
	private String MessageValue;
	
	@Column(name="Type")
	private String Type;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getKeyValue() {
		return KeyValue;
	}

	public void setKeyValue(String keyValue) {
		KeyValue = keyValue;
	}

	public String getMessageValue() {
		return MessageValue;
	}

	public void setMessageValue(String messageValue) {
		MessageValue = messageValue;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Message(Long id, String keyValue, String messageValue, String type) {
		super();
		Id = id;
		KeyValue = keyValue;
		MessageValue = messageValue;
		Type = type;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Message [Id=" + Id + ", Key=" + KeyValue + ", MessageValue=" + MessageValue + ", Type=" + Type + "]";
	}

	public Message(String keyValue, String messageValue, String type) {
		super();
		KeyValue = keyValue;
		MessageValue = messageValue;
		Type = type;
	}
}
