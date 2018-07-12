package com.ricrya.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ricrya.dao.BaseDao;
import com.ricrya.utils.ComPoolUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	//获得运行时的泛型类型
	private Class clazz;
		
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}	
	

	public List<T> getAll(String sql, Object... params) {
		List<T> list = new ArrayList<T>();
		
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			list = runner.query(sql, new BeanListHandler<T>(clazz),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean update(String sql, Object... params) {
		int i = 0;
		
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			i = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0){
			return true;
		}
		return false;
	}
	

	public boolean detele(String sql, int id) {
		int i = 0;
		
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			i = runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}if(i>0){
			return true;
		}
		return false;
	}

	
	public boolean add(String sql, Object... params) {
		int i = 0;
		
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			i = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}if(i>0){
			return true;
		}
		return false;
	}
	

	public List<T> search(String sql, Object... params) {
		List<T> list = new ArrayList<T>();
		
		try {
			QueryRunner runner = new ComPoolUtil().getQueryRunner();
			list = runner.query(sql, new BeanListHandler<T>(clazz),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public int page(String sql) {
		
		QueryRunner runner = new ComPoolUtil().getQueryRunner();
		int num = 0;
		try {
			num = (Integer)runner.query(sql, new ScalarHandler(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

}
