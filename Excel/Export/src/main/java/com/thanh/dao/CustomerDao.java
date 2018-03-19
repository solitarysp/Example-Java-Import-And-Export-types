package com.thanh.dao;/*
  By Chi Can Em  19-03-2018
 */



import com.thanh.ConnectDB;
import com.thanh.mode.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static List<Customer> getList() {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement("SELECT xtc.customer_code,xtcd.customer_name,xtc.gstid FROM xms_tbl_customer AS xtc JOIN xms_tbl_customer_address AS xtcd ON xtc.customer_code = xtcd.customer_code");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setGst(resultSet.getString(3));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
