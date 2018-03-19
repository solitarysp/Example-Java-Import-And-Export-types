package com.thanh;/*
  By Chi Can Em  19-03-2018
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://52.74.170.244:3306/xms_in_20180319", "xms", "123qweasd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
