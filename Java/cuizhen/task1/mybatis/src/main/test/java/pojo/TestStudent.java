package pojo;

import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class TestStudent {
    String resource = "mybatis-config.xml";
    // MyBatis配置文件
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // 创建会话工厂，传入MyBatis配置文件的信息

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 通过工厂得到SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    private static Logger logger = Logger.getLogger(String.valueOf(TestStudent.class));

    public TestStudent() throws IOException {
    }
    // 要添加到数据库中的作为参数的员工对象
//    public TestStudent() throws IOException {
//    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("九块九");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(77);
        session.insert("addStudent", student);
        logger.info("id=" + student.getId());
        session.commit();
        session.close();
    }


    @Test
    public void testUpdateStudent() {
        Student student =session.selectOne("selectStudent", 7);
        try{
        student.setName("九块");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(77);
        }catch (NullPointerException e){
            System.out.println("没有此id");
        }
        int i = session.update("updateStudent", student);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
        session.commit();
        session.close();
    }

    @Test
    public void deleteStudent() {
        Student student = new Student();
        student.setId(5);
        int i = session.delete("deleteStudent", student);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
        session.commit();
        session.close();
    }

    @Test
    public void selectStudent() {
        Student student = session.selectOne("selectStudent", 70);
        try {
            logger.info("" + student.toString());
        }catch (NullPointerException e){
            System.out.println("没有此id");
        }
        session.commit();
        session.close();
    }

    @Test
    public void selectStudentName() {
        List<Student> students= session.selectList("selectStudentName","九块九");
        for(Student student:students)
        logger.info("" + student);
        session.commit();
        session.close();
    }

    @Test
    public void findAllStudent() {
        List<Student> students = session.selectList("findAll");
        for (Student student:students) {
            logger.info("" + student);
        }
        session.commit();
        session.close();


    }
}








