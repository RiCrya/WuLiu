package com.ricrya.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ricrya.dao.UserDao;
import com.ricrya.entity.User;
import com.ricrya.utils.ComPoolUtil;

public class UserDaoImpl implements UserDao {

	public User login(User u) {
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			String sql = "select * from User where username = ? and password = ?";
			u = runner.query(sql, new BeanHandler<User>(User.class), u.getUserName(),u.getUserPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
