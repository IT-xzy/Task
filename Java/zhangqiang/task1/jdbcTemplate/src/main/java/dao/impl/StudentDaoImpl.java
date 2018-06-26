package dao.impl;

import dao.StudentDao;
import model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import service.TimeDate;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
*
* jdbcTEmplate DaoImpl实现类
*
*
* */
@Component
//@Scope("prototype")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    private Logger logger = Logger.getLogger(StudentDaoImpl.class.getName());
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    TimeDate timeDate = new TimeDate();

//    查询
    @Override
    public Student selectById(int id) {

        String sql = "SELECT * FROM student where id = ?";

        Student stu = new Student();

        try{
            stu = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
                        @Nullable
                        @Override
                        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                            Student student = new Student();
                            student.setId(resultSet.getInt("id"));
                            student.setName(resultSet.getString("name"));
                            student.setCreate_at(resultSet.getLong("create_at"));
                            student.setUpdate_at(resultSet.getLong("update_at"));
                            student.setQq(resultSet.getLong("qq"));
                            student.setType(resultSet.getInt("type"));
                            student.setStartTime(resultSet.getString("start_time"));
                            student.setSchool(resultSet.getString("school"));
                            student.setStuNum(resultSet.getInt("stu_num"));
                            student.setDailyLink(resultSet.getString("daily_link"));
                            student.setPro(resultSet.getString("pro"));
                            student.setBrother(resultSet.getString("brother"));
                            return student;
                        }
                },id);
        }catch (Exception e){
            System.out.print("查询错误");
            e.fillInStackTrace();
        }
        return stu;
    }


//    查询全部
    @Override
    public List<Student> findAll() {

        String sql = "SELECT * FROM student";

        final List<Student> list = new ArrayList<Student>();
        final Student student = new Student();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setName(resultSet.getString("name"));
                student.setQq(resultSet.getLong("qq"));
                student.setType(resultSet.getInt("type"));
                student.setStartTime(resultSet.getString("start_time"));
                student.setSchool(resultSet.getString("school"));
                student.setStuNum(resultSet.getInt("stu_num"));
                student.setDailyLink(resultSet.getString("daily_link"));
                student.setPro(resultSet.getString("pro"));
                student.setBrother(resultSet.getString("brother"));
                list.add(student);
            }
        });
        return list;
    }

//    根据条件查询全部
    @Override
    public List<Student> findByStudent(Student student){

        StringBuilder sql = new StringBuilder();
        sql.delete(0,sql.length());
        sql.append("SELECT * FROM student WHERE 1=1 ");
        if(student.getName()!=null && !student.getName().equals(""))sql.append("AND name LIKE '%" + student.getName() + "%'");
        if(student.getSchool()!=null && !student.getSchool().equals(""))sql.append("AND school LIKE '%" + student.getSchool() + "%'");
        if(student.getStuNum()!=0)sql.append("AND stu_num = " + student.getStuNum());
        if(student.getQq()!=0)sql.append("AND qq LIKE '%" + student.getQq() + "%'");
        if(student.getType()!=0)sql.append("AND stu_num = '%" + student.getType() + "%'");
        if(student.getStartTime()!=null && !student.getStartTime().equals(""))sql.append("AND start_time LIKE '%" + student.getStartTime() + "%'");
        if(student.getPro()!=null && !student.getPro().equals(""))sql.append("AND pro LIKE '%" + student.getPro() + "%'");
        if(student.getBrother()!=null && !student.getBrother().equals(""))sql.append("AND brother LIKE '%" + student.getBrother() + "%'");

        final List<Student> students = new ArrayList<>();

        jdbcTemplate.query(sql.toString(),new ResultSetExtractor() {
            @Nullable
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while (resultSet.next()){
                    Student stu = new Student();
                    stu.setName(resultSet.getString("name"));
                    stu.setQq(resultSet.getLong("qq"));
                    stu.setType(resultSet.getInt("type"));
                    stu.setStartTime(resultSet.getString("start_time"));
                    stu.setSchool(resultSet.getString("school"));
                    stu.setStuNum(resultSet.getInt("stu_num"));
                    stu.setDailyLink(resultSet.getString("daily_link"));
                    stu.setPro(resultSet.getString("pro"));
                    stu.setBrother(resultSet.getString("brother"));
                    students.add(stu);
                }
                return students;
            }
        });

//        jdbcTemplate.query(sql.toString(), new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                while (resultSet.next()){
//                    Student stu = new Student();
//                    stu.setId(resultSet.getInt("id"));
//                    stu.setName(resultSet.getString("name"));
//                    stu.setQq(resultSet.getLong("qq"));
//                    stu.setType(resultSet.getInt("type"));
//                    stu.setStartTime(resultSet.getString("start_time"));
//                    stu.setSchool(resultSet.getString("school"));
//                    stu.setStuNum(resultSet.getInt("stu_num"));
//                    stu.setDailyLink(resultSet.getString("daily_link"));
//                    stu.setPro(resultSet.getString("pro"));
//                    stu.setBrother(resultSet.getString("brother"));
//                    students.add(stu);
//                }
//            }
//        });
        return students;
    }


