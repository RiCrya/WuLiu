package com.ricrya.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ricrya.dao.ParcelDao;
import com.ricrya.dao.impl.ParcelDaoImpl;
import com.ricrya.entity.Parcel;
import com.ricrya.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {
	
	ParcelDao pkgd = new ParcelDaoImpl();

	public List<Parcel> getAll() {
		String sql ="select p.*,s.site_name,s1.site_name as site_name1,t.typeName from parcel p left join site s on p.pkg_start_id = s.id left join site s1 on p.pkg_end_id = s1.id left join type t on p.pkg_type_id = t.typeid";
		return pkgd.getAll(sql);
	}

	public boolean update(Object... params) {
		String sql = "update parcel set pkg_number = ?, pkg_start_id = ?, pkg_end_id = ?,pkg_type_id = ?,sender = ?, sender_phone = ? ,recipient = ?,recipient_phone = ? where id = ?";
		return pkgd.update(sql, params);
	}

	public boolean detele(int id) {
		String sql = "delete from  parcel where id = ?";
		return pkgd.detele(sql, id);
	}

	public boolean add(Object... params) {
		String sql = "INSERT INTO parcel (pkg_number,pkg_start_id,pkg_end_id,pkg_type_id,sender,sender_phone,recipient,recipient_phone) VALUES (?,?,?,?,?,?,?,?)";
		return pkgd.add(sql, params);
	}

	public List<Parcel> search(Object... params) {	
		String sql = "select p.*,s.site_name,s1.site_name as site_name1,t.typeName from parcel p left join site s on p.pkg_start_id = s.id left join site s1 on p.pkg_end_id = s1.id left join type t on p.pkg_type_id = t.typeid where pkg_number like ? or sender like ? or sender_phone like ? or recipient like ? or recipient_phone like ? or s.site_name like ? or s1.site_name like ? or t.typeName like ?";
		return pkgd.search(sql, params);
	}

	public int page() {
		String sql = "SELECT COUNT(*) FROM parcel";
		return pkgd.page(sql);
	}

	public List<Parcel> searchList(Object... params) {
		String sql = "SELECT p.*,s.site_name,s1.site_name as site_name1,t.typeName from parcel p left join site s on p.pkg_start_id = s.id left join site s1 on p.pkg_end_id = s1.id left join type t on p.pkg_type_id = t.typeid WHERE pkg_number = ?";
		return pkgd.search(sql, params);
	}



}
