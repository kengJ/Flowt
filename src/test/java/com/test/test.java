package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.service.MenuService;
import com.util.StrUtil;

public class test {
	@SuppressWarnings("unchecked")
	@Test
	public void sqltool(){
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://192.168.117.85:1433;DatabaseName=zkeco_db";
		String userName="sa";
		String userPwd="Csr.Donlim.Com";
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
		
		String sql ="select a.pin as code,c.name,a.checktime as flag,b.alias as clock  "+
"from checkinout a "+
"left join iclock b on a.sn_name=b.sn "+
"left join [192.168.117.20\\tong].[txcard].dbo.zlemployee c on a.pin = c.code "+
"where a.checktime between '2018-07-01 00:00:00.000' and '2018-07-31 23:59:59.000' and c.Dept like '01065201%'";
		Statement stmt;
		ResultSet result = null; 
		try {
			stmt = dbConn.createStatement();  
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败,sql:"+sql);
		}
		try {
			ResultSetMetaData rsm = result.getMetaData();
			String[] DataTop = new String[rsm.getColumnCount()];
			for(int index = 1;index<=rsm.getColumnCount();index++) {
				DataTop[index-1] = rsm.getColumnName(index);
			}
			List<Map<String, Object>> DataList = null;
			DataList = new ArrayList<Map<String, Object>>();
			while(result.next()) {
				Map<String, Object> Data = new HashMap<>();
				for(int index = 1;index<=rsm.getColumnCount();index++) {
					Data.put(rsm.getColumnName(index), result.getString(rsm.getColumnName(index)));
				}
				DataList.add(Data);
			}
			Map<String, Object>  flagData = new HashMap<>();
			for(Map<String, Object> line : DataList){
				String date = line.get("flag").toString();
				int Index = date.indexOf(" ");
				String Key = line.get("code")+"^"+date.substring(0, Index);
				List<String> flagTime = null;
				if(flagData.get(Key)==null){
					flagTime = new ArrayList<>();
					flagTime.add(date.substring(Index));
					flagData.put(Key, flagTime);
				}else{
					flagTime = (List<String>) flagData.get(Key);
					flagTime.add(date.substring(Index));
					flagData.put(Key, flagTime);
				}
			}
			System.out.println(flagData);
			//System.out.println(DataTop);
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
		@SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring.xml");
		MenuService o = ac.getBean(MenuService.class);
		System.out.println(o.FindAll());
	}
	
	@Test
	public void getCode(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\code.txt");
			byte bytes[]=new byte[1024];
            int n=0;
            String codes = "";
            while((n=fis.read(bytes))!= -1){
                String str = new String(bytes,0,n);
                //System.out.print(str);
                codes+=str;
            }
            System.out.println("codes="+codes.replaceAll("\n", ","));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
