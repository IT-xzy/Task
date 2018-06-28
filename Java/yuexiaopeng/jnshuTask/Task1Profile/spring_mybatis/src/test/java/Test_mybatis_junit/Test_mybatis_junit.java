package Test_mybatis_junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xiuzhenyuan.bean.Student;
import xiuzhenyuan.dao.StudentDAO;
import java.lang.*;
import java.io.InputStream;
import java.util.List;

public class Test_mybatis_junit
{
    SqlSession sqlSession=null;

    @Before//在测试执行之前执行这个方法，获得sqlSession
    public void Test_before()
    {
            try
            {
                InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
                SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
                sqlSession=sqlSessionFactory.openSession();
            }
            catch (Exception E)
            {E.printStackTrace();}
    }

    @After
    //测试执行技术后执行这个方法，将对数据库的操作提价并关闭数据库；
    public void Test_Close()
    {
            sqlSession.commit();
            sqlSession.close();
    }

    @Test
    //删除study_id的数据；
    public void Tets_doDelete()
    {
        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
        studentDAOImp.doDelete("java-669");
        System.out.println("操作成功");
    }

    @Test
//    插入数据
   public void Tets_doInsert()
    {
        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
        Student student=new Student();
        student.setId(99);
        student.setCreate_at(20180608l);
        student.setUpdate_at(20180608l);
        student.setName("岳飞飞");
        student.setQq(820180608);
        student.setStudy_type("pm工程师");
        student.setStudy_id("java-680");
        student.setJoin_time(20180608l);
        student.setUniversity("大连交通大学");
        student.setDaily_link("http://www.jnshu.com/school/22071/daily");
        student.setSlogen("老大最谁啊");
        student.setMaster("大师兄");
        studentDAOImp.doInsert(student);
        System.out.println("操作成功");
    }
    @Test
    //更新数据，根据study_id更新slogen；
    public void Tets_doUpdate()
    {
        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
        Student student=new Student();
        student.setStudy_id("java-660");
        student.setSlogen("老大最帅");
        studentDAOImp.doUpdate(student);
        System.out.println("操作成功");
    }
    @Test
    //更新数据，根据study_id查询数据；
    public void Tets_doSelectByStudy_id()
    {
        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
        List<Student> student=studentDAOImp.doSelectByStudy_id("java-669");

        System.out.println(student);
        System.out.println("操作成功");

    }
    @Test
    //更新数据，根据study_id查询数据；
    public void Tets_doSelectAll()
    {
        StudentDAO studentDAOImp=sqlSession.getMapper(StudentDAO.class);
        List<Student> student=studentDAOImp.doSelectAll();
        for(Student studentAll: student)
        {System.out.println(studentAll);}
        System.out.println("操作成功");
//        System.out.println(student);//直接打印不会换行；
    }
}
