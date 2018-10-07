import com.jnshu.jdbc.JdbcUntils;
import org.junit.Test;
import java.sql.*;

/*
* 2018-09-30批量插入
* 2018-10-05SpringAOP
* */
public class testJdbcBulkInsert {
    /*@Test
    public void testbatch() {
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = JdbcUntils.getConnecttion();
            String sql1 = "insert into demo(id,name,email) values(10,'aaa','cc')";
            String sql2 = "insert into demo(id,name,email) values(11,'bbb','vv')";
            String sql3 = "insert into demo(id,name,email) values(12,'ccc','bb')";
            String sql4 = "delete from demo where id=1";
            st = conn.createStatement();
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.addBatch(sql3);
            st.addBatch(sql4); //将四条sql语句加入Batch

            st.executeBatch(); //然后依次执行这四条sql语句
            st.clearBatch();//执行完后清除batch
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @Test//大量插入
    public void testBatch2(){
        Connection conn;
        PreparedStatement st;
        ResultSet rs;
        try {
            conn=JdbcUntils.getConnecttion();
            conn.setAutoCommit(false);
            String sql = "insert into demo values (?,?,?)";
            st = conn.prepareStatement(sql);

            for (int i = 300; i < 100000; i++) {
                st.setInt(1,i);
                st.setString(2,"aa"+i);
                st.setString(3,"qq@"+i);
                st.executeUpdate();
            }
            st.executeBatch();
            st.clearBatch();
            conn.commit();
            st.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    @Test
    /*
    创建于2018-09-30批量插入
    使用addBatch批量插入*/
    public void testAddBatch() {
        Connection conn;
        PreparedStatement st;
        ResultSet rs;

        try {
            long start = System.currentTimeMillis();

            conn = JdbcUntils.getConnecttion();
            conn.setAutoCommit(false);
            String sql = "insert into cus values(?,?,?,?)";
            String sql1="insert into demo values (?,?,?)";
            st=conn.prepareStatement(sql1);
            for (int i = 12; i < 100000; i++) {
                st.setInt(1, i);
                st.setString(2, "bb" + i);
                st.setInt(3,i);
                st.setString(4,"cc"+i);
                st.addBatch();
                /*每1000条向数据库中添加一次*/
                if (i % 1000 == 0) {
                    st.executeBatch();
                    st.clearBatch();
                }
            }
            int[] result = st.executeBatch();
            conn.commit();
            System.out.println(result.length);
            /*防止还剩的零头数据*/
            st.executeBatch();
            st.clearBatch();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

