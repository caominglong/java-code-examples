package com.banmao.advanced_grammar.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/22 下午9:46
 * @description 演示sql注入
 */
public class SqlInject01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlInject01 sqlInject01 = new SqlInject01();
        Connection conn = sqlInject01.getConn();
        Scanner scanner = new Scanner(System.in);
        // 输入 [1' or] 与 [or '1' = '1]
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密 码：");
        String pwd = scanner.nextLine();
        String selectSql = "select name, password from admin where name = '"+ name + "' and password = '"+pwd+"'";
        sqlInject01.execSelectSql(conn, selectSql);
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
        if (resultSet.next()) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败！");
        }

        resultSet.close();
        statement.close();
    }
}