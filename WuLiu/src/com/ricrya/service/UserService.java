package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.User;

public interface UserService {
	
	public User getLogin(User u);
	
	//获的所有列表
	public List<User> getAll();
		
	//修改操作
	public boolean update(Object... params);
		
	//删除操作
	public boolean detele(int id);
		
	//添加操作
	public boolean add(Object... params);
	
	//查找操作
	public List<User> search(Object... params);
	
}
