package com.ricrya.utils;

import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ComPoolUtil {

	static ComboPooledDataSource dataSource = null;
	
	static{
		dataSource  = new ComboPooledDataSource();  
	}
	

	public static QueryRunner getQueryRunner(){
		QueryRunner runner = new QueryRunner(dataSource);
		return runner;
	}
}
