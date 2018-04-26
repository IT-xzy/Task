import com.longhang.dbcpTools.JdbcUtils_dbcp;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbcpDataSourceTest {
    private static Logger logger = Logger.getLogger(DbcpDataSourceTest.class);
    @Test
    public void insert() {
        //SQL 的语句insert into students (id,name,qq,wish,create_at) values(?,?,?,?,?);
        String sql = "insert into student(id,name,qq,wish,create_at) values(?,?,?,?,?)";
        Long startTime = System.currentTimeMillis();
        StringBuffer stu=new StringBuffer();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        for (long x = 1; x <100; x++) {
            Student s = new Student(Long.valueOf(x), "张三", "244558", "修仙", 2018L);
            try {
                conn = JdbcUtils_dbcp.getConnetion();
                st = conn.prepareStatement(sql);
                st.setLong(1, s.getId());
                st.setString(2, s.getName());
                st.setString(3, s.getQq());
                st.setString(4, s.getWish());
                st.setLong(5, s.getCreate_at());
                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                }
            JdbcUtils_dbcp.release(conn, st, rs);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("OK,用时：" + (endTime - startTime));
    }
    @Test
    public void insert1() {
        //SQL 的语句insert into students (id,name,qq,wish,create_at) values(?,?,?,?,?);
        String sql1= "insert into student(id,name,qq,wish,create_at) values";
        Long startTime = System.currentTimeMillis();
        StringBuffer stf = new StringBuffer();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils_dbcp.getConnetion();
            conn.setAutoCommit(false);
            for (int x = 1; x <=30; x++) {
                for (int y = 1; y <=1000000; y++) {

                    stf.append("(" + Long.valueOf((x-1)*1000000+y) + ",'张三'," + "244558," + "'修仙'," + 2018L + "),");
                }
                //conn = JdbcUtils_dbcp.getConnetion();
                String sql = sql1 + stf.substring(0, stf.length() - 1);
                //logger.info(sql);
                st = conn.prepareStatement("");
                //conn.setAutoCommit(false);
                st.addBatch(sql);
                st.executeBatch();
                conn.commit();
                stf=new StringBuffer();
            }
            } catch(SQLException e){
                e.printStackTrace();
            }

        JdbcUtils_dbcp.release(conn, st, rs);

        Long endTime = System.currentTimeMillis();
        logger.info("OK,用时：" + (endTime - startTime));
    }
    @Test
    public void insert2() {
        //SQL 的语句insert into students (id,name,qq,wish,create_at) values(?,?,?,?,?);
        String sql1= "insert into student(id,name,qq,wish,create_at) values";
        Long startTime = System.currentTimeMillis();
        StringBuffer stf = new StringBuffer();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils_dbcp.getConnetion();
            conn.setAutoCommit(false);

                for (int y = 1; y <=1000000; y++) {

                    stf.append("(" + Long.valueOf(y) + ",'张三'," + "244558," + "'修仙'," + 2018L + "),");
                }
                String sql = sql1 + stf.substring(0, stf.length() - 1);
                st = conn.prepareStatement("");
                st.addBatch(sql);
                st.executeBatch();
                conn.commit();
                //stf=new StringBuffer();

        } catch(SQLException e){
            e.printStackTrace();
        }

        JdbcUtils_dbcp.release(conn, st, rs);

        Long endTime = System.currentTimeMillis();
        logger.info("OK,用时：" + (endTime - startTime));
    }
}


