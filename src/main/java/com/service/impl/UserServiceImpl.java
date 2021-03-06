package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.BasicRepository;
import com.repository.impl.UserRepositoryImpl;
import com.service.UserService;

@Service(value="userService")
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,timeout=1000,readOnly=false)
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService{

	@Autowired(required = true)
    private UserRepositoryImpl userRepositoryImpl;

	@Override
	public List<User> FindByKey(String Key) {
		String Hql = "from User where UserName like '%"+Key+"%' or Password like '%"+Key+"%'";
		return userRepositoryImpl.FindByHql(Hql);
	}

	@Override
	public BasicRepository<User> GetBasicRepository() {
		return userRepositoryImpl;
	}
	
	/**
	 *按账号查询
	 * @param Code
	 * @return
	 */
	/**public List<User> FindListByCode(String Code){
		return userRepositoryImpl.FindByHql("From User where UserName like '%"+Code+"%'");
	}**/
	/**
	 * 更新用户数据
	 * @param OldUser
	 * @param NewUser
	 * @return
	 */
	/**public Map<String, Object> UpdateUser(User OldUser,User NewUser){
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
	}**/
	
	/**
	 * 新增用户
	 * @param UserName
	 * @param Password
	 * @return
	 */
	/**public Map<String, Object> AddUser(String UserName,String Password){
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
	}**/
	/**
	 *删除用户
	 * @param Id
	 * @return
	 */
	/**public Map<String, Object> DelUser(String Id){
		
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
	}**/
	
	/**public List<User> FindAll(){
		return userRepositoryImpl.FindByHql("from User");
	}**/
	
	/**public List<User> FindByKey(String Key){
		String Sql = String.format("from User where UserName like '%%s%'", Key);
		return userRepositoryImpl.FindByHql(Sql);
	}**/
	/**public User FindById(String id) {
		try {
			String Sql = String.format("from User where Id = '%s'", id);
			return userRepositoryImpl.FindByHql(Sql).get(0);
		} catch (Exception e) {
			return null;
		}
	}**/
	/**@Override
	public boolean Add(User o) {
		userRepositoryImpl.Save(o);
		return true;
	}**/
	
	/**@Override
	public boolean Delete(User o) {
		userRepositoryImpl.Delete(o);
		return true;
	}**/
	/**@Override
	public boolean Update(User o) {
		userRepositoryImpl.Update(o);
		return true;
	}**/
}
	