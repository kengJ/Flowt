package com.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@Table(name="ExcelTable")
public class ExcelTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@Column(name="TableName")
	private String TableName;
	
	@Column(name="SqlText")
	private String Sql;
	
	@Column(name="Memo")
	private String Memo;
	
	@Column(name="IsSplitTable")
	private int IsSplitTable;
	
	@Column(name="CreateDate")
	private Date CreateDate;
	
	@Column(name="UpdateDate")
	private Date UpdateDate;

	@Column(name="CodeIcon")
	private String CodeIcon;
	
	@Column(name="DeptIcon")
	private String DeptIcon;
	
	@Column(name="StartDateIcon")
	private String StartDateIcon;
	
	@Column(name="FinishDateIcon")
	private String FinishDateIcon;
	
	@ManyToOne
	@JoinColumn(name="SqlMessageNo")
	private SqlMessage SqlMessage;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTableName() {
		return TableName;
	}

	public void setTableName(String tableName) {
		TableName = tableName;
	}

	public String getSql() {
		return Sql;
	}

	public void setSql(String sql) {
		Sql = sql;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public int getIsSplitTable() {
		return IsSplitTable;
	}

	public void setIsSplitTable(int isSplitTable) {
		IsSplitTable = isSplitTable;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	public String getCodeIcon() {
		return CodeIcon;
	}

	public void setCodeIcon(String codeIcon) {
		CodeIcon = codeIcon;
	}

	public String getDeptIcon() {
		return DeptIcon;
	}

	public void setDeptIcon(String deptIcon) {
		DeptIcon = deptIcon;
	}

	public String getStartDateIcon() {
		return StartDateIcon;
	}

	public void setStartDateIcon(String startDateIcon) {
		StartDateIcon = startDateIcon;
	}

	public String getFinishDateIcon() {
		return FinishDateIcon;
	}

	public void setFinishDateIcon(String finishDateIcon) {
		FinishDateIcon = finishDateIcon;
	}

	public SqlMessage getSqlMessage() {
		return SqlMessage;
	}

	public void setSqlMessage(SqlMessage sqlMessage) {
		SqlMessage = sqlMessage;
	}

	@Override
	public String toString() {
		return "ExcelTable [Id=" + Id + ", TableName=" + TableName + ", Sql=" + Sql + ", Memo=" + Memo
				+ ", IsSplitTable=" + IsSplitTable + ", CreateDate=" + CreateDate + ", UpdateDate=" + UpdateDate
				+ ", CodeIcon=" + CodeIcon + ", DeptIcon=" + DeptIcon + ", StartDateIcon=" + StartDateIcon
				+ ", FinishDateIcon=" + FinishDateIcon + ", SqlMessage=" + SqlMessage + "]";
	}
	
	
}
