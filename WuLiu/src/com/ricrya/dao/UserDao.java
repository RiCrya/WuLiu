package com.ricrya.dao;


import com.ricrya.entity.User;

public interface UserDao extends BaseDao<User> {
	//���ݵ�¼����ѯ�û�����
	public User getByUserName(String userName);
}
