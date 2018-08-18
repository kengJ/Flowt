package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="RoleName")
	private String RoleName;
	
	@Column(name="Memo")
	private String Memo;

	@Override
	public String toString() {
		return "Role [id=" + Id + ", RoleName=" + RoleName + ", Memo=" + Memo + "]";
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public Role(String roleName, String memo) {
		super();
		RoleName = roleName;
		Memo = memo;
	}

	public Role() {
		super();
	}
}
