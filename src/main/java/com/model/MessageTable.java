package com.model;
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
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "MessageTable_id")
	private Set<MessageTableDetial> MessageTableDetial;

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

	public Set<MessageTableDetial> getMessageTableDetial() {
		return MessageTableDetial;
	}

	public void setMessageTableDetial(Set<MessageTableDetial> messageTableDetial) {
		MessageTableDetial = messageTableDetial;
	}

	@Override
	public String toString() {
		return "MessageTable [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", Memo=" + Memo
				+ ", MessageTableDetial=" + MessageTableDetial + "]";
	}

	public MessageTable(Long id, String name, String type, String memo,
			Set<com.model.MessageTableDetial> messageTableDetial) {
		super();
		Id = id;
		Name = name;
		Type = type;
		Memo = memo;
		MessageTableDetial = messageTableDetial;
	}

	public MessageTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
