package com.model;

import java.util.List;
import org.hibernate.annotations.OrderBy;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Menu")
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="Memo")
	private String Memo;
	
	@Column(name="OrderBy")
	private int OrderBy;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "Menu_id")
	@OrderBy(clause="OrderNo,Id")
	private List<MessageTable> MessageTables;

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

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public int getOrderBy() {
		return OrderBy;
	}

	public void setOrderBy(int orderBy) {
		OrderBy = orderBy;
	}

	public List<MessageTable> getMessageTables() {
		return MessageTables;
	}

	public void setMessageTables(List<MessageTable> messageTables) {
		MessageTables = messageTables;
	}

	@Override
	public String toString() {
		return "Menu [Id=" + Id + ", Name=" + Name + ", Title=" + Title + ", Memo=" + Memo + ", OrderBy=" + OrderBy
				+ ", MessageTables=" + MessageTables + "]";
	}

	public Menu(Long id, String name, String title, String memo, int orderBy, List<MessageTable> messageTables) {
		super();
		Id = id;
		Name = name;
		Title = title;
		Memo = memo;
		OrderBy = orderBy;
		MessageTables = messageTables;
	}

	public Menu() {
		super();
	}

	public Menu(String name, String title, String memo, int orderBy) {
		super();
		Name = name;
		Title = title;
		Memo = memo;
		OrderBy = orderBy;
	}
	
	
}
