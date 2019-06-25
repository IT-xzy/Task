package cn.wp.service;

import cn.wp.dao.StudentDao;
import cn.wp.po.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*  使用JDBCTemplate实现增删改查的具体实现
    将模板交给spring来管理，StudentDao要使用模板的话，只需要用spring容器
    将模板注入即可*/
public class StudentDaoImpl implements StudentDao {

    // 若未继承JdbcDaoSupport则声明一个JdbcTemplate变量jTemplate来注入
    private JdbcTemplate jTemplate;

    //插入数据方法
    public void add(Student student) throws SQLException {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jTemplate.update(sql, student.getID(), student.getName(), student.getQQ(), student.getType(),
                student.getEstimatedtime(), student.getSchool(), student.getManner(),
                student.getNumber(), student.getDaily(),
                student.getWish(), student.getCounselor(), student.getSource(),
                student.getCreate_at(), student.getUpdate_at());
    }

    //更改数据方法
    public void update(Student student) throws SQLException {
        String sql = "update student set name=?,qq=?,type=?,School=?," +
                "Manner=?,Wish=?,Counselor=?,Source=? where ID=?";
        jTemplate.update(sql, student.getName(), student.getQQ(), student.getType(),
                student.getSchool(), student.getManner(), student.getWish(),
                student.getCounselor(), student.getSource(), student.getID());
    }

    //删除数据方法
    @Override
    public void delete(int ID) throws SQLException {
        String sql = "delete from student where id=?";
        jTemplate.update(sql, ID);
    }

    //    查询返回单个值
    @Override
    public Student findById(int ID) {
        String sql = "select * from student where id=?";

        return jTemplate.queryForObject(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                //创建一个对象来提取结果集
                Student s = new Student();
                //从结果集中取出id的值
                s.setID(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setQQ(rs.getInt("QQ"));
                s.setType(rs.getString("Type"));
                s.setEstimatedtime(rs.getInt("Estimatedtime")) ;
                s.setSchool(rs.getString("School"));
                s.setManner(rs.getString("Manner")) ;
                s.setNumber(rs.getInt("Number")) ;
                s.setDaily(rs.getString("Daily")) ;
                s.setWish(rs.getString("Wish")) ;
                s.setCounselor(rs.getString("Counselor"));
                s.setSource(rs.getString("Source"));
                s.setCreate_at(rs.getInt("create_at"));
                s.setUpdate_at(rs.getInt("update_at"));
                return s;
            }
        }, ID);
    }

    //查询返回值为单个对象
    public int findtotalCount() {
        String sql = "select count(*) from student";

        Integer count = jTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //查询返回对象集合
    public List<Student> findAll() {
        String sql = "select * from student";

        List<Student> list = jTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                //创建一个对象来提取结果集
                Student s = new Student();
                //从结果集中取出id的值
                s.setID(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setQQ(rs.getInt("QQ"));
                s.setType(rs.getString("Type"));
                s.setEstimatedtime(rs.getInt("Estimatedtime")) ;
                s.setSchool(rs.getString("School"));
                s.setManner(rs.getString("Manner")) ;
                s.setNumber(rs.getInt("Number")) ;
                s.setDaily(rs.getString("Daily")) ;
                s.setWish(rs.getString("Wish")) ;
                s.setCounselor(rs.getString("Counselor"));
                s.setSource(rs.getString("Source"));
                s.setCreate_at(rs.getInt("create_at"));
                s.setUpdate_at(rs.getInt("update_at"));
                return s;
            }
        });
        return list;
    }

    //    若未继承JdbcDaoSupport则声明一个JdbcTemplate变量jt来注入

    public void setjTemplate(JdbcTemplate jTemplate) {
        this.jTemplate = jTemplate;
    }
}
