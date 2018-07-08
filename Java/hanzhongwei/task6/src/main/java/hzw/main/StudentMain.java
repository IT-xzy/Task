package hzw.main;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;


/**
 * ApplicationContext生成工厂对象。加载bean配置文件
 * 利用框架提供的 ClassPathXmlApplicationContext API 去生成工厂 bean。
 * ClassPathXmlApplicationContext 负责生成和初始化所有的对象
 */
public class StudentMain {
    private static Logger logger = Logger.getLogger("StudentMain.class");

    private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    //getBean() 方法得到所需要的 bean
    private static StudentMapper studentMapper = (StudentMapper) ac.getBean("studentMapper");

    //添加
    private static Long insertStudent(){
        Student student = new Student();
        student.setsName("宣仪");
        student.setQQ(2144324);
        student.setsType("练习生");
        student.setsTime("2018年2月25日");
        student.setsSchool("天美");
        student.setsNumber("UI-313");
        student.setsDaily("日报");
        student.setsWish("闭门修仙，变小仙女");
        student.setsCoach("常雷雷");
        student.setsWhence("知乎");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        Integer id = studentMapper.insertStudent(student);
        logger.info(""+id);
        logger.info(""+student.getsId());
        return student.getsId();
    }

    //删除
    private static Integer deleteStudent(){
        Integer id = 3;
        Integer a = studentMapper.deleteStudent(id);
        logger.info(""+a);
        return a;
    }

    //更新
    private static Integer updateStudent(){
        Student student =new Student();
        student.setsId(Long.valueOf(4));
        student.setsName("孟美岐");
        student.setUpdate_at(System.currentTimeMillis());
        Integer a = studentMapper.updateStudent(student);
        logger.info(""+a);
        return a;
    }

    //查询
    private static Student findIdStundet(){
        Integer id = 4;
        Student student = studentMapper.findIdStudent(id);
        logger.info(student.toString());
        return student;
    }

    private static List<Student> findListStudent(){
        List<Student> list = studentMapper.findListStudent();
        for (Student s:list){
            logger.info(s.toString());
        }
        return list;
    }

    private static List<Student> findNameStudent(){
        List<Student> list = studentMapper.findNameStudent("宣仪");
        for (Student s:list){
            logger.info(s.toString());
        }
        return list;
    }

    public static void main(String[] args){
        //Long id = insertStudent();
        //System.out.println("返回的ID是"+id);
        findListStudent();
    }
}
