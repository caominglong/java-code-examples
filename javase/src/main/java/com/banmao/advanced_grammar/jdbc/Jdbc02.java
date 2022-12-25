package com.banmao.advanced_grammar.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/22 下午7:03
 * @description
 */
public class Jdbc02 {

    public static void main(String[] args) throws SQLException {

    }

    @Test
    public void conn01() throws SQLException {
        Driver driver = new Driver();
        // 2、得到连接
        // jdbc:mysql:  规定好协议
        String url = "jdbc:mysql://localhost:3306/study_db";
        // 将用户名和密码放到properties对象中。
        Properties properties = new Properties();
        properties.setProperty("user", "cao");
        properties.setProperty("password", "12345Aa@");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void conn02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        // 使用反射
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/study_db";
        // 将用户名和密码放到properties对象中。
        Properties properties = new Properties();
        properties.setProperty("user", "cao");
        properties.setProperty("password", "12345Aa@");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void conn03() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/study_db";
        String user = "cao";
        String password = "12345Aa@";

        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void conn04() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        // Class.forName自动完成注册驱动，简化代码

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/study_db";
        String user = "cao";
        String password = "12345Aa@";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void conn05() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException, IOException {
        // 增加配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/cao/Documents/workspace/java-code-examples/javase/src/main/java/com/banmao/advanced_grammar/jdbc/jdbc.properties"));
        // 获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


}