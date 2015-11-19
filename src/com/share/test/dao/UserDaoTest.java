package com.share.test.dao;

import com.share.dao.UserDao;
import com.share.daoimpl.UserDaoImpl;
import com.share.domain.User;
import org.junit.Test;

/**
 * Created by WTJ on 2015/11/17.
 */
public class UserDaoTest {
    @Test
    public  void testUserInsert()throws  Exception{
        UserDao userDao=new UserDaoImpl();
        User user=new User();

        user.setName("llll2l");
        user.setPhone("2423232");

        user.setPassword("123456");

        userDao.registUser(user);

    }
    @Test
    public void testGetUser() throws Exception {
        UserDao userDao=new UserDaoImpl();
       User user= userDao.getUser(6);
        System.out.println(user);

    }
}
