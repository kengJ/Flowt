package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Hql对应表
 * @author heyanzhu
 *
 */
@Entity
@Table
@Data
public class HqlMessage {

	@Id
	@GeneratedValue
	private long Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Hql")
	private String Hql;
	
	@Column(name="KeyMap")
	private String KeyMap;
	
	@Column(name="ActionName")
	private String ActionName;
	
	@Column(name="Type")
	private String Type;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getHql() {
		return Hql;
	}

	public void setHql(String hql) {
		Hql = hql;
	}

	public String getKeyMap() {
		return KeyMap;
	}

	public void setKeyMap(String keyMap) {
		KeyMap = keyMap;
	}

	public String getActionName() {
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "HqlMessage [Id=" + Id + ", Name=" + Name + ", Hql=" + Hql + ", KeyMap=" + KeyMap + ", ActionName="
				+ ActionName + ", Type=" + Type + "]";
	}

	public HqlMessage(long id, String name, String hql, String keyMap, String actionName, String type) {
		super();
		Id = id;
		Name = name;
		Hql = hql;
		KeyMap = keyMap;
		ActionName = actionName;
		Type = type;
	}

	public HqlMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HqlMessage(String name, String hql, String keyMap, String actionName, String type) {
		super();
		Name = name;
		Hql = hql;
		KeyMap = keyMap;
		ActionName = actionName;
		Type = type;
	}
}
