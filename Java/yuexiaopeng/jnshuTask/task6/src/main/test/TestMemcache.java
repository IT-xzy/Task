import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import yxpTask6.util.TaskMemcachedUtil;
//import yxpTask6.util.MemcacheUtil;

import java.util.List;
import java.util.Vector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class TestMemcache
{
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    StudentService studentService;
    @Test
    public void memcachedTest()
    {
        XMemcachedClient xMemcachedClient=(XMemcachedClient)applicationContext.getBean("xMemcachedClient");
        Student studentParam=new Student();
        studentParam.setStudyId("666-001");
        Student student=studentService.selectStudent(studentParam);
        try
        {
            xMemcachedClient.set(student.getStudyId(),60*60*24*15,student);
        }
        catch (Exception E)
        { E.getMessage();}
        try
        {
            Student student1=xMemcachedClient.get(student.getStudyId());
            System.out.println(student1);
        }
        catch (Exception E)
        { E.getMessage();}

    }

    @Autowired
    TaskMemcachedUtil taskMemcachedUtil;
    @Test
    public void memcachedUtilTest()
    {
        //将所有数据放入缓存中
        Boolean boo=taskMemcachedUtil.createAllStudentMemcache();
        System.out.println(boo);
    }
    @Test
    public void memcachedUtilGetTest()
    {
        Student student=new Student();
        student.setStudyId("java-006");
        System.out.println(student);
        Student student1=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        System.out.println(student1);
    }
    @Test
    public void memcachedUtilDeleteTest()
    {
        Student student=new Student();
        student.setStudyId("java-009");
        System.out.println(student);
        Boolean boo=taskMemcachedUtil.deleteStudentMemcache(student);
        System.out.println(boo);
        Student student1=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        System.out.println(student1);
        List list=taskMemcachedUtil.getIndexListMemcached();
        System.out.println(list);
    }
    @Test
    public void memcachedUtilUpdateTest()
    {
        Student student=new Student();
        student.setStudyId("java-006");
        student.setMaster("qitiandashen");
        student.setDailyLink("google.com");
        student.setSlogen("wukong");
        student.setId(666);
        student.setCreateAt(20180608l);
        student.setUpdateAt(20180608l);
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");
        student.setJoinTime(20180608l);
        student.setUniversity("葡院");
        System.out.println(student);
        Student student1=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        System.out.println(student1);
        Boolean boo=taskMemcachedUtil.updateStudentMemcache(student);
        System.out.println(boo);
        Student student2=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        System.out.println(student2);
    }
    @Test
    public void memcachedUtilAddOneTest() throws Exception
    {
        Student student=new Student();
        student.setId(666);
        student.setCreateAt(20180608l);
        student.setUpdateAt(20180608l);
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");
        student.setStudyId("java-003");
        student.setJoinTime(20180608l);
        student.setUniversity("葡院");
        student.setDailyLink("http://www.jnshu.com/school/22071/daily");
        student.setSlogen("fvfeeeeeefvfvf");
        student.setMaster("嗨，大师兄");
        System.out.println(student);
        Boolean boo=taskMemcachedUtil.addStudentMemcache(student);
        System.out.println(boo);
        Student student1=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        System.out.println(student1);
        List list=taskMemcachedUtil.getIndexListMemcached();
        System.out.println(list);
    }
    @Autowired
    XMemcachedClient xMemcachedClient;
    @Test
    public void memcachedUtilPageTest()
    {
        List listStudent=taskMemcachedUtil.getPageListMemcached(2,3);
        System.out.println("分页后的数据为*****"+listStudent);

        List listIndex=taskMemcachedUtil.getIndexListMemcached();
        System.out.println("索引数据为******"+listIndex);
    }
    @Test
    public void memcachedToMysql()
    {
        Boolean boo=taskMemcachedUtil.memcachedToMysql();
        System.out.println(boo);
    }
    @Test
    public void mysqlToMemcached()
    {
        Boolean boo=taskMemcachedUtil.mysqlToMemcache();
        System.out.println(boo);
        List listIndex=taskMemcachedUtil.getIndexListMemcached();
        System.out.println("索引数据为******"+listIndex);
    }
    @Autowired
    MemcachedClient memcachedClient;
//    @Autowired
//    TaskMemcachedOtherUtil taskMemcachedOtherUtil;
    @Test
    public void mysqlToMemcached2222()
    {
        Boolean boo=taskMemcachedUtil.mysqlToMemcache();
        System.out.println(boo);
        List listIndex=taskMemcachedUtil.getIndexListMemcached();
        System.out.println("索引数据为******"+listIndex);
//        Boolean boo=taskMemcachedOtherUtil.mysqlToMemcache2();
//        System.out.println(boo);
//        taskMemcachedOtherUtil.createIndexListMemcached2();
    }
}