//    添加数据
    @Override
    public int insert(final Student student) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        long start = System.currentTimeMillis();
        int ids = 0;

        try {
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement pstmt = connection.prepareStatement(
                            "INSERT INTO student (name,create_at,update_at,qq,type,start_time,school,stu_num,daily_link,pro,brother) values (?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setObject(1, student.getName());
                    pstmt.setObject(2, student.getCreate_at());
                    pstmt.setObject(3, student.getUpdate_at());
                    pstmt.setObject(4, student.getQq());
                    pstmt.setObject(5, student.getType());
                    pstmt.setObject(6, student.getStartTime());
                    pstmt.setObject(7, student.getSchool());
                    pstmt.setObject(8, student.getStuNum());
                    pstmt.setObject(9, student.getDailyLink());
                    pstmt.setObject(10, student.getPro());
                    pstmt.setObject(11, student.getBrother());
                    return pstmt;
                }
            }, keyHolder);

            ids = keyHolder.getKey().intValue();
            long end = System.currentTimeMillis();
            long time = (end-start);
            logger.info("运行时间：" + timeDate.formatDuring(time));

        }catch (Exception e){
            logger.debug("添加信息错误！");
            e.fillInStackTrace();
        }

        return ids;
    }


//    批量添加
    @Override
    public int insertLiset(List<Student> list) {

        int con = 0;
        String sql = "INSERT INTO student (name,create_at,update_at,qq,type,start_time,school,stu_num,daily_link,pro,brother) values ";
        long start = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.delete(0,stringBuilder.length());
        stringBuilder.append(sql);

        Student student = new Student();

        for(int i=0;i<list.size();i++){
            if (i>0)stringBuilder.append(",");
            student = list.get(i);
            stringBuilder.append("('" + student.getName()  + "'," +
                    student.getCreate_at() + "," +
                    student.getUpdate_at() + "," +
                    student.getQq() + "," +
                    student.getType() + ",'" +
                    student.getStartTime() + "','" +
                    student.getSchool() + "'," +
                    student.getStuNum() + ",'" +
                    student.getDailyLink() + "','" +
                    student.getPro() + "','" +
                    student.getBrother() + "')"
            );

        }

        long end = System.currentTimeMillis();
        long time = (end-start);

        try{

            con = jdbcTemplate.update(stringBuilder.toString());

            logger.info("插入" +list.size()+ "条数据运行时间：" + timeDate.formatDuring(time));

        }catch (Exception e){
            logger.debug("添加信息错误！");
            e.fillInStackTrace();
        }

        return con;
    }


//    修改数据
    @Override
    public int update(Student student) {

        String sql = "UPDATE student SET name=?,update_at=?,qq=?,type=?,start_time=?,school=?,stu_num=?,daily_link=?,pro=?,brother=? WHERE id=? ";

        return  jdbcTemplate.update(sql,student.getName(),student.getUpdate_at(),student.getQq(),student.getType(),student.getStartTime(),student.getSchool(),student.getStuNum(),student.getDailyLink(),student.getPro(),student.getBrother(),student.getId());


    }


//    批量修改
    @Override
    public int[] updateList(final List<Student> students) {

        String sql = "UPDATE student SET name=?,update_at=?,qq=?,type=?,start_time=?,school=?,stu_num=?,daily_link=?,pro=?,brother=? WHERE id=? ";
        long start = System.currentTimeMillis();
        int[] updateCount = {};

        try {
            updateCount = jdbcTemplate.batchUpdate(sql,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                            preparedStatement.setString(1,students.get(i).getName());
                            preparedStatement.setLong(2,students.get(i).getUpdate_at());
                            preparedStatement.setLong(3,students.get(i).getQq());
                            preparedStatement.setInt(4,students.get(i).getType());
                            preparedStatement.setString(5,students.get(i).getStartTime());
                            preparedStatement.setString(6,students.get(i).getSchool());
                            preparedStatement.setInt(7,students.get(i).getStuNum());
                            preparedStatement.setString(8,students.get(i).getDailyLink());
                            preparedStatement.setString(9,students.get(i).getPro());
                            preparedStatement.setString(10,students.get(i).getBrother());
                            preparedStatement.setInt(11,students.get(i).getId());
                        }

                        @Override
                        public int getBatchSize() {
                            return students.size();
                        }
                    }
            );
            long end = System.currentTimeMillis();
            long time = (end-start);
            logger.info("修改" +students.size()+ "条数据运行时间：" + timeDate.formatDuring(time));

        }catch (Exception e){
            logger.debug("修改信息错误！");
            e.fillInStackTrace();
        }

        return updateCount;
    }

//    删除数据
    @Override
    public int delect(int id) {

        String sql = "DELETE * FROM student WHERE id=?";

        return jdbcTemplate.update(sql,id);
    }
}
