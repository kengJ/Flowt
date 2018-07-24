package com.model;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.OrderBy;

import lombok.Data;

@Entity
@Table(name="MessageTable")
@Data
public class MessageTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Type")
	private String Type;
	
	@Column(name="Memo")
	private String Memo;
	
	@Column(name="Url")
	private String Url;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="OrderNo")
	private int OrderNo;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "MessageTable_id")
	@OrderBy(clause="OrderNo,Id")
	private List<MessageTableDetial> MessageTableDetial;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "MessageTable_id")
	private Set<MessageTableAction> MessageTableActions;
	
	@Column(name="Tip")
	private String Tip;

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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	

	public List<MessageTableDetial> getMessageTableDetial() {
		return MessageTableDetial;
	}

	public void setMessageTableDetial(List<MessageTableDetial> messageTableDetial) {
		MessageTableDetial = messageTableDetial;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}

	public String getTip() {
		return Tip;
	}

	public void setTip(String tip) {
		Tip = tip;
	}

	public Set<MessageTableAction> getMessageTableActions() {
		return MessageTableActions;
	}

	public void setMessageTableActions(Set<MessageTableAction> messageTableActions) {
		MessageTableActions = messageTableActions;
	}

	@Override
	public String toString() {
		return "MessageTable [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", Memo=" + Memo + ", Url=" + Url
				+ ", Title=" + Title + ", OrderNo=" + OrderNo + ", MessageTableDetial=" + MessageTableDetial
				+ ", MessageTableActions=" + MessageTableActions + ", Tip=" + Tip + "]";
	}

	public MessageTable(Long id, String name, String type, String memo, String url, String title, int orderNo,
			List<com.model.MessageTableDetial> messageTableDetial, Set<MessageTableAction> messageTableActions,
			String tip) {
		super();
		Id = id;
		Name = name;
		Type = type;
		Memo = memo;
		Url = url;
		Title = title;
		OrderNo = orderNo;
		MessageTableDetial = messageTableDetial;
		MessageTableActions = messageTableActions;
		Tip = tip;
	}

	public MessageTable() {
		super();
		// TODO Auto-generated constructor stub
	}
}
