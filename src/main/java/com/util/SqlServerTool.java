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

/***
 * sqlserver
 * @author heyanzhu
 *
 */
public class SqlServerTool {

	public Connection CreateConn(SqlMessage sqlMessage) {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = String.format("jdbc:sqlserver://%s:1433;DatabaseName=%s", sqlMessage.getIp(), sqlMessage.getDatabaseName());
		//String dbURL="jdbc:sqlserver://192.168.117.20\\tong:1433;DatabaseName=TxCard";
		String userName=sqlMessage.getUserName();
		String userPwd=sqlMessage.getPassword();
		Connection dbConn=null;
		try {
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��");
		}
		return dbConn;
	}
	
	public List<String[]> FindData(SqlMessage sqlMessage,String Sql) {
		Connection dbConn = CreateConn(sqlMessage);
		Statement stmt = null;
		ResultSet result = null;
		ResultSetMetaData rsm = null;
		List<String[]> DataList = null;
		try {
			stmt = dbConn.createStatement();
			result = stmt.executeQuery(Sql);
			rsm = result.getMetaData();
			DataList = new ArrayList<String[]>();
			String[] DataTop = new String[rsm.getColumnCount()];
			for(int index = 1;index<=rsm.getColumnCount();index++) {
				DataTop[index-1] = rsm.getColumnName(index);
			}
			DataList.add(DataTop);
			while(result.next()) {
				String[] Data = new String[rsm.getColumnCount()];
				for(int index = 1;index<=rsm.getColumnCount();index++) {
					Data[index-1] = result.getString(rsm.getColumnName(index));
				}
				DataList.add(Data);
			}
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		} finally {
			try {
				stmt.close();
				dbConn.close();
			} catch (SQLException e) {
				System.out.println("�ر����ݿ�����ʧ��");
			}
			
		}
		return DataList;
		
	}
}
