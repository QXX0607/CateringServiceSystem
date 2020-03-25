package com.restaurant.view;

import javax.swing.*;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class Insert {

    Connection coon = null;
    PreparedStatement st;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    String sql = "insert into menu values(?,?,?,?)";

    public Insert(){}
    public Insert(String str1,String str2,String str3,String str4){
        try {
            Class.forName(driver);
            coon = DriverManager.getConnection(url,user,password);
            st = coon.prepareStatement(sql);
            st.setString(1, str1);
            st.setString(2, str2);
            st.setString(3, str3);
            st.setString(4, str4);
            st.executeUpdate();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if (null != coon) {
            try {
                coon.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"关闭数据库失败！","提示",1);
                e.printStackTrace();
            }
        }
    }
}