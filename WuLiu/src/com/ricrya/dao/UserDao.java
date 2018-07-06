package com.ricrya.dao;


import com.ricrya.entity.User;

public interface UserDao {
	//根据登录名查询用户对象
	public User getByUserName(String userName);
}
