package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="LogMessage")
public class LogMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="UserId")
	private String UserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ActionTime")
	private Date ActionTime;
	
	@Column(name="Message")
	private String Message;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public Date getActionTime() {
		return ActionTime;
	}

	public void setActionTime(Date actionTime) {
		ActionTime = actionTime;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
