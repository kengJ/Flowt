package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.service.MenuService;
import com.util.StrUtil;

public class test {
	@Test
	public void sqltool(){
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://192.168.117.20\\tong:1433;DatabaseName=TxCard";
		String userName="tx_app";
		String userPwd="app#%(app23";
		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		Connection dbConn = null;
		try {
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接数据库成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}
		
		String sql ="select top 10 id from zlemployee";
		Statement stmt;
		ResultSet result = null; 
		try {
			stmt = dbConn.createStatement();  
			result = stmt.executeQuery(sql);
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败,sql:"+sql);
		}
		try {
			//ResultSetMetaData rsm = result.getMetaData();
			result.next();
			System.out.println(result.getString("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testStr(){
		//String Key = ;
		//String Sql = ;
		Object[] params = {"'%123456%'"};
		System.out.println(MessageFormat.format("from Menu where KeyName like {0}", params));
	}
	
	@Test
	public void testType(){
		
		String name = "123";
		System.out.println(StrUtil.IsBasicType(name));
	}
	
	@Test
	public void testBean(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring.xml");
		MenuService o = ac.getBean(MenuService.class);
		System.out.println(o.FindAll());
	}
}
