import org.springframework.jdbc.core.JdbcTemplate;

public class DAOImpl implements DAO {
    JdbcTemplate jdbcTemplate=null;
    //重载构造方法，供业务层传入JdbcTemplate.
    public DAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    //实现DAO接口添加记录的方法
    public void AddStudent(String name,int age) throws Exception {
        //使用业务层传入的JdbcTemplate操作数据库
        String sql="insert into student(name,age)values(?,?)";
        int rows=jdbcTemplate.update(sql,name,age);
        System.out.println(rows);
    }
}
