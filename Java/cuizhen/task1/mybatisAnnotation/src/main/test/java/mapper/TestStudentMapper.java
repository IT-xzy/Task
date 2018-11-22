package mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.Student;
import util.MybatisUtil;

import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

public class TestStudentMapper {
    private static Logger logger =Logger.getLogger(String.valueOf(TestStudentMapper.class));


        SqlSessionFactory sqlSessionFactory = MybatisUtil.getFactory();
    SqlSession session = sqlSessionFactory.openSession(true);
    StudentMapper mapper = session.getMapper(StudentMapper.class);


    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("放得开");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(7);
        mapper.insertStudent(student);
        System.out.println("id=" + student.getId());
        logger.info("id=" + student.getId());
        session.close();
    }


    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setId(70);
        student.setName("丰富的");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(12);
        int i = mapper.updateStudent(student);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
        session.close();
    }

    @Test
    public void testDeleteStudent() {
        int i= mapper.deleteStudent(43);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
        session.close();
    }

    @Test
    public void testSelectStudent() {
        Student student = mapper.selectStudent(59);
        session.close();
        System.out.println(student);
        logger.info(""+student);
    }

    @Test
    public void testSelectStudentName() {
        List<Student> students= mapper.selectStudentName("九块");
        session.close();
        logger.info(""+students);
    }

    @Test
    public void testFindAllStudent() {
        List<Student> students = mapper.findAllStudent();
        session.close();
        for (Student student:students) {
            logger.info(""+student);
        }
    }
}
