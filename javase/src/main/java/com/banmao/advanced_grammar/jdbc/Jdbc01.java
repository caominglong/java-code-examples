package com.banmao.advanced_grammar.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/22 下午7:03
 * @description
 */
public class Jdbc01 {

    public static void main(String[] args) throws SQLException {
        Jdbc01 jdbc01 = new Jdbc01();
        Connection conn = jdbc01.getConn();
        String sql = "insert into actor values(null, '刘德华', '男', '1970-01-01', '110')";
        jdbc01.execDmlSql(conn, sql);
    }

    public Connection getConn() throws SQLException {
        // 前置：下载驱动，并加入到运行环境中
        // 1、注册驱动
        Driver driver = new Driver();
        // 2、得到连接
        // jdbc:mysql:  规定好协议
        String url = "jdbc:mysql://localhost:3306/study_db";
        // 将用户名和密码放到properties对象中。
        Properties properties = new Properties();
        properties.setProperty("user", "cao");
        properties.setProperty("password", "12345Aa@");

        Connection connect = driver.connect(url, properties);
        return connect;
    }

    public void execDmlSql(Connection connection, String sql) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            // 如果是dml语句，返回的是影响的行数
            int rows = statement.executeUpdate(sql);
            System.out.println(rows > 0 ? "成功" : "失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void execSelectSql() {

    }
}