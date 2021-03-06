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
	private String KeyName;
	
	@Column(name="OrderNo",nullable=false,columnDefinition="INT default 0")
	private int OrderNo;
	
	@Column(name="IsEdit",nullable=false,columnDefinition="INT default 0")
	private int IsEdit;
	
	@Column(name="IsAdd",nullable=false,columnDefinition="INT default 0")
	private int IsAdd;
	
	@Column(name="IsShow",nullable=false,columnDefinition="INT default 1")
	private int IsShow;
	
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
	public String getKeyName() {
		return KeyName;
	}
	public void setKeyName(String key) {
		KeyName = key;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	public int getIsEdit() {
		return IsEdit;
	}
	public void setIsEdit(int isEdit) {
		IsEdit = isEdit;
	}
	public int getIsAdd() {
		return IsAdd;
	}
	public void setIsAdd(int isAdd) {
		IsAdd = isAdd;
	}
	public MessageTableDetial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIsShow() {
		return IsShow;
	}
	public void setIsShow(int isShow) {
		IsShow = isShow;
	}
	public MessageTableDetial(Long id, String name, String title, String key, int orderNo, int isEdit, int isAdd,
			int isShow) {
		super();
		Id = id;
		Name = name;
		Title = title;
		KeyName = key;
		OrderNo = orderNo;
		IsEdit = isEdit;
		IsAdd = isAdd;
		IsShow = isShow;
	}
	@Override
	public String toString() {
		return "MessageTableDetial [Id=" + Id + ", Name=" + Name + ", Title=" + Title + ", Key=" + KeyName + ", OrderNo="
				+ OrderNo + ", IsEdit=" + IsEdit + ", IsAdd=" + IsAdd + ", IsShow=" + IsShow + "]";
	}
}
