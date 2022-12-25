package com.banmao.advanced_grammar.jdbc.transation_;

import com.banmao.advanced_grammar.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/23 下午8:53
 * @description jdbc中使用事务
 */
public class Transation01 {

    @Test
    public void noTransation() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.得到连接
            conn = JdbcUtils.getConn();
            // 2.组织sql
            String sql = "update account set balance = balance - 100 where id = 1";
            String sql2 = "update account set balance = balance + 100 where id = 2";
            // 3.执行sql
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();

            int i = 1 / 0;

            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, conn, preparedStatement);
        }
    }

    @Test
    public void hasTransation() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.得到连接
            conn = JdbcUtils.getConn();
            // 2.组织sql
            String sql = "update account set balance = balance - 100 where id = 1";
            String sql2 = "update account set balance = balance + 100 where id = 2";
            // 3.执行sql
            conn.setAutoCommit(false); // 相当于开启事务
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();

            int i = 1 / 0;

            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            conn.commit(); // 提交事务
        } catch (SQLException e) {
            // 默认回滚到事务开始的地方
            conn.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, conn, preparedStatement);
        }
    }
}