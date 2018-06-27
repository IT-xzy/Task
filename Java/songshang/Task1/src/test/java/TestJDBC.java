import com.entity.Student;
import com.utils.StudentUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/8 22:39
 * @version: [1.0]
 */
public class TestJDBC {
    private ApplicationContext context;
    private JdbcTemplate jdbcTemplate;
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @Test
    public void TestAddStudent(){
        String sql = " insert into student (create_at, update_at, stu_name, QQ, lesson_type, admission_time, graduated_school, student_number, diary_link, wish, brother_id, hear_from)" +
                "        values (?,?,?,?,?,?,?,?,?,?,?,?)";
        Student student = StudentUtil.newStudent("赵云");
        jdbcTemplate.update(sql,
                student.getCreateTime(),
                student.getUpdateTime(),
                student.getStuName(),
                student.getQQ(),
                student.getLessonType(),
                student.getAdmissionTime(),
                student.getGraduatedSchool(),
                student.getStuNumber(),
                student.getDiaryLink(),
                student.getWish(),
                student.getBrotherId(),
                student.getHeardFrom());

        System.out.println(student.getId());
    }

    @Test
    public void TestInsertStudent(){
        String sql = " insert into student (create_at, update_at, stu_name, QQ, lesson_type, admission_time, graduated_school, student_number, diary_link, wish, brother_id, hear_from)" +
                "        values (?,?,?,?,?,?,?,?,?,?,?,?)";
        Student student = StudentUtil.newStudent("赵云");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                //ps.setInt(1,student.getId());
                ps.setLong(1,student.getCreateTime());
                ps.setLong(2,student.getUpdateTime());
                ps.setString(3,student.getStuName());
                ps.setString(4, student.getQQ());
                ps.setInt(5,student.getLessonType());
                ps.setLong(6,student.getAdmissionTime());
                ps.setString(7,student.getGraduatedSchool());
                ps.setString(8,student.getStuNumber());
                ps.setString(9,student.getDiaryLink());
                ps.setString(10,student.getWish());
                ps.setInt(11,student.getBrotherId());
                ps.setString(12,student.getHeardFrom());

                return ps;
            }
        },keyHolder);

        System.out.println(keyHolder.getKey().intValue());
    }



    @Test
    public void TestDeleteStudent(){
        Student student = new Student();
        student.setId(5);
        int id = student.getId();
        String sql = "delete from student where stu_id = ?";
        jdbcTemplate.update(sql,id);
    }

    /**JdbcTemplate批量操作*/
    @Test
    public void TestUpdateStudent(){
        String sql = "update student set stu_name = ? where stu_id = ?";
        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{"萧峰",1});
        batchArgs.add(new Object[]{"虚竹",2});
        batchArgs.add(new Object[]{"段誉",3});

        jdbcTemplate.batchUpdate(sql,batchArgs);//返回int[]
    }

    /*
    Object queryForObject(String sql, Class requiredType)
    Object queryForObject(String sql, Object[] args, Class requiredType)
    Object queryForObject(String sql, Object[] args, int[] argTypes, Class requiredType)
    参数requiredType表明了相应函数的返回值类型。3个API都被期望返回一个1行1列的数据，
    该行数据就是结果数据(直接为结果)，否则会抛出异常。
    因而，参数requiredType的值必须是一个对应数据库中的表字段对应的Java类型。
    */
    /*
    Object queryForObject(String sql, Object[] args, int[] argTypes, RowMapper rowMapper)
    Object queryForObject(String sql, Object[] args, RowMapper rowMapper)
    Object queryForObject(String sql, RowMapper rowMapper)
    如果你需要将返回值设定为自定义类型，你需要使用这3个API来完成。
    RowMapper接口的功能就是将结果集中的某行转换为一个Object。
     */
    @Test   /**根据学员的主键ID查找学员报名信息*/
    public void TestSelectStudent(){
        String sql = "select * from student where stu_id = ?";

        /**JDK1.8 建议用Lambda表达式替代匿名内部类*/
        jdbcTemplate.queryForObject(sql, new Object[]{1}, (RowMapper<Object>) (rs, i) -> {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setCreateTime(rs.getLong("create_at"));
            student.setUpdateTime(rs.getLong(3));
            student.setStuName(rs.getString(4));
            student.setQQ(rs.getString(5));
            student.setLessonType(rs.getInt("lesson_type"));
            student.setAdmissionTime(rs.getLong(7));
            student.setGraduatedSchool(rs.getString(8));
            student.setStuNumber(rs.getString(9));
            student.setDiaryLink(rs.getString(10));
            student.setWish(rs.getString(11));
            student.setBrotherId(rs.getInt(12));
            student.setHeardFrom(rs.getString(13));

            System.out.println(student.getStuName());
            return student;
        });
    }

    /*
    List queryForList(String sql)
    List queryForList(String sql, Class elementType)
    List queryForList(String sql, Object[] args)
    List queryForList(String sql, Object[] args, Class elementType)
    List queryForList(String sql, Object[] args, int[] argTypes)
    List queryForList(String sql, Object[] args, int[] argTypes, Class elementType)

    elementType是返回值的每一个元素的类型。对于elementType的取值与前面的requiredType是相同的。
    如果不指定的话，返回值将会被设定为一个a list of maps，即返回值中的每个元素都是一个map对象 。
     */

    @Test
    public void TestSelectStudentName(){
        String sql = "select stu_name from student";
        List<String> lists = jdbcTemplate.queryForList(sql,String.class);
        for (String stuName : lists){
            System.out.println(stuName);
        }
    }

    /**根据模糊查询找出学员的id和姓名*/
    @Test
    public void TestSelectStudentInfo(){
        String sql = "select stu_id,stu_name from student where stu_name like concat('%',?,'%')";
        ArrayList<Map<String,Object>> list = (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql,new Object[]{"云"},new int[]{Types.VARCHAR});

        for (Map<String,Object> map : list){
            for (Map.Entry<String,Object> entry : map.entrySet()){
                System.out.println(entry.getKey() + "---" + entry.getValue());
            }
        }
    }

    /*
    Map queryForMap(String sql)
    Map queryForMap(String sql, Object[] args)
    Map queryForMap(String sql, Object[] args, int[] argTypes)

    它们用来将查询结果转换为一个Map对象。这些方法要求查询结果为一个1行的数据，
    然后它们可以将这1行数据按照以相应表字段为key值，查询得到的值为value的方式进行转换。
    事实上，queryForList方法在没有指定elementType的情况下，其返回值中的元素便是根据此得到的。
     */

    @Test
    public void TestForMap(){
        String sql = "select * from student where stu_id = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,new Object[]{1});//这里不写argTypes也能查出来
        for (Map.Entry<String,Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    /*
    JdbcTemplate的query方法是拥有最多重载版本数的方法，同时也是最为灵活的方法。
    从返回值的类型上来看，query方法分为两部分：返回值为Object或List。
    从query方法的执行上来看，query方法采用JDBC Statement以及PreparedStatement两种。
    以Object作为返回值的方法都含有一个ResultSetExtractor对象。
     */
}
