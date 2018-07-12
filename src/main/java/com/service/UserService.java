package com.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.User;
import com.repository.UserRepositoryImpl;
import com.util.MessageBox;


@Service
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,timeout=1000,readOnly=false)
public class UserService {

	@Autowired(required = true)
    private UserRepositoryImpl userRepositoryImpl;
	
	/**
	 *按账号查询
	 * @param Code
	 * @return
	 */
	public List<User> FindListByCode(String Code){
		return userRepositoryImpl.FindByHql("From User where UserName like '%"+Code+"%'");
	}
	/**
	 * 更新用户数据
	 * @param OldUser
	 * @param NewUser
	 * @return
	 */
	public Map<String, Object> UpdateUser(User OldUser,User NewUser){
		List<User> users =  userRepositoryImpl.FindByHql(String.format("from User where Id='%s' and UserName = '%s' and Password = '%s'", OldUser.getId(),OldUser.getUserName(),OldUser.getPassword()));
		if(users.size()>0){
			User user = users.get(0);
			user.setUserName(NewUser.getUserName());
			user.setPassword(NewUser.getPassword());
			userRepositoryImpl.Update(user);
			return MessageBox.SuccessBox("更新成功");
		}else{
			return MessageBox.ErrorBox("更新失败");
		}
	}
	
	/**
	 * 新增用户
	 * @param UserName
	 * @param Password
	 * @return
	 */
	public Map<String, Object> AddUser(String UserName,String Password){
		List<User> UserList = userRepositoryImpl.FindByHql(String.format("from User where UserName = '%s'", UserName));
		if(UserList.size()>1){
			return MessageBox.UserMessageBox("error","已存在此账号");
		}
		boolean check = userRepositoryImpl.Save(new User(UserName, Password));
		if(check){
			return MessageBox.UserMessageBox("success", "新增成功");
		}else{
			return MessageBox.UserMessageBox("error","插入失败");
		}
	}
	/**
	 *删除用户
	 * @param Id
	 * @return
	 */
	public Map<String, Object> DelUser(String Id){
		
		User user;
		try {
			user = userRepositoryImpl.FindByHql("from User where Id='"+Id+"'").get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
		}
		if(user!=null) {
			boolean check = userRepositoryImpl.Delete(user);
			if(check) {
				return MessageBox.UserMessageBox("success","删除账号"+user.getUserName()+"成功");
			}else {
				return MessageBox.UserMessageBox("error","删除账号失败");
			}
		}else {
			return MessageBox.UserMessageBox("error","找不到账号信息");
		}
	}
}
	