package com.ricrya.service.impl;

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

}
