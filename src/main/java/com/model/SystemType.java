package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * 系统类型
 * @author heyanzhu
 *
 */
@Entity
@Table(name="SystemType")
@Data
public class SystemType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="SystemName")
	private String SystemName;
	
	@Column(name="SystemKey")
	private String SystemKey;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSystemName() {
		return SystemName;
	}

	public void setSystemName(String name) {
		SystemName = name;
	}

	@Override
	public String toString() {
		return "SystemType [Id=" + Id + ", Name=" + SystemName + "]";
	}

	public SystemType(Long id, String name) {
		super();
		Id = id;
		SystemName = name;
	}

	public SystemType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemType(String name,String key) {
		super();
		SystemName = name;
		SystemKey = key;
	}

	public String getSystemKey() {
		return SystemKey;
	}

	public void setSystemKey(String systemKey) {
		SystemKey = systemKey;
	}
}
