package test_mybatis_main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import xiuzhenyuan.bean.Student;
import xiuzhenyuan.dao.StudentDAO;

import java.io.InputStream;

public class test_mybatis_main {
    public static void main(String[] args) {
            //    调用日志文件
             Logger logger = Logger.getLogger(test_mybatis_main.class);
            SqlSessionFactory sessionFactory = null;
            try {
                InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            } catch (Exception E) {
                E.printStackTrace();
            }
            logger.info("开始操作--请稍后");
            System.out.println("结果如下，请查看");
            SqlSession sqlSession = sessionFactory.openSession();

        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
            long startTime=System.currentTimeMillis();//获取开始时间

//            插入的函数段
            Student student=new Student();
            student.setId(99);
            student.setCreate_at(20180608l);
            student.setUpdate_at(20180608l);
            student.setName("岳飞飞");
            student.setQq(820180608);
            student.setStudy_type("pm工程师");
            student.setStudy_id("java-690");
            student.setJoin_time(20180608l);
            student.setUniversity("大连交通大学");
            student.setDaily_link("http://www.jnshu.com/school/22071/daily");
            student.setSlogen("仰望天空。。");
            student.setMaster("大师兄");

            for(int i=0;i<1000;i++)
            {
            for(int j=0;j<10;j++)
            {
                studentDAOImp.doInsert(student);
            }
            }

/*//        根据study_id查询
        List<Student> stu = studentDAOImp.doSelectByStudy_id("java-698");
        for (Student stuId : stu)
        {
            System.out.println(stuId);
        }*/

/*//        更改内容
        Student student=new Student();
        student.setSlogen("星星与大海");
        student.setStudy_id("java-698");
        studentDAOImp.doUpdate(student);*/
/*//        删除内容
        studentDAOImp.doDelete("java-698");*/

        sqlSession.commit();
            sqlSession.close();

            long endTime=System.currentTimeMillis(); //获取结束时间

            logger.info("程序运行时间： "+(endTime-startTime)+"ms");
            logger.info("结束操作--谢谢参与");

    }
}