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
	
	@Column(name="Name")
	private String Name;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "SystemType [Id=" + Id + ", Name=" + Name + "]";
	}

	public SystemType(Long id, String name) {
		super();
		Id = id;
		Name = name;
	}

	public SystemType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemType(String name) {
		super();
		Name = name;
	}
}
