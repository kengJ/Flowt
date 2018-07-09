package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.SqlMessage;

public class MySqlTool {

	public Connection CreateConn(SqlMessage sqlMessage) {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    String DB_URL = String.format("jdbc:mysql://%:3306/%", sqlMessage.getIp(),sqlMessage.getDatabaseName());
	    String USER = sqlMessage.getUserName();
	    String PASS = sqlMessage.getPassword();
	    
	    Connection conn = null;
	    try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	    
	    return conn;
	}
	
	public List<String[]> FindData(SqlMessage sqlMessage,String Sql){
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        List<String[]> DataList = null;
        conn = CreateConn(sqlMessage);
        try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql);
			rsm = rs.getMetaData();
			DataList = new ArrayList<String[]>();
			while(rs.next()) {
				String[] Data = new String[rsm.getColumnCount()];
				for(int index = 1;index<=rsm.getColumnCount();index++) {
					Data[index-1] = rs.getString(rsm.getColumnName(index));
				}
				DataList.add(Data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DataList;
	}
}
