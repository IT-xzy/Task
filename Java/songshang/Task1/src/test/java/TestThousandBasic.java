import com.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:    普通MaBatis插入1000条记录测试，由于druid连接池已经配置，普通测试就不依赖spring了
 * @ClassName:      向user表中插入1000条数据，总共执行了1245毫秒
 * @author: fml<duanweikai>
 * @date: 2018/3/6 19:39
 * @version: [1.0]
 */
public class TestThousandBasic {
    private static Logger logger = Logger.getLogger(TestThousandBasic.class);

    @Test
    public void TestUserAdd(){
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

        Student student = new Student();
        //student.setId(2);
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        student.setStuName("bbb");
        student.setQQ("666666666");
        student.setLessonType(2);
        student.setAdmissionTime(System.currentTimeMillis());
        student.setGraduatedSchool("bbb");
        student.setStuNumber("666");
        student.setDiaryLink("https://666");
        student.setWish("学学学");
        student.setBrotherId(1);
        student.setHeardFrom("知乎");

        long a = System.currentTimeMillis();

        for (int i = 0;i < 1000;i++){
            session.insert("add",student);
        }
        session.commit();
        session.close();

        long b = System.currentTimeMillis();
        a = b - a;//总共执行了1051毫秒
        System.out.println("总共执行了" + a + "毫秒");
    }
}
