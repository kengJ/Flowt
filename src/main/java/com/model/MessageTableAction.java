package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MessageTableAction")
@Data
public class MessageTableAction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="Type")
	private String Type;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="ActionName")
	private String ActionName;
	
	@Column(name="Url")
	private String Url;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getActionName() {
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@Override
	public String toString() {
		return "MessageTableAction [Id=" + Id + ", Type=" + Type + ", Name=" + Name + ", ActionName=" + ActionName
				+ ", Url=" + Url + "]";
	}

	public MessageTableAction(Long id, String type, String name, String actionName, String url) {
		super();
		Id = id;
		Type = type;
		Name = name;
		ActionName = actionName;
		Url = url;
	}

	public MessageTableAction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
