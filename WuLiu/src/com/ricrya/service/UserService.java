package com.ricrya.service;

import java.util.List;

import com.ricrya.entity.User;

public interface UserService {
	
	public User getLogin(User u);
	
	//��������б�
	public List<User> getAll();
		
	//�޸Ĳ���
	public boolean update(Object... params);
		
	//ɾ������
	public boolean detele(int id);
		
	//��Ӳ���
	public boolean add(Object... params);
	
	//���Ҳ���
	public List<User> search(Object... params);
	
}
