package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ExcelTable;
import com.repository.BasicRepository;
import com.repository.ExcelTableRepository;
import com.service.ExcelTableService;
@Service(value="excelTableService")
public class ExcelTableServiceImpl extends BasicServiceImpl<ExcelTable> implements ExcelTableService{

	@Autowired
	private ExcelTableRepository excelTableRepository;

	@Override
	public List<ExcelTable> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicRepository<ExcelTable> GetBasicRepository() {
		return excelTableRepository;
	}
	
	/**public boolean AddExcelTable(ExcelTable excelTable){
		excelTableRepository.Save(excelTable);
		return true;
	}
	
	public List<Map<String, Object>> FindData(String ExceleTableId,String code,String Dept,String StartDate,String FinishDate){
		List<Map<String, Object>> Book = null;
		if(!Dept.equals("")&&Dept!=""){
    		if(Dept.indexOf(",")!=-1||Dept.indexOf("，")!=-1){
    			String indexStr = Dept.indexOf(",")!=-1?",":"，";
    			String[] Depts = Dept.split(indexStr);
    			for(String dept : Depts){
    				List<String[]> Data = FindDataBasic(ExceleTableId,code,dept,StartDate,FinishDate);
    				String[] Title = (String[]) Data.get(0);
    				Data.remove(0);
    				Book = ExcelHelp.ExcelModel(Book, dept, Title, Data);
    			}
    		}else{
        		List<String[]> Data = FindDataBasic(ExceleTableId,code,Dept,StartDate,FinishDate);
    			String[] Title = (String[]) Data.get(0);
    			Data.remove(0);
    			Book = ExcelHelp.ExcelModel(Book, Dept, Title, Data);
        	}
    	}else{
    		List<String[]> Data = FindDataBasic(ExceleTableId,code,Dept,StartDate,FinishDate);
			String[] Title = (String[]) Data.get(0);
			Data.remove(0);
			Book = ExcelHelp.ExcelModel(Book, Dept, Title, Data);
    	}
        return Book;
	}
	
	public List<String[]> FindDataBasic(String ExceleTableId,String code,String Dept,String StartDate,String FinishDate){
		ExcelTable excelTable = excelTableRepository.Find(ExceleTableId);
		SqlMessage sqlMessage = excelTable.getSqlMessage();
		String Sql = excelTable.getSql();
		String codeicon = excelTable.getCodeIcon();
		String depticon = excelTable.getDeptIcon();
		String StartDateicon = excelTable.getStartDateIcon();
		String FinishDateicon = excelTable.getFinishDateIcon();
		Sql = Sql.replaceAll(codeicon, code).replaceAll(depticon, Dept).replaceAll(StartDateicon, StartDate).replaceAll(FinishDateicon, FinishDate);
		SqlTool sqlTool = new SqlTool();
		System.out.println(Sql);
		List<String[]> Data = sqlTool.GetData(sqlMessage, Sql);
		return Data;
	}
	
	public List<ExcelTable> FindExcelTables(){
		//List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		//List<ExcelTable> ExcelTables = excelTableRepository.Find();
		/**for(int i = 0;i<ExcelTables.size();i++){
			Map<String, Object> map = new HashMap<String,Object>();
			ExcelTable excelTable = ExcelTables.get(i);
			map.put(excelTable.getId().toString(),excelTable.getMemo());
			result.add(map);
		}**/
		//return result;
		/**return excelTableRepository.Find();
	}**/
	
	/**public Map<String, Object> Find(String Code){
		try {
			List<ExcelTable> DataList = null;
			if(Code==""||Code.equals("")){
				DataList = excelTableRepository.Find();
			}else{
				DataList = excelTableRepository.FindByHql(String.format("from ExcelTable where Memo like '%%s%' or Ip like '%%s%'", Code,Code));
			}
			if(DataList==null||DataList.size()==0){
				return MessageBox.ErrorBox("查询错误，未能查到相应记录");
			}else{
				return MessageBox.SuccessBox("查询成功", DataList);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return MessageBox.ErrorBox("查询异常");
		}
	}**/
}
