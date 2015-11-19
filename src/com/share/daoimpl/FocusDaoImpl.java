package com.share.daoimpl;

import com.share.dao.FocusDao;
import com.share.dbutil.DbTools;
import com.share.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WTJ on 2015/11/18.
 */
public class FocusDaoImpl implements FocusDao {
    /**
     * 没有关注user 返回值为0，否则返回被关注者的id
     * @param userId
     * @return
     * @throws SQLException
     */
    @Override
    public List<Long> getFocusUserId(long userId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="select Use_user_id from focus where user_id=?";
        Object[] param={userId};
       List ls= queryRunner.query(sql, new ArrayListHandler(),param);
        List<Long> focusUserId=new ArrayList<>();
        for (Object obj:ls){
            Object []objs=(Object[])obj;
           String s= objs[0]+"";
           focusUserId.add(Long.parseLong(s));

        }
        return focusUserId;
    }

    @Override//在执行关注之前先判断用户是否已被关注
    public void addFocusUser(long userId, long focusUserId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="insert into focus(user_id,Use_user_id) values(?,?)";
        Object []param={userId,focusUserId};
        queryRunner.update(sql,param);

    }

    @Override
    public void cancerFocusUser(long userId, long focusUserId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="delete from focus where user_id=? and Use_user_id=? ";
        Object []param={userId,focusUserId};
        queryRunner.update(sql,param);

    }
}
