package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MessageTableDetial")
@Data
public class MessageTableDetial {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column(name="Name")
	private String Name;
	@Column(name="Title")
	private String Title;
	@Column(name="KeyName")
	private String Key;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	@Override
	public String toString() {
		return "MessageTableDetial [Id=" + Id + ", Name=" + Name + ", Title=" + Title + ", Key=" + Key + "]";
	}
	public MessageTableDetial(Long id, String name, String title, String key) {
		super();
		Id = id;
		Name = name;
		Title = title;
		Key = key;
	}
	public MessageTableDetial() {
		super();
		// TODO Auto-generated constructor stub
	}
}