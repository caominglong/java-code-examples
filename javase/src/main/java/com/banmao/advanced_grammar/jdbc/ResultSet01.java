package com.banmao.advanced_grammar.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/22 下午8:36
 * @description
 */
public class ResultSet01 {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet01 resultSet01 = new ResultSet01();
        Connection conn = resultSet01.getConn();
        String selectSql = "select id, name, sex, borndate from actor";
        resultSet01.execSelectSql(conn, selectSql);
    }

    public Connection getConn() throws SQLException, ClassNotFoundException {
        // 前置：下载驱动，并加入到运行环境中
        // 1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2、得到连接
        // jdbc:mysql:  规定好协议
        String url = "jdbc:mysql://localhost:3306/study_db";

        Connection connect = DriverManager.getConnection(url, "cao", "12345Aa@");
        return connect;
    }

    public void execSelectSql(Connection connect, String sql) throws SQLException {
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        resultSet.close();
        statement.close();
    }
}