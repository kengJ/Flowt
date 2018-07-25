package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="Pass_Computer")
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="LoginName")
	private String LoginName;
	
	@Column(name="Ip")
	private String Ip;

	@Column(name="UserCode")
	private String UserCode;
	
	@Column(name="UserName")
	private String UserName;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getUserCode() {
		return UserCode;
	}

	public void setUserCode(String userCode) {
		UserCode = userCode;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String toString() {
		return "Computer [Id=" + Id + ", LoginName=" + LoginName + ", Ip=" + Ip + ", UserCode=" + UserCode
				+ ", UserName=" + UserName + "]";
	}
	
	public Computer(Long id, String loginName, String ip, String userCode, String userName) {
		super();
		Id = id;
		LoginName = loginName;
		Ip = ip;
		UserCode = userCode;
		UserName = userName;
	}

	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Computer(String loginName, String ip) {
		super();
		LoginName = loginName;
		Ip = ip;
		UserCode = "Admin";
		UserName = "Admin";
	}


}
