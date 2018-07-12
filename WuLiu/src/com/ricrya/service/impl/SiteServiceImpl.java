package com.ricrya.service.impl;

import java.util.List;

import com.ricrya.dao.SiteDao;
import com.ricrya.dao.impl.SiteDaoImpl;
import com.ricrya.entity.Site;
import com.ricrya.service.SiteService;

public class SiteServiceImpl implements SiteService {
	
	private SiteDao sd = new SiteDaoImpl();

	public List<Site> getAll() {
		String sql = "select * from site";
		return sd.getAll(sql);
	}

	public boolean update(Object... params) {
		String sql = "update site set site_name = ? where id = ?";
		return sd.update(sql, params);
	}

	public boolean detele(int id) {
		String sql = "delete from  site where id = ?";
		return sd.detele(sql, id);
	}

	public boolean add(Object... params) {
		String sql = "insert into site (site_name) values (?)";
		return sd.add(sql, params);
	}

	public List<Site> search(Object... params) {
		String sql = "SELECT * FROM site WHERE site_name LIKE ?";
		return sd.search(sql, params);
	}

}
