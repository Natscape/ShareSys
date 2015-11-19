package com.share.dao;

import java.util.List;

import com.share.domain.User;

public interface UserDao {
	
	public User getUser(int id) throws Exception;
	//删除user将会删除user所发布的所有内容
	public boolean registUser(User user) throws Exception;
	
	public boolean updateUser(User user);
}
