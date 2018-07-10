package com.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

/**
 * Ip被拦截记录
 * @author heyanzhu
 */
@Entity
@Data
@Table(name="InterceptedLog")
public class InterceptedLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Ip")
	private String Ip;
	
	@Column(name="UrI")
	private String UrI;

	@Column(name="DateTime")
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.ALWAYS)
	private Date DateTime;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getUrI() {
		return UrI;
	}

	public void setUrI(String urI) {
		UrI = urI;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	@Override
	public String toString() {
		return "InterceptedLog [Id=" + Id + ", Ip=" + Ip + ", UrI=" + UrI + ", DateTime=" + DateTime + "]";
	}

	public InterceptedLog() {
		super();
	}

	public InterceptedLog(String ip, String urI) {
		super();
		Ip = ip;
		UrI = urI;
	}
	
	
}
