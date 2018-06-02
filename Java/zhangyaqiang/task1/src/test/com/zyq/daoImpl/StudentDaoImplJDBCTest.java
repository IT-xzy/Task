package com.zyq.daoImpl;


import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import java.util.List;

/** 
* ApplicationDaoImplByJDBC Tester. 
* 
* @author <zyq>
* @since <pre>五月 23, 2018</pre> 
* @version 1.0 
*/ 
public class StudentDaoImplJDBCTest {
    private static Logger logger = LogManager.getLogger(MybatisTest.class);
    private StudentDao sdiJDBC = new StudentDaoImplJDBC();
    private Student student = new Student();

    @After
    public void endMethod(){
        logger.info("测试日志输出");
    }
    /**
    *
    * Method: insert(Application application)
    *
    */
    @Test
    public void testInsert()  {
    //TODO: Test goes here...
        student.setName("王庸之");
        student.setQq(861684014);
        student.setProfession("JAVA工程师");
        student.setUniversity("南京航空航天大学机电学院");
        student.setNumber(3834);
        student.setDaily("http://www.jnshu.com/school/21289/daily");
        student.setSenior("宋尚");
        student.setFrom("知乎");
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        Long id = sdiJDBC.insert(student);
        System.out.println("您插入的数据ID为："+id+",请牢记。");
    }

    /**
    *
    * Method: delectByID(Long id)
    *
    */
    @Test
    public void testDelectById()  {
    //TODO: Test goes here...
//        输入要删除行的ID
        student.setId(77L);
        boolean flag = sdiJDBC.deleteById(student);
        if (flag == false){
            System.out.println("删除失败，没有此行。");
        }else {
            System.out.println("删除成功");
        }
    }

    /**
    *
    * Method: update(String name, Long updateTime)
    *
    */
    @Test
    public void testUpdate()  {
    //TODO: Test goes here...
//        要更新时间的学生姓名
        student.setName("王庸之");
//        修改更新时间
        student.setUpdateTime(System.currentTimeMillis());
        boolean flag = sdiJDBC.update(student);
        if (flag == false){
            System.out.println("更新失败，没有此行。");
        }else {
            System.out.println("更新成功");
        }
    }

    /**
    *
    * Method: selectById(String id)
    *
    */
    @Test
    public void testSelectById() {
    //TODO: Test goes here...
        Student student = sdiJDBC.selectById(1L);
        if (student.getId()==null){
            System.out.println("没有查询到你想要的结果，请确认是否输入有误。");
        }else {
            System.out.println(student);
        }
    }

    /**
    *
    * Method: selectByNameAndNum(String name, Integer number)
    *
    */
    @Test
    public void testSelectByNameAndNum(){
    //TODO: Test goes here...
        List<Student> list = sdiJDBC.selectByNameAndNum("王庸之",3834);
        if (list.size()!=0){
            for (Student student:list) {
                System.out.println(student);
            }
        }else{
            System.out.println("根据您输入的条件，数据表中查无此人。");
        }
    }
}
