package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.util.StrUtil;

import lombok.Data;

@Data
@Entity
@Table(name="SqlMessage")
public class SqlMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;

	@Column(name="Memo",unique=true)
	private String Memo;
	
	@Column(name="Type")
	private int Type;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="Password")
	private String Password;
	
	@Column(name="Ip")
	private String Ip;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreateDate",insertable=true,columnDefinition="datetime default CURRENT_TIMESTAMP",nullable=false)
	@Generated(GenerationTime.INSERT)
	private Date CreateDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UpdateDate",insertable=true,updatable=true,columnDefinition="datetime default CURRENT_TIMESTAMP",nullable=false)
	@Generated(GenerationTime.ALWAYS)
	private Date UpdateDate;
	
	@Column(name="DatabaseName")
	private String DatabaseName;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getCreateDate() {
		return StrUtil.FormatDateTime(CreateDate);
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getUpdateDate() {
		return StrUtil.FormatDateTime(UpdateDate);
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	public String getType() {
		String Result = "";
		switch(Type){
		case 1:
			Result = "MySql";
			break;
		case 2:
			Result = "SqlServer";
			break;
		}
		return Result;
	}

	public void setType(int type) {
		Type = type;
	}

	public String getDatabaseName() {
		return DatabaseName;
	}

	public void setDatabaseName(String databaseName) {
		DatabaseName = databaseName;
	}

	public SqlMessage() {
		super();
	}
	
	
}
