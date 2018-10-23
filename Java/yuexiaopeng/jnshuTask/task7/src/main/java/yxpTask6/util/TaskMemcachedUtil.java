package yxpTask6.util;

import net.rubyeye.xmemcached.XMemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import java.util.*;

/*
* 需求的方法
* 1.将student的数据放入cache中；使用map查询全部；
* 2.查询数据先到memecache中查询，没有结果到数据库中查；
* 3.增加数据，先增加数据库数据，然后更新缓存操作，缓存是先查全部，然后再更新缓存数据
* 疑问点：数据是按照studyId分别存多条，还是全部存一条，全部存一条是从结果中再查；感觉不太舒服；*/
@Component
public class TaskMemcachedUtil
{
    static Logger logger=LoggerFactory.getLogger(TaskMemcachedUtil.class);
    @Autowired
    private XMemcachedClient xMemcachedClient;

    @Autowired
    StudentService studentService;
    /*
    * 查询数据库全部数据，并且遍历放入缓存中
    * @Return Boolean 返回值为true则查询全部数据并放入缓存成功；
    * */
    public Boolean createAllStudentMemcache()
    {
        Boolean boo=false;

        try
        {
            //从数据库中查所有数据；KEY为数据的studyId；
            Map<String,Object> mapStudent=studentService.selectAllStudentMap();

            //遍历map，放入数据，数据的key为studyId
            for (Map.Entry<String,Object>  map : mapStudent.entrySet())
            {
            xMemcachedClient.set(map.getKey(),60*60*24*15,map.getValue());
            }
            boo=true;
        }
        catch (Exception E)
        {
            System.out.println("create memcached error : ["+E+"]");
        }
        return boo;
    }
    /*
     * 分页方法工具;
     * 具体操作：
     * 方法目的：获得学生studyId的一个list，作为索引使用；
     * * */
    public Boolean createIndexListMemcached()
    {
        Boolean boo=false;
        //将vector放入memcached中；
        try
        {
            //从数据查询数据成功，并将studyId存入了vector
            List<Student> studentList=studentService.selectAllStudent();
            Vector listVector = new Vector();
            for(int j=0;j<studentList.size();j++)
            {
                listVector.add(studentList.get(j).getStudyId());
            }
            xMemcachedClient.delete("listVector");
            xMemcachedClient.set("listVector",60*60*24*15,listVector);
            boo=true;
        }
        catch (Exception E)
        {
            System.out.println("add pageList to memcached error : ["+E+"]");
        }
        return boo;
    }
    /*
    * 数据库到memcached
    * @Return 成功则为true
    * */
    public Boolean mysqlToMemcache()
    {
        Boolean boo=false;
        try
        {
            createAllStudentMemcache();
            createIndexListMemcached();
            return boo=true;
        }
        catch(Exception e)
        {
            System.out.println("create from mysql error : "+e);
        }
        return boo;
    }
    /*
    * 从memcached到mysql
    * */
    public Boolean memcachedToMysql()
    {
        Boolean boo=false;
        String studyId;
        Student student;
        try
        {
            Vector listVetcor=xMemcachedClient.get("listVector");
            for(int i=0;i<listVetcor.size();i++)
            {
                studyId=listVetcor.get(i).toString();
                student=studentService.selectByStudyId(studyId);
                if(student==null)
                {
                student=xMemcachedClient.get(studyId);
                studentService.insertStudent(student);
                }
                student=xMemcachedClient.get(studyId);
                studentService.updateStudent(student);
                boo=true;
            }
        }
        catch(Exception e)
        {
            System.out.println("memcached to mysql error : "+e);
        }
        return boo;
    }
    /*
    * 增加单个数据至数据库和缓存中；
    * @Param student 待插入数据库的student；
    * */
    public Boolean addStudentMemcache(Student student)
    {
        Boolean boo=false;
        //从数据库中根据数据studyId查询查数据，存在即返回false；
//        Student student1=studentService.selectStudent(student);
        //不进行判断，直接将student放入，如果插不进去，会报错；返回false
        try
        {
//            studentService.insertStudent(student);
            //将数据放入，放入数据，数据的key为studyId
            xMemcachedClient.set(student.getStudyId(),60*60*24*15,student);
            boo=true;
            //更新索引list
            Vector listVector=xMemcachedClient.get("listVector");
            listVector.add(student.getStudyId());
            Collections.sort(listVector);
            xMemcachedClient.set("listVector",60*60*24*15,listVector);
        }
        catch (Exception E)
        {
            System.out.println("add memcached error : ["+E+"]");
        }
        return boo;
    }
    /*
    * 该方法从缓存中查询数据
    * @Parem student为包含查询的studyId的学生类
    * @Return student为从缓存中查询的student结果；
    * */
    public Student getStudentMemcache(String studyId)
    {
        Student student1=new Student();
        try
        {
            //根据studyId从缓存中得到数据；
            student1=xMemcachedClient.get(studyId);
        }
        catch (Exception E)
        {
            System.out.println("get memcached error : ["+E+"]");
        }
        return student1;
    }
    /*
    * 用于修改数据，同时修改缓存和数据库中的数据
    * @Param student 包含修改的student的studyId和修改后的slogen，master，dailyLink数据；及所有数据
    * 参数格式的判断应该在方法调用前执行；
    * @Return boolean 修改成功的值为true，否则为false
    * 说明：
    * */
    public Boolean updateStudentMemcache(Student student)
    {
        Boolean boo=false;
        try
        {
            //先进行数据库的数据更新
//            studentService.updateStudent(student);
            //查询出更新后的数据；
//            Student student1=getMemcache(student.getStudyId());
            //将缓存中的数据进行更新,true表示更新成功；
            boo=xMemcachedClient.replace(student.getStudyId(),60*60*24*15,student);
            //更新vector，涉及数据库操作；
            //pageListIndexMemcached();
            //list中不涉及studyId的改变，
//            Vector listVector=xMemcachedClient.get("listVector");
//            listVector.add(student.getStudyId());
//            xMemcachedClient.set("listVector",60*60*24*15,listVector);
        }
        catch(Exception E)
        {
            System.out.println("update memcached error ["+E+"]");

        }
        return boo;
    }
    /*
    * 用来将缓存中的数据删除，同时删除数据库的数据；
    * @Param student 包含要删除的数据的studyId；
    * @Return boolean 执行结果的返回值，true为删除成功；
    * */
    public Boolean deleteStudentMemcache(Student student)
    {
        Boolean boo=false;
        try
        {
            //根据studyId从缓存中删除数据；
            boo=xMemcachedClient.delete(student.getStudyId());
            //从数据库中删除
//            studentService.deleteStudent(student);
            //更新索引list，设计数据库操作；
            //pageListIndexMemcached();
            //删除list中的studyId,不涉及数据库操作的方法
            Vector listVector=xMemcachedClient.get("listVector");
            listVector.remove(student.getStudyId());
            Collections.sort(listVector);
            xMemcachedClient.set("listVector",60*60*24*15,listVector);
        }
        catch (Exception E)
        {
            System.out.println("delete memcached error : ["+E+"]");
        }
        return boo;
    }

