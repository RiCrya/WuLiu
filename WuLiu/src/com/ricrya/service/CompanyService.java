package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.Company;
import com.ricrya.entity.Parcel;

public interface CompanyService {
	//获的所有列表
			public List<Company> getAll();
			
			//修改操作
			public boolean update(Object... params);
			
			//删除操作
			public boolean detele(int id);
			
			//添加操作
			public boolean add(Object... params);
			
			//查找操作
			public List<Company> search(Object... params);
			
			public List<Company> priceSearch(Object... params);
}
