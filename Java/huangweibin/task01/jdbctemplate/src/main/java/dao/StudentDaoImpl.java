package dao;

import mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.Student;

import javax.sql.DataSource;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDateSource(DataSource dataSource) {
        this.dataSource =dataSource;
        this.jdbcTemplate = new JdbcTemplate (dataSource);
    }

    @Override
    public void createTable() {
        String SQL ="CREATE TABLE student_tb1 ("+
                    "id INTEGER(10) NOT NULL AUTO_INCREMENT, "+
                    "age INTEGER,"+
                    "create_at BIGINT,"+
                    "update_at BIGINT,"+
                    "name varchar(20),"+
                    "qq INTEGER(20),"+
                    "ocupation VARCHAR (30),"+
                    "admission_time DATE ,"+
                    "school VARCHAR (50),"+
                    "online_number VARCHAR(20),"+
                    "daily VARCHAR(100),"+
                    "declaration varchar(255),"+
                    "brother varchar(50),"+
                    "where_know varchar(255),"+
                    "insertId BIGINT(20),"+
                    "PRIMARY KEY(id)"+
                    ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        jdbcTemplate.update ( SQL );
        System.out.println ("create tables successfully...");
    }


    public void insert(String name, Integer age) {
        String SQL ="INSERT INTO student_tb1(name,age) Value(?,?)";
        jdbcTemplate.update ( SQL,name,age );
        System.out.println ("insert Record Name = " + name + " Age = " + age );
    }

    public Student getStudent(Integer id) {
        String SQL ="SELECT * FROM student_tb1 WHERE id = ?";
        Student student =jdbcTemplate.queryForObject ( SQL,
                new Object[]{id},new StudentMapper());
        return student;

    }

    @Override
    public List <Student> listStudent() {
            String SQL = "SELECT * from student_tb1";
            List<Student> students = jdbcTemplate.query(SQL,new StudentMapper ());
            return students;
        }


    public void delete(Integer id) {
        String SQL = "DELETE FROM student_tb1 WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    public void update(Integer id, Integer age) {
        String SQL = "UPDATE student_tb1 SET age = ? WHERE id = ?";
        jdbcTemplate.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
        return;


    }
}