    /*
    * 从vector中根据传入的页码，拿到index信息，并调用缓存数据，发送前台显示需要的分页页面；
    * @Param pageNum 传入的页码；
    * @Page pageSize 传入的每页个数
    * @return 根据参数返回的list数据，包含学生studyId
    * */
    public List getPageListMemcached(Integer pageNum,Integer pageSize)
    {
        List<Student> listStudent=new Vector<>();
        //根据传入的页码和页面数，计算出需要的vector下标；
        try
        {
            Vector listVector=xMemcachedClient.get("listVector");
            int pageEnd=pageNum*pageSize;
            int pageStart=pageNum*pageSize-pageSize;
            Student student;
            String studyId;
            if(pageStart>=0&&pageStart<listVector.size())
            {
                if(pageEnd>listVector.size())
                    pageEnd=listVector.size();
                for (int i = pageStart; i < pageEnd; i++)
                {
                    studyId = (String) listVector.get(i);
                    student = xMemcachedClient.get(studyId);
                    listStudent.add(student);
                }
            }
        }
        catch (Exception E)
        {
            System.out.println("getStudentList by pageNum from memcached error : ["+E+"]");
        }
        return listStudent;
    }
    /*
    * 获取学生数据的索引list
    * */
    public List getIndexListMemcached()
    {
        List listIndex=new Vector();
        try
        {
            Vector listVector=xMemcachedClient.get("listVector");
            listIndex=listVector;
        }
        catch (Exception E)
        {
            System.out.println("getIndexList by pageNum from memcached error : ["+E+"]");
        }
        return listIndex;
    }
}
