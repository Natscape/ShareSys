package com.share.test.dao;

import com.share.dao.DynamicDao;
import com.share.daoimpl.DynamicDaoImpl;
import com.share.domain.Dynamic;
import com.share.domain.User;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by WTJ on 2015/11/18.
 */
public class DynamicTest {
    @Test
    public void testAddDynamic()throws  Exception{
        DynamicDao dynamicDao=new DynamicDaoImpl();
        Dynamic dynamic=new Dynamic();
        dynamic.setUserId(7);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        dynamic.setDate(new Date());
        dynamic.setImagePath("///////");
        dynamic.setImageDescription("花溪景");
      long dyId=  dynamicDao.addDynamic(dynamic);
        System.out.println(dyId);

    }
    @Test
    public void testDeleteDynamic() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
        dynamicDao.deleteDynamic(6);
    }
    @Test
    public void testGetDynamicUser() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
       User user= dynamicDao.getDynamicUser(5);
        System.out.println(user);

    }
    @Test
    public void testGetDynamic() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
        Dynamic dynamic=     dynamicDao.getDynamic(5);
        System.out.println(dynamic);

    }
    @Test
    public  void testgetAllDynamic() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
      List<Dynamic> list=dynamicDao.getAllDynamic();
        System.out.println(list);
    }
    @Test
    public  void testgetUserAllDynamic() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
        List<Dynamic> list=dynamicDao.getUserAllDynamic(6);
        System.out.println(list.size());
    }
    @Test
    public  void tesdeleteUserAllDynamic() throws SQLException {
        DynamicDao dynamicDao=new DynamicDaoImpl();
        dynamicDao.deleteUserAllDynamic(6);
    }
}
