package com.banmao.advanced_grammar.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/23 下午8:33
 * @description
 */
public class JdbcUtils {

    public static String name;
    public static String password;
    public static String url;
    public static String driverName;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("/Users/cao/Documents/workspace/java-code-examples" +
                    "/javase/src/main/java/com/banmao/advanced_grammar/jdbc/jdbc.properties"));
            name = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driverName = properties.getProperty("driver");

            // 注册驱动
            Class.forName(driverName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(ResultSet set, Connection conn, PreparedStatement preparedStatement) {
        try {
            if (set != null) {
                set.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}