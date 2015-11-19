package com.share.daoimpl;

import com.share.dao.DynamicDao;
import com.share.dbutil.DbTools;
import com.share.domain.Dynamic;
import com.share.domain.User;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WTJ on 2015/11/18.
 */
public class DynamicDaoImpl implements DynamicDao {
    /**
     * 如果表为空，返回结果为list.size=0
     * @return
     * @throws SQLException
     */
    @Override
    public List<Dynamic> getAllDynamic() throws SQLException {
        String sql="select * from Dynamic";
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());

    return queryRunner.query(sql, new BeanListHandler<Dynamic>(Dynamic.class,getRowProcessor()));

    }

    @Override
    public List<Dynamic> getUserAllDynamic(long userId) throws SQLException {

        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="select * from Dynamic where user_id=?";
        Object []param={userId};
        return queryRunner.query(sql, new BeanListHandler<Dynamic>(Dynamic.class,getRowProcessor()),param);
    }

    @Override
    public Dynamic getDynamic(long id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="select * from Dynamic where dynamic_id=?";
        Object []param={id};
     return  queryRunner.query(sql, getBeanHandler(), param);

    }

    @Override
    public void deleteDynamic(long dynamicId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="delete from Dynamic where dynamic_id=?";
        queryRunner.update(sql,dynamicId);

    }

    @Override
    public long addDynamic(Dynamic dynamic) throws Exception{
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql = "insert into Dynamic(user_id,content,description,date) values(?,?,?,?)";
        Object []param={dynamic.getUserId(),dynamic.getImagePath(),dynamic.getImageDescription(),dynamic.getDate()};
      return queryRunner.insert(sql,new ScalarHandler<Long>(),param);

    }

    @Override
    public User getDynamicUser(long dynamicId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="select * from Dynamic where dynamic_id=?";
        Object []param={dynamicId};
       Integer userId= queryRunner.query(sql, new ScalarHandler<Integer>("user_id"), param);
        System.out.println("------"+userId);
        sql="select * from user where user_id=?";
        Object []paramUser={userId};
        Map<String,String> beanMap=new HashMap<>();
        beanMap.put("user_id","id");
        beanMap.put("user_name","name");
        beanMap.put("user_sex","sex");
        beanMap.put("user_age","age");
        beanMap.put("user_pwd","password");
        BeanProcessor beanProcessor=new BeanProcessor(beanMap);
        RowProcessor rowProcessor=new BasicRowProcessor(beanProcessor);
        User user=queryRunner.query(sql,new BeanHandler<User>(User.class,rowProcessor),userId);
        return user;
    }

    @Override
    public void deleteUserAllDynamic(long userId) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="delete from Dynamic where user_id=?";
        queryRunner.update(sql, userId);

    }
    private BeanHandler<Dynamic> getBeanHandler(){
       return new BeanHandler<Dynamic>(Dynamic.class, getRowProcessor());
    }
    private  RowProcessor getRowProcessor(){
        Map<String,String> beanMap=new HashMap<>();
        beanMap.put("dynamic_id","id");
        beanMap.put("user_id","userId");
        beanMap.put("content","imagePath");
        beanMap.put("description","imageDescription");
        beanMap.put("date","date");
        BeanProcessor beanProcessor=new BeanProcessor(beanMap);
        RowProcessor rowProcessor=new BasicRowProcessor(beanProcessor);
        return rowProcessor;
    }
}
