package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.Parcel;

public interface ParcelService {
		//��������б�
		public List<Parcel> getAll();
		
		//�޸Ĳ���
		public boolean update(Object... params);
		
		//ɾ������
		public boolean detele(int id);
		
		//��Ӳ���
		public boolean add(Object... params);
		
		//���Ҳ���
		public List<Parcel> search(Object... params);
		
		public int page();
		
		public List<Parcel> searchList(Object... params);
}
