package pool;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestPoolNotClose {
    private DriverManagerDataSource dataSource;
    private Connection conn;
    private PreparedStatement sql;

    @Before
    public void setDataSource() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("mybatis_spring.xml");
        dataSource = context.getBean(DriverManagerDataSource.class);
    }

    @Test
    public void poolTest() throws Exception {
        Long t1 = System.currentTimeMillis();
        System.out.println("开始循环插入");
        for (int i = 0; i < 1000; i++) {
            conn = dataSource.getConnection();
            sql = conn.prepareStatement("insert into test (name,number) values (?,?)");
            sql.setString(1, "ptt" + i);
            sql.setString(2, "num" + i);
            sql.executeUpdate();
            conn.close();
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("插入结束");
        System.out.println("用时：" + (t2 - t1) + "ms");
    }
}
