package com.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.service.IExcelTableService;
import com.service.ISqlMessageService;
import com.service.IUserService;

@Controller
public class TestControllerImpl {
	@SuppressWarnings("unused")
	@Autowired(required=true)
    private IUserService userService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ISqlMessageService SqlMessageService;
	
	@SuppressWarnings("unused")
	@Autowired
	private IExcelTableService excelTableService;
	
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
