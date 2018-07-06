package com.ricrya.service.impl;

import com.ricrya.dao.UserDao;
import com.ricrya.dao.impl.UserDaoImpl;
import com.ricrya.entity.User;
import com.ricrya.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao ud = new UserDaoImpl();

	public User login(User u) {
		return ud.login(u);
	}

}
