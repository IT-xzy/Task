package com.ppteng.dao;

import com.ppteng.bean.Student;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO {
    @Override
    public Student findById(long id) throws Exception {
        try {
            String sql = "SELECT * FROM students WHERE id = ?";
            return this.getJdbcTemplate().queryForObject(sql,new StudentRowMapper(),id);
        } catch (EmptyResultDataAccessException e){
            throw new RuntimeException("查询失败，对象不存在！");
        }
    }

    @Override
    public List<Student> findByName(String name) throws Exception {
        String sql = "SELECT * FROM students WHERE name = ?";
        StringBuffer arg = new StringBuffer();
        arg.append("%");
        arg.append(name);
        arg.append("%");
        return this.getJdbcTemplate().query(sql,new StudentRowMapper(),arg.toString());
    }

    @Override
    public Student findByNum(String num) throws Exception {
        try {
            String sql = "SELECT * FROM students WHERE num = ?";
            return this.getJdbcTemplate().queryForObject(sql,new StudentRowMapper(),num);
        } catch (EmptyResultDataAccessException e){
            throw new RuntimeException("查询失败，对象不存在！");
        }
    }

    @Override
    public long insertStudent(Student stu) throws Exception {
        String sql = "INSERT INTO students(name,qq,type,admission_time,school,num,daily,declaration,elder,knew_from,create_at) " +
                "VALUE(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try{
            this.getJdbcTemplate().update(con -> {
                PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,stu.getName());
                ps.setString(2,stu.getQq());
                ps.setString(3,stu.getType());
                ps.setString(4,stu.getAdmissionTime());
                ps.setString(5,stu.getSchool());
                ps.setString(6,stu.getNum());
                ps.setString(7,stu.getDaily());
                ps.setString(8,stu.getDeclaration());
                ps.setString(9,stu.getElder());
                ps.setString(10,stu.getKnewFrom());
                ps.setLong(11,stu.getCreateAt());
                return ps;
            }, keyHolder);
        } catch (DuplicateKeyException e){
            throw new RuntimeException("插入失败！该学号可能已经存在！");
        }
        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean deleteStudent(long id) throws Exception {
        String sql = "DELETE FROM students WHERE id = ?";
        if(this.getJdbcTemplate().update(sql,id) == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateStudent(Student stu) throws Exception {
        ArrayList<Object> properties = new ArrayList<Object>();
        ArrayList<Integer> types = new ArrayList<Integer>();
        StringBuffer sql = new StringBuffer();
        long upDate = stu.getUpdateAt();
        long id = stu.getId();
        if(upDate == 0L || id == 0L) {
            return false;
        } else {
            sql.append("UPDATE students SET update_at = ? ");
            properties.add(upDate);
            types.add(Types.BIGINT);
        }
        String admissionTime = stu.getAdmissionTime();
        String daily = stu.getDaily();
        String declaration = stu.getDeclaration();
        String elder = stu.getElder();
        String knewFrom = stu.getKnewFrom();
        String name = stu.getName();
        String num = stu.getNum();
        String qq = stu.getQq();
        String school = stu.getSchool();
        String type = stu.getType();
        if(admissionTime!=null&&admissionTime!="") {
            sql.append(",admission_time = ? ");
            properties.add(admissionTime);
            types.add(Types.VARCHAR);
        }
        if(daily!=null&&daily!=""){
            sql.append(",daily = ? ");
            properties.add(daily);
            types.add(Types.VARCHAR);
        }
        if(declaration!=null&&declaration!="") {
            sql.append(",declaration = ? ");
            properties.add(declaration);
            types.add(Types.VARCHAR);
        }
        if(elder!=null&&elder!="") {
            sql.append(",elder = ? ");
            properties.add(elder);
            types.add(Types.VARCHAR);
        }
        if(knewFrom!=null&&knewFrom!="") {
            sql.append(",knew_from = ? ");
            properties.add(knewFrom);
            types.add(Types.VARCHAR);
        }
        if(name!=null&&name!="") {
            sql.append(",name = ? ");
            properties.add(name);
            types.add(Types.VARCHAR);
        }
        if(num!=null&&num!="") {
            sql.append(",num = ? ");
            properties.add(num);
            types.add(Types.VARCHAR);
        }
        if(qq!=null&&qq!="") {
            sql.append(",QQ = ? ");
            properties.add(qq);
            types.add(Types.VARCHAR);
        }
        if(school!=null&&school!=""){
            sql.append(",school = ? ");
            properties.add(school);
            types.add(Types.VARCHAR);
        }
        if(type!=null&&type!="") {
            sql.append(",type = ? ");
            properties.add(type);
            types.add(Types.VARCHAR);
        }
        sql.append("WHERE id = ?");
        properties.add(id);
        types.add(Types.BIGINT);
        Object[] args = properties.toArray();
        Integer[] argIntegerTypes = new Integer[types.size()];
        argIntegerTypes = types.toArray(argIntegerTypes);
        int[] argTypes = ArrayUtils.toPrimitive(argIntegerTypes);
        if(this.getJdbcTemplate().update(sql.toString(),args,argTypes)!=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void truncateTable() throws Exception {
        String sql = "truncate table students";
        this.getJdbcTemplate().execute(sql);
    }
    class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setAdmissionTime(rs.getString("admission_time"));
            student.setDaily(rs.getString("daily"));
            student.setDeclaration(rs.getString("declaration"));
            student.setElder(rs.getString("elder"));
            student.setId(rs.getLong("ID"));
            student.setName(rs.getString("name"));
            student.setKnewFrom(rs.getString("knew_from"));
            student.setNum(rs.getString("num"));
            student.setQq(rs.getString("QQ"));
            student.setSchool(rs.getString("school"));
            student.setType(rs.getString("type"));
            return student;
        }
    }
}
