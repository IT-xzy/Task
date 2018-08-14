package com.lihoo.test;

import com.lihoo.demo.utils.C3P0Utils;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lihoo
 * @Title: Test101
 * @ProjectName maven_test_4
 * @Description: TODO
 * @date 2018/7/23-15:04
 */


public class Test101 {
    @Test
    public void testSelect02() {
        Connection conn = null;
        DataSource dataSource = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3P0Utils.getConnection();
            String sql="select * from author where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,575656);
            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            C3P0Utils.releaseConnection(conn,pstmt,rs);
        }
    }
}
