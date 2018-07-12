package com.ricrya.service.impl;

import java.util.List;

import com.ricrya.dao.UserDao;
import com.ricrya.dao.impl.UserDaoImpl;
import com.ricrya.entity.User;
import com.ricrya.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao ud = new UserDaoImpl();

	
	//登陆方法
	public User getLogin(User u) {
		//调用dao查询用户
		User user = ud.getByUserName(u.getUserName());
		return user;
	}


	public List<User> getAll() {
		String sql = "select * from user";
		return ud.getAll(sql);
	}


	public boolean update(Object... params) {
		String sql = "update user set userName = ? , userPassword = ? where id = ?";
		return ud.update(sql, params);
	}


	public boolean detele(int id) {
		String sql = "delete from  user where id = ?";
		return ud.detele(sql, id);
	}


	public boolean add(Object... params) {
		String sql = "insert into user (userName,userPassword) values (?,?)";
		return ud.add(sql, params);
	}


	public List<User> search(Object... params) {
		String sql = "SELECT * FROM user WHERE userName LIKE ?";
		return ud.search(sql, params);
	}


	

}
