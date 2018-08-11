package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class VueMenuItem {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(name="IndexName")
	private String IndexName;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="Icon")
	private String Icon;
	
	@Column(name="Uri")
	private String Uri;

	@Column(name="OrderNo")
	private String OrderNo;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getIndex() {
		return IndexName;
	}

	public void setIndex(String indexName) {
		IndexName = indexName;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}

	public String getUri() {
		return Uri;
	}

	public void setUri(String uri) {
		Uri = uri;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	@Override
	public String toString() {
		return "VueMenuItem [Id=" + Id + ", Index=" + IndexName + ", Title=" + Title + ", Icon=" + Icon + ", Uri=" + Uri
				+ ", OrderNo=" + OrderNo + "]";
	}

	public VueMenuItem(Long id, String indexName, String title, String icon, String uri, String orderNo) {
		super();
		Id = id;
		IndexName = indexName;
		Title = title;
		Icon = icon;
		Uri = uri;
		OrderNo = orderNo;
	}

	public VueMenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
}
