import com.jnshu.Spring.User;
import com.jnshu.Spring.jdbcTemplate.UserDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*
* 2018-09-30 Spring和jdbcTemplate
* */
public class testJdbcTemplate {
    public static UserDaoImpl userDao=null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        userDao=new UserDaoImpl();
    }
    @AfterClass
    public static void tearDownAfterClass(){
        userDao=null;
    }
    @Test
    public void testFInduById(){


    }
}
