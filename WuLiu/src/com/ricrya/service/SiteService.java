package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.Site;

public interface SiteService{
		//��������б�
		public List<Site> getAll();
		
		//�޸Ĳ���
		public boolean update(Object... params);
		
		//ɾ������
		public boolean detele(int id);
		
		//��Ӳ���
		public boolean add(Object... params);
		
		//���Ҳ���
		public List<Site> search(Object... params);
}
