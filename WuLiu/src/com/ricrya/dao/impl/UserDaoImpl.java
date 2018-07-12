package com.ricrya.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ricrya.dao.UserDao;
import com.ricrya.entity.User;
import com.ricrya.utils.ComPoolUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao  {

	public User getByUserName(String userName) {
		User user = new User();
		QueryRunner runner = new ComPoolUtil().getQueryRunner();
		String sql = "select * from User where userName = ?";
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class),userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
