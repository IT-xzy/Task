package com.batchInsertion;

import com.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchInsert {
    public void insert() {
        Long begin = System.currentTimeMillis();
        String preparedSql = "insert into tb_test (name,number,create_at,update_at) values ";
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Connection conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("");
            for (int i = 0; i < 100; i++) {
                for (int j = 1; j <= 10000; j++) {
                    stringBuffer.append("(\"st" + (i * 10000 + j) + "\", \"num" + (i * 10000 + j) + "\","+begin+","+begin+"),");
                }
                //减1是为了去掉最后一个()后面的逗号
                String sql = preparedSql + stringBuffer.substring(0, stringBuffer.length() - 1);
                ps.addBatch(sql);
                ps.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                stringBuffer = new StringBuffer();
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - begin) + "ms");
    }

    public static void main(String[] args) {
        BatchInsert insertTest = new BatchInsert();
        insertTest.insert();
    }
}
