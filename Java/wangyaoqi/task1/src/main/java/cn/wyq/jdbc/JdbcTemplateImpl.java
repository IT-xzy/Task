package cn.wyq.jdbc;

import cn.wyq.pojo.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;



public class JdbcTemplateImpl implements StudentDao{
    private ApplicationContext apc=null;
    private JdbcTemplate jdbcTemplate=null;
    {
        apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate=(JdbcTemplate) apc.getBean("jdbcTemplate");
    }

    @Override
    public void insert(Student s) {
        String sName = s.getName();
        int id = s.getId();
        String type = s.getType();
        String school = s.getSchool();
        String pledge = s.getPledge();
        int createTime = s.getCreateTime();
        int updateTime = s.getUpdateTime();
        int siblingId = s.getSiblingId();
        String siblingName = s.getSiblingName();
        String sql = "insert into student values(null,?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql,sName,type,school,pledge,createTime,updateTime,siblingId,siblingName);
    }

    @Override
    public void update(Student s) {
        String name = s.getName();
        int id = s.getId();
        int siblingId = s.getSiblingId();
        String tName = s.getSiblingName();
        String sql = "update student set name=?, sibling_id=?, sibling_name=? where id=?";
        int i = jdbcTemplate.update(sql,name,siblingId,tName,id);
    }

    @Override
    public void delete(int id) {
        String sql= "delete from student where id=?";
        int i = jdbcTemplate.update(sql,id);
    }

    @Override
    public Student get(int id) {
        String sql = "select * from student where id=?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        try {
            Student s = jdbcTemplate.queryForObject(sql, rowMapper, id);
            System.out.println(s);
            return s;
        }catch(EmptyResultDataAccessException e){
            System.out.println("您输入的数据不存在，请确认后再输入！");
            return null;
        }
    }

    @Override
    public List<Student> listname(String name) {
        String sql = "select * from student where name=?";
        List<Student> s = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class), name);
        if(null == s||s.size()==0) {
            System.out.println("您输入的数据不存在，请确认后再输入！");
        }else {
            System.out.println(s);
        }
        return s;
    }

}
