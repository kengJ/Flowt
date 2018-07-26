package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Table(name="Sys_User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="Password")
	private String Password;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="Role_Id",referencedColumnName="id")
	private Role Role;
	
	@Generated(GenerationTime.ALWAYS)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreateDate",nullable=false,columnDefinition="datetime default CURRENT_TIMESTAMP")
	private Date CreateDate;
	
	@Generated(GenerationTime.ALWAYS)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UpdateDate",nullable=false,columnDefinition="datetime default CURRENT_TIMESTAMP")
	private Date UpdateDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
	
	public User(String id ,String userName, String password) {
		super();
		Id = Long.parseLong(id);
		UserName = userName;
		Password = password;
	}

	public String getCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(CreateDate) ;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getUpdateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(UpdateDate) ;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", UserName=" + UserName + ", Password=" + Password + ", Role=" + Role
				+ ", CreateDate=" + CreateDate + ", UpdateDate=" + UpdateDate + "]";
	}

	public User(Long id, String userName, String password, com.model.Role role, Date createDate, Date updateDate) {
		super();
		Id = id;
		UserName = userName;
		Password = password;
		Role = role;
		CreateDate = createDate;
		UpdateDate = updateDate;
	}

	public User(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}
	
}
