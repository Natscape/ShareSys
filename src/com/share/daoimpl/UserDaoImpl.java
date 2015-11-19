package com.share.daoimpl;

import com.share.dao.UserDao;
import com.share.dbutil.DbTools;
import com.share.domain.User;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WTJ on 2015/11/17.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(int id) throws  Exception{
        QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="select * from user where user_id=?";
        Object []param={id};
        Map<String,String> beanMap=new HashMap<>();
        beanMap.put("user_id","id");
        beanMap.put("user_name","name");
        beanMap.put("user_phone","phone");
        beanMap.put("user_age","age");
        beanMap.put("user_pwd","password");
        BeanProcessor beanProcessor=new BeanProcessor(beanMap);
        RowProcessor rowProcessor=new BasicRowProcessor(beanProcessor);
        User user=queryRunner.query(sql,new BeanHandler<User>(User.class,rowProcessor),param);

        return user;
    }

    /**
     * 注册之前先查询
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean registUser(User user)throws Exception{
        QueryRunner queryRunner =new QueryRunner(DbTools.getDatasource());
        String sql="insert into user(user_name,user_phone,user_pwd) values(?,?,?)";
       Object param[]={user.getName(),user.getPhone(),user.getPassword()};
       long id= queryRunner.insert(sql,new ScalarHandler<Long>(),param);
        System.out.println(id);
        return true;
    }

    /**
     * 用户名不能更新
     * @param user
     * @return
     */
    @Override//
    public boolean updateUser(User user) {
        String sql="update user set  ";
        return false;
    }
}
