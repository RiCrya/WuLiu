package com.ricrya.dao;

import java.util.List;

public interface BaseDao<T> {
	//获的所有列表
	public List<T> getAll(String sql ,Object... params);
	
	//修改操作
	public boolean update(String sql ,Object... params);
	
	//删除操作
	public boolean detele(String sql,int id);
	
	//添加操作
	public boolean add(String sql,Object... params);
	
	//查找操作
	public List<T> search(String sql ,Object... params);
	
	//查询总数
	public int page(String sql);
}
