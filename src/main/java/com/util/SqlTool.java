package com.util;

import java.util.List;
import com.model.SqlMessage;

public class SqlTool {

	
	
	public List<String[]> GetData(SqlMessage sqlMessage , String Sql) {
		List<String[]> DataList = null;
		switch(sqlMessage.getType()) {
		case "Mysql":
			MySqlTool mySqlTool = new MySqlTool();
			DataList = mySqlTool.FindData(sqlMessage, Sql);
			break;
		case "SqlServer":
			SqlServerTool sqlServerTool = new SqlServerTool();
			DataList = sqlServerTool.FindData(sqlMessage, Sql);
			break;
		default:
			break;
		}
		return DataList;
	}
}
