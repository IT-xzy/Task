package action;

import dao.mapper.StudentMapper;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.RandomStudent;

import java.util.List;
import java.util.Scanner;

/*
*
* 本来是测试类，后改为使用MainAction调用
* 
*
**/

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmybatis.xml"})
public class SpringMybatisAction {

        static Logger logger = Logger.getLogger(SpringMybatisAction.class.getName());

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmybatis.xml");
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");

//        @Autowired
//        @Qualifier("studentMapper")
//        private StudentMapper studentMapper;

//        public void setStudentMapper(StudentMapper studentMapper) {
//            this.studentMapper = studentMapper;
//        }

    @Test
        public void selectTest(){

            selectOne(23);

        }

//        查询
        public Student selectOne(int id){

            Student student = studentMapper.selectById(id);

            return student;
        }

//        根据条件查询
        public List<Student> findByStudent(Student student){

            List<Student> students = studentMapper.findByStudent(student);

            return students;
        }

//        添加
        public int insertOne(Student student){

            studentMapper.insertOne(student);

            logger.info("返回id:"+student.getId());

            return student.getId();

        }

//        批量添加
        public int insertForList(List<Student> students){

            int scu = studentMapper.insertForList(students);

            if(scu > 0 && scu==students.size()){
                logger.info("\n 成功添加" + scu + "条数据,id为:");

                for(int i=0;i<students.size();i++){
                    System.out.print(" " + students.get(i).getId() + " ");
                }

            }else {
                logger.info("添加数据失败!");
            }
            return scu;
        }

//        修改
        public int updateOne(Student student){

            logger.info("\n 修改前数据: "+studentMapper.selectById(student.getId()));

            int scu = studentMapper.updateOne(student);

            if(scu!=0){
                logger.info("True！成功修改 " + scu + "条数据");
                logger.info("\n 修改后数据: "+studentMapper.selectById(student.getId()));
            }else {
                logger.info("修改失败！");
            }

            return scu;

        }

//        批量修改
        public int updateForList(List<Student> students){

            return studentMapper.updateForList(students);

        }

//        删除
        public int deleteOne(int id){

            int scu = studentMapper.deleteOne(id);

            if(scu==1){
                logger.info("True！成功删除 " + scu + "条数据");
            }else {
                logger.info("False!删除失败！");
            }

            return scu;
        }

//        批量删除
        public int delectForlist(List ids ){

            return studentMapper.deleteForList(ids);
        }


//        获取信息查询姓名
        public void chaxun(){

            Student student = new Student();

            Scanner sc = new Scanner(System.in);
            RandomStudent rStudent = new RandomStudent();
            System.out.println("请输入要查的姓名：");
            String lin = sc.nextLine();
            student.setName(lin);
            List<Student> list = findByStudent(student);
            if(list.size()>0){
                for(Student stu:list ) {
                    System.out.print("\n" +
                            "id :" + stu.getId() + "\n" +
                            "姓名 :" + stu.getName() + "\n" +
                            "QQ :" + stu.getQq() + "\n" +
                            "修真类型 :" + rStudent.getTypeString(stu.getType()) + "\n" +
                            "开始时间 :" + stu.getStartTime()+ "\n" +
                            "毕业院校 :" + stu.getSchool() + "\n" +
                            "线上学号 :" + stu.getStuNum() + "\n" +
                            "日报链接 :" + stu.getDailyLink() + "\n" +
                            "立愿 :" + stu.getPro()  + "\n" +
                            "师兄 :" + stu.getBrother() + "\n");
                }
            }else {
                System.out.print("没有找到！重新查找请扣1，结束请扣其它任意字:");
                String str = sc.nextLine();
                if (str.equals("1")){
                    chaxun();
                }else {
                    System.out.print("略略略，再见！");
                }
            }

        }


}
