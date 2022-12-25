package com.banmao.advanced_grammar.jdbc.batch_;

import com.banmao.advanced_grammar.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/23 下午9:29
 * @description 演示java的批处理
 */
public class Batch_ {

    @Test
    public void noBatch() throws SQLException {
        long start = System.currentTimeMillis();
        Connection conn = JdbcUtils.getConn();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式，耗时：" + ((end - start) / 1000)+ "秒");
        JdbcUtils.close(null, conn, preparedStatement);
    }

    @Test
    public void hasBatch() throws SQLException {
        long start = System.currentTimeMillis();
        Connection conn = JdbcUtils.getConn();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            // 将sql语句加入到批处理中
            preparedStatement.addBatch();
            // 当有1000条数据时，再执行
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                // 清空
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理的方式，耗时：" + (end - start));
        JdbcUtils.close(null, conn, preparedStatement);
    }

//    public <T> List<T> queryMulti(String sql) {
//        T t = new T();
//    }
}