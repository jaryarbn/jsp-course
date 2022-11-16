package com.github.jaryarbn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private Connection con = null;

    public DataBase() {
        String url = "jdbc:mysql://localhost:3306/mini-shop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&autoReconnect=true&failOverReadOnly=false";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new DataBase().con);
    }

    public ResultSet getData(String sql) {
        Statement stm = null;
        try {
            stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);
            System.out.println("getData！！！");
            return result;
        } catch (SQLException e) {
            System.out.println("SQLException!!!");
            e.printStackTrace();
            return null;
        }
    }

    public void setData(String sql) throws SQLException {
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(sql);
            System.out.println(" setData！！！");

        } catch (SQLException e) {
            System.out.println("SQLException!!!");
            e.printStackTrace();

        }
    }

    public void close() {
        try {
            con.close();
            System.out.println("con.close");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
