package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * 数据同步设置表
 * @author heyanzhu
 *
 */
@Data
@Entity
@Table(name="DataSyncMessage")
public class DataSyncMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="SqlText")
	private String SqlText;
	
	@Column(name="Memo")
	private String Memo;
	
	@ManyToOne
	@JoinColumn(name="SqlMessageNo")
	private SqlMessage SqlMessage;
	
	@Column(name="UpdateSqlText")
	private String UpdateSqlText;

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

	public String getSqlText() {
		return SqlText;
	}

	public void setSqlText(String sqlText) {
		SqlText = sqlText;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public SqlMessage getSqlMessage() {
		return SqlMessage;
	}

	public void setSqlMessage(SqlMessage sqlMessage) {
		SqlMessage = sqlMessage;
	}

	public String getUpdateSqlText() {
		return UpdateSqlText;
	}

	public void setUpdateSqlText(String updateSqlText) {
		UpdateSqlText = updateSqlText;
	}

	public DataSyncMessage() {
		super();
	}

	public DataSyncMessage(Long id, String name, String sqlText, String memo, com.model.SqlMessage sqlMessage,
			String updateSqlText) {
		super();
		Id = id;
		Name = name;
		SqlText = sqlText;
		Memo = memo;
		SqlMessage = sqlMessage;
		UpdateSqlText = updateSqlText;
	}
}
