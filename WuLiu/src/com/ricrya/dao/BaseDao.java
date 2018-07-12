package com.ricrya.dao;

import java.util.List;

public interface BaseDao<T> {
	//��������б�
	public List<T> getAll(String sql ,Object... params);
	
	//�޸Ĳ���
	public boolean update(String sql ,Object... params);
	
	//ɾ������
	public boolean detele(String sql,int id);
	
	//��Ӳ���
	public boolean add(String sql,Object... params);
	
	//���Ҳ���
	public List<T> search(String sql ,Object... params);
	
	//��ѯ����
	public int page(String sql);
}
