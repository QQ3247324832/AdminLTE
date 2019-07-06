package com.example.demo.util;


import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author xinYing
 * @date 2019/7/4 20:48
 */
public class DBUtil {
    private static BasicDataSource ds;
    static{
        ds = new BasicDataSource();
        Properties cfg = new Properties();
        try {
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            cfg.load(in);
            in.close();
            String driver = cfg.getProperty("driver");
            String url = cfg.getProperty("url");
            String username = cfg.getProperty("username");
            String password = cfg.getProperty("password");
            int initial = Integer.parseInt(cfg.getProperty("initial"));
            int max = Integer.parseInt(cfg.getProperty("max"));
            int idle = Integer.parseInt(cfg.getProperty("idle"));
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            ds.setInitialSize(initial);
            ds.setMaxActive(max);
            ds.setMaxIdle(idle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Connection connection)  {
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
