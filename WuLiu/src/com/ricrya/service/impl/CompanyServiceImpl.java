package com.ricrya.service.impl;

import java.util.List;

import com.ricrya.dao.CompanyDao;
import com.ricrya.dao.impl.CompanyDaoImpl;
import com.ricrya.entity.Company;
import com.ricrya.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	
	CompanyDao cd = new CompanyDaoImpl();

	public List<Company> getAll() {
		String sql = "select c.*,s.site_name,s1.site_name as site_name1,t.typeName from company c left join site s on c.start_site_id = s.id left join site s1 on c.end_site_id = s1.id left join type t on c.type_id = t.typeid";
		return cd.getAll(sql);
	}

	public boolean update(Object... params) {
		String sql = "update company set companyName = ? , start_site_id = ? , end_site_id = ? ,type_id = ? , price = ? where id = ?";
		return cd.update(sql, params);
	}

	public boolean detele(int id) {
		String sql = "delete from  company where id = ?";
		return cd.detele(sql, id);
	}

	public boolean add(Object... params) {
		String sql = "insert into company (companyName,start_site_id,end_site_id,type_id,price) values (?,?,?,?,?)";
		return cd.add(sql, params);
	}

	public List<Company> search(Object... params) {
		String sql = "select c.*,s.site_name,s1.site_name as site_name1,t.typeName from company c left join site s on c.start_site_id = s.id left join site s1 on c.end_site_id = s1.id left join type t on c.type_id = t.typeid where companyName like ? or price like ? or s.site_name like ? or s1.site_name like ? or t.typeName like ? ";
		return cd.search(sql, params);
	}
	
	public List<Company> priceSearch(Object... params){
		String sql = "SELECT c.*,s.site_name,s1.site_name as site_name1,t.typeName FROM company c LEFT JOIN site s ON c.start_site_id = s.id LEFT JOIN site s1 ON c.end_site_id = s1.id LEFT JOIN type t ON c.type_id = t.typeid WHERE start_site_id = ? AND end_site_id = ? AND type_id = ?";
		return cd.search(sql, params);
	}

}
