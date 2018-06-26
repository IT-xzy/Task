package action;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.RandomStudent;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//主要测试 Mapperxml配置 MybatisAction

public class MybatisAction {

    static Logger logger = Logger.getLogger(MybatisAction.class.getName());

    private static SqlSessionFactory sqlSessionFactory ;

    private static Reader reader;

//    randomStudent.getStudent() 无id
    private RandomStudent randomStudent = new RandomStudent();

    private Student student;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


    @Test
    public void selectByIdTest(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            Student student = sqlSession.selectOne("selectById",22);

            System.out.print(student.toString());

            sqlSession.commit();

        }catch (Exception e){
            System.out.print("输出错误！");
            e.fillInStackTrace();
        }finally {

            if (sqlSession!=null){

                sqlSession.close();
            }
        }


    }

    @Test
    public void insert(){

        Student student = randomStudent.getStudent();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            logger.info(sqlSession.insert("insertOne",student));
            logger.info("添加数据 id 为 " + student.getId());
//            sqlSession.insert("insertOne",student);

            sqlSession.commit();


        }catch (Exception e){
            logger.debug("添加数据错误!");
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }

    }

    @Test
    public void insertList(){

        List<Student> students = new ArrayList<>();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            for (int i=0;i<10;i++){
                student = randomStudent.getStudent();
                students.add(student);
            }

            logger.info(sqlSession.insert("insertForList",students));

            sqlSession.commit();

        }catch (Exception e){
            logger.debug("批量添加数据错误!");
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }

    }

    @Test
    public void update(){

        student = randomStudent.getStudent();

        int id = 90;

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            student.setId(id);

            logger.info(sqlSession.insert("updateOne",student));

            logger.info(sqlSession.selectOne("selectById",id));

            sqlSession.commit();

        }catch (Exception e){
            logger.debug("修改数据错误!");
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }


    }

    @Test
    public void updateList(){

        List<Student> students = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            for (int i=50; i<55;i++){

              Student student = randomStudent.getStudent();

              student.setId(i);

              students.add(student);
              ids.add(i);
            }

            logger.info(sqlSession.insert("updateForList",students));

            for(int j=0;j<ids.size();j++){
                logger.info(sqlSession.selectOne("selectById",ids.get(j)));
            }

            sqlSession.commit();

        }catch (Exception e){
            logger.debug("批量修改数据错误!");
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }


    }


    @Test
    public void delete(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            logger.info(sqlSession.insert("deleteOne",45));

            sqlSession.commit();

        }catch (Exception e){
            logger.debug("删除数据错误!");
            e.fillInStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }

    }



}
