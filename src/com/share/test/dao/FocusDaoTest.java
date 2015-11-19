package com.share.test.dao;

import com.share.dao.FocusDao;
import com.share.daoimpl.FocusDaoImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by WTJ on 2015/11/18.
 */
public class FocusDaoTest {
    @Test
    public void getFocusUser() throws SQLException {
    FocusDao focusDao=new FocusDaoImpl();
    List<Long> longs=focusDao.getFocusUserId(6);
        System.out.println(longs);


    }

    @Test
    public void addFocusUser() throws SQLException {
        FocusDao focusDao=new FocusDaoImpl();
        focusDao.addFocusUser(7,6);


    }

@Test
    public void cancerFocusUser() throws SQLException {
        FocusDao focusDao=new FocusDaoImpl();
        focusDao.cancerFocusUser(7,6);

    }
}
