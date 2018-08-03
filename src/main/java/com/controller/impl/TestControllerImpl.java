package com.controller.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.ExcelTableService;
import com.service.SqlMessageService;
import com.service.UserService;
import com.util.ExcelHelp;
import com.views.ViewExcel;

@Controller
public class TestControllerImpl {
	@SuppressWarnings("unused")
	@Autowired(required=true)
    private UserService userService;
	
	@SuppressWarnings("unused")
	@Autowired
	private SqlMessageService SqlMessageService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ExcelTableService excelTableService;
	
	@RequestMapping("/Test")
	public ModelAndView Test(){
		Map<String, Object>  flagData =null;
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
		
		String sql ="select a.pin as code,c.name,a.checktime as flag,b.alias as clock ,d.LongName as dept "+
"from checkinout a "+
"left join iclock b on a.sn_name=b.sn "+
"left join [192.168.117.20\\tong].[txcard].dbo.zlemployee c on a.pin = c.code "+
"left join [192.168.117.20\\tong].[txcard].dbo.zldept d on c.dept = d.code "+
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
			flagData = new HashMap<>();
			for(Map<String, Object> line : DataList){
				String date = line.get("flag").toString();
				int Index = date.indexOf(" ");
				//deptname
				String Key = line.get("code")+"^"+date.substring(0, Index)+"^"+line.get("name")+"^"+line.get("dept");
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
			//System.out.println(flagData);
			//System.out.println(DataTop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String[]> flagDataList = new ArrayList<>();
		for(String key :flagData.keySet()){
			List<String> time = (List<String>) flagData.get(key);
			
			String[] line = new String[time.size()+4];
			int Index = key.indexOf("^");
			line[0] = key.substring(0,Index);
			String str = key.substring(Index+1);
			Index = str.indexOf("^");
			line[1] = str.substring(0,Index);
			str = str.substring(Index+1);
			Index = str.indexOf("^");
			line[2] = str.substring(0,Index);
			line[3] = str.substring(Index+1);
			int i = 4;
			
			/**
			String str = key.substring(Index+1);
			int Index1 = str.indexOf("^");
			line[1] = str.substring(Index+1,Index1);
			line[2] = str.substring(Index1+1);
			**/
			for(String value : time){
				line[i] = value.substring(0, value.length()-2);
				i++;
			}
			//line[0] = key;
			//System.out.println(line.length);
			flagDataList.add(line);
		}
		//System.out.println(flagDataList);
		//List<Map<String, Object>> model = new ArrayList<>();
		//model.add(e)
		
		//result.put("model", model);
		String [] title = {};
		Map<String,Object> result1 = new HashMap<String,Object>();
    	result1.put("model", ExcelHelp.ExcelModel(null, "test", title , flagDataList));
		return new ModelAndView(new ViewExcel(),result1);
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	@ResponseBody
//    public ModelAndView test() {
//		List<SqlMessage> sqlMessages = SqlMessageService.FindSqlMessage();
//		SqlMessage sqlMessage =  sqlMessages.get(0);
//		SqlTool sqlTool = new SqlTool();
//		String Sql = "select top 10 * from kq_card"; 
//		List<String[]> Data = sqlTool.GetData(sqlMessage, Sql);
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("DataTitle", Data.get(0));
//		Data.remove(0);
//		model.put("DataList", Data);
//        
//        return new ModelAndView(new ViewExcel(), model);
//    }
//	@RequestMapping(value = "/TxCode")
//	@ResponseBody
//	public Map<String, String> TxCode(){
//		Map<String, String> json = new HashMap<String, String>();
//		json.put("db", "TxCardb18");
//		json.put("code", "050161237052242231051164050161235166216051155138035153092221159023121");
//		json.put("computer", "P09240");
//		return json;
//	}
//
//    @RequestMapping(value = "/savePerson", method = RequestMethod.GET)
//    @ResponseBody
//    public String savePerson() {
//    	//userService.Save();
//        return "success!";
//    }
//    
//    @RequestMapping("/Test1")
//    @ResponseBody
//    public ModelAndView test3(@RequestParam String ExcelTableId,
//    					@RequestParam(defaultValue="") String Code,
//    					@RequestParam(defaultValue="") String Dept,
//    					@RequestParam(defaultValue="") String StartDate,
//    					@RequestParam(defaultValue="") String FinishDate){
//    	
//    	List<Map<String, Object>> model = excelTableService.FindData(ExcelTableId, Code, Dept, StartDate, FinishDate);
//    	System.out.println(model.toString());
//    	Map<String,Object> result = new HashMap<String,Object>();
//    	result.put("model", model);
//    	return new ModelAndView(new ViewExcel(),result);
//    }
    
}
