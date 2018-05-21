import com.dao.StudentDao;
import com.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/5 22:04
 * @version: [1.0]
 */
public class TestMybatis {
    /**可以将读取配置文件，创建session工厂抽取成方法*/

    @Test
    public void TestStudentAdd(){
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("解析配置文件失败");
        }
        //判断输入流是否读到数据
        if (inputStream == null){
            System.out.println("xml is null");
        }
        //创建session工厂,获取session
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //如果sqlsessionFactory.opensession(true)参数是布尔值，如果设置为true，就不需要commit提交事务了
        SqlSession session = sqlSessionFactory.openSession();

        Student student = new Student();
        //student.setId(2);
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        student.setStuName("呵呵呵");
        student.setQQ("666666666");
        student.setLessonType(2);
        student.setAdmissionTime(System.currentTimeMillis());
        student.setGraduatedSchool("bbb");
        student.setStuNumber("666");
        student.setDiaryLink("https://666");
        student.setWish("学学学");
        student.setBrotherId(1);
        student.setHeardFrom("知乎");

        /*下面两句代码等同于insert方法，并且我觉得更灵活
        StudentDao studentDao = session.getMapper(StudentDao.class);
        studentDao.add(student);*/

        session.insert("com.dao.StudentDao.add",student);
        System.out.println(student.getId());

        /**切记：增删改操作时，要执行commit操作*/
        session.commit();
        session.close();

        /*
        //在链接关闭以后再执行一次插入
        try{
            session.insert("com.dao.StudentDao.add",student);
        }catch (Exception e){
            e.printStackTrace();
        }
        //org.apache.ibatis.executor.ExecutorException: Executor was closed.
        */
    }



    @Test   /**根据学员主键ID查找报名表信息*/
    public void TestStudentSelect(){
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("解析配置文件失败");
        }
        //判断输入流是否读到数据
        if (inputStream == null){
            System.out.println("xml is null");
        }
        //创建session工厂,获取session
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        /**查找之前去数据看看看有没有这个ID，坑了我大半个小时*/
        Student student = session.selectOne("com.dao.StudentDao.selectById",496);
        System.out.println(student);
        System.out.println(student.getStuName());

        session.commit();
        session.close();
    }
}
