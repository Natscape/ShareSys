package com.share.dao;

import java.util.List;

import com.share.domain.Dynamic;
import com.share.domain.User;

public interface AdminDao {
	// 代码有重复。。。。。
	public boolean deleteUser(long userId);

	public boolean deleteDynamic(long  dynamicId);

	public List<Dynamic> getAllDynamic();

	public User getUser(long id);

}
