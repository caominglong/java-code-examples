package com.banmao.advanced_grammar.jdbc;

import java.sql.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/22 下午10:06
 * @description
 */
public class PreparedStatement01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "select name, password from admin where name = ? and password = ?";
        PreparedStatement01 preparedStatement01 = new PreparedStatement01();
        Connection conn = preparedStatement01.getConn();
        preparedStatement01.execSelectSql(conn, sql);
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
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, "1' or");
        preparedStatement.setString(2, "or '1' = '1");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}