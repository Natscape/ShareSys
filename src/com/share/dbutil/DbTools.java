package com.share.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by WTJ on 2015/11/17.
 */
public class DbTools {
    private DbTools(){}
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    public  static ComboPooledDataSource getDatasource(){
        return  ds;
    }
    public static Connection getConnection() {
        try {

            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
