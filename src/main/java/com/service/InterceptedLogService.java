package com.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.InterceptedLog;
import com.repository.InterceptedLogRepository;
@Service
public class InterceptedLogService implements BasicService<InterceptedLog>{

	@Autowired
	private InterceptedLogRepository interceptedLogRepository;
	
	@Override
	public boolean Add(InterceptedLog o) {
		try{
			interceptedLogRepository.Save(o);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Delete(InterceptedLog o) {
		try {
			interceptedLogRepository.Delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Update(InterceptedLog o) {
		try {
			interceptedLogRepository.Update(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<InterceptedLog> FindAll() {
		return interceptedLogRepository.FindByHql("from InterceptedLog");
	}

	@Override
	public InterceptedLog FindById(String Id) {
		// TODO Auto-generated method stub
		try {
			return interceptedLogRepository.FindByHql(String.format("from InterceptedLog where Id = '%s'", Id)).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 保存拦截记录
	 * @param ComputerName
	 * @param UrI
	 */
	public boolean SaveInterceptedComputer(String Ip,String UrI){
		try {
			//查询是否已存在记录
			List<InterceptedLog> InterceptedLogs = interceptedLogRepository.FindByHql(String.format("from InterceptedLog where Ip= '%s'", Ip));
			InterceptedLog MaxInterceptedLog = null;
			//判断是否存在记录
			if(InterceptedLogs!=null&&InterceptedLogs.size()>0){
				if(InterceptedLogs.size()>1){
					for(InterceptedLog interceptedLog : InterceptedLogs){
						if(MaxInterceptedLog==null){
							MaxInterceptedLog = interceptedLog;
						}else{
							if(interceptedLog.getId()>MaxInterceptedLog.getId()){
								MaxInterceptedLog = interceptedLog;
							}
						}
					}//for end
					//更新数据
					MaxInterceptedLog.setDateTime(new Date());
					MaxInterceptedLog.setUrI(UrI);
					interceptedLogRepository.Update(MaxInterceptedLog);
				}else{
					//插入新数据
					interceptedLogRepository.Update(InterceptedLogs.get(0));
				}//if end
			}else{
				interceptedLogRepository.Save(new InterceptedLog(Ip, UrI));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
