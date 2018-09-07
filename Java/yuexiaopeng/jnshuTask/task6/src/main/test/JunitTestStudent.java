import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class JunitTestStudent
{
    static Logger logger=Logger.getLogger(JunitTestStudent.class);

    @Autowired
    private StudentService studentService;

    @Test
    public void insertStudentTest()
    {
        Student student=new Student();
        student.setId(666);
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");

        student.setStudyId("java-004");
        student.setJoinTime(20180608l);
        student.setUniversity("葡vfvfvfv院");
        student.setDailyLink("http://www.jnshu.com/school/22071/daily");
        student.setSlogen("fvfeeeeeefvfvf");
        student.setMaster("嗨，大师兄");
        studentService.insertStudent(student);
        logger.info("插入一条数据记录成功");
    }

    @Test
    public void deleteStudentTest()
    {
        Student student=new Student();
        String studyId="java-685";
        student.setStudyId(studyId);
        studentService.deleteStudent(student);
        logger.info("删除studyId为:"+studyId+"  数据记录成功");
    }

    @Test
    public void updateStudentTest()
    {
        Student student=new Student();

        student.setStudyId("java-009");
        student.setSlogen("仰望苍穹");
        student.setMaster("主席");
        student.setDailyLink("wwww.baidu.com");
        studentService.updateStudent(student);
        logger.info("修改成功，修改后的student为 ： "+student);
    }
    @Test
    public void selectStudent()
    {
        Student student=new Student();
        String studyId="java-009";
        student.setStudyId(studyId);
        Student student1=studentService.selectStudent(student);
        Map<String,Object> map=new HashMap<>();
        map.put(student.getStudyId(),student);
        logger.info(map);
        logger.info("查询成功，数据为"+student1);
    }
    @Test
    public void selectAllTest()
    {
        PageHelper.startPage(1,2);
        List<Student> stu=studentService.selectAllStudent();
        for(Student stu1:stu)
        {
            logger.info(stu1);
        }
        Long i=new PageInfo(stu).getTotal();
        logger.info(i);
        List<Student> stu2=studentService.selectAllStudent();
        Map<String,Object> map=new HashMap<>();
        for(Student stu1:stu2)
        {
            map.put(stu1.getStudyId(),stu1);

        }
        logger.info(map);
    }
    @Test
    public void selectAllTestMap()
    {
//        PageHelper.startPage(1,2);
        Map<String,Object> stu=studentService.selectAllStudentMap();
        for (Map.Entry<String,Object> entry : stu.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
    @Test
    public void selectAllPageTestList()
    {

//        使用list进行分页查询
        List<Student> studentList=studentService.selectAllStudent();
        List listVector=new Vector();
        for(int i=0;i<studentList.size();i++)
        {
            System.out.println(studentList.get(i).getStudyId());
        }
//        int pageNum=1;int pageCount=3;
//        int iStart=pageNum*pageCount-3;
//        int iEnd=iStart+pageCount;
//        if(iEnd<studentList.size())
//        {
//            for(int i=iStart;i<iEnd;i++)
//            {
//                System.out.println(studentList.get(i));
//            }
//        }
//        else
//        {
//             for(int i=iStart;i<studentList.size();i++)
//             {
//                System.out.println(studentList.get(i));
//             }
//        }
    }
    @Test
    public void studentPageTestList()
    {

        //使用list进行分页查询
        Map<String,Object> studentMap = studentService.selectAllStudentMap();
        List<Student> studentList=studentService.selectAllStudent();
        Vector listVector = new Vector();
        for(int j=0;j<studentList.size();j++)
        {
            listVector.add(studentList.get(j).getStudyId());
        }
        for(int i=0;i<listVector.size();i++)
        {
            System.out.println(listVector.get(i));
        }
    }
    @Test
    public void Test111()
    {
        List<Student> stu=studentService.selectAllStudent();
        //根据条件进行分页的list
        List<Student>  studentList=new Vector<>();

        Integer pageNum=3;Integer pageSize=3;
        if(pageNum!=null||pageSize!=null)
        {
            int start = pageNum * pageSize - pageSize;
            int end =start + pageSize;
            if(end>=stu.size()){end=stu.size();}
            for (int i = start; i < end; i++)
            {
//                if(stu.get(i)==null)
//                    return;
//                else {
                    studentList.add(stu.get(i));
//                }
            }
        }
        for(int i=0;i<studentList.size();i++)
        {
            System.out.println(studentList.get(i));
        }
    }

    @Test
    public void TestStudyId()
    {
        List list=studentService.selectAllStudyId();
        System.out.println(list);
        Student student=studentService.selectByStudyId("java-001");
        System.out.println(student);
    }
}
