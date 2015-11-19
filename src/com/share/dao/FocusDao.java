package com.share.dao;

import com.share.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by WTJ on 2015/11/17.
 */
public interface FocusDao {
    //？？？？根据userid 获取所有关注的用户
    public List<Long> getFocusUserId(long userId) throws SQLException;

    public void addFocusUser(long userId,long focusUserId) throws SQLException;

    public void cancerFocusUser(long userId,long focusUserId) throws SQLException;
}
