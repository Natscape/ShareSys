package com.share.dao;

import java.sql.SQLException;
import java.util.List;

import com.share.domain.Dynamic;
import com.share.domain.User;

/**
 * 所有动态按时间排序
 */
public interface DynamicDao {
    // 分页查询所有的动态按时间排序
    public List<Dynamic> getAllDynamic() throws SQLException;

    //分页查询
    public List<Dynamic> getUserAllDynamic(long userId) throws SQLException;

    public Dynamic getDynamic(long id) throws SQLException;

    public void deleteDynamic(long dynamicId) throws SQLException;

    public long addDynamic(Dynamic dynamic) throws Exception;

    public User getDynamicUser(long dynamicId) throws SQLException;

    //级联删除所有评论
    public void deleteUserAllDynamic(long userId) throws SQLException;
}
