package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.Company;
import com.ricrya.entity.Parcel;

public interface CompanyService {
	//��������б�
			public List<Company> getAll();
			
			//�޸Ĳ���
			public boolean update(Object... params);
			
			//ɾ������
			public boolean detele(int id);
			
			//��Ӳ���
			public boolean add(Object... params);
			
			//���Ҳ���
			public List<Company> search(Object... params);
			
			public List<Company> priceSearch(Object... params);
}
