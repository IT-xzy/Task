package com.ev.service;

import com.ev.model.PageBean;
import com.ev.dao.StudentMapper;
import com.ev.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);
//    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//    private static StudentMapper studentMapper = context.getBean(StudentMapper.class);
    @Autowired
    private StudentMapper studentMapper;

    //插入一个学员信息并且返回主键
    @Override
    public Long addAStudent(Student student) throws Exception{
        try {
            Long insertTime=System.currentTimeMillis();
            student.setCreateAt(insertTime);
            student.setUpdateAt(insertTime);
            studentMapper.insertStudent(student);
            logger.info("Insert successfully.");
            return student.getId();
        } catch (DuplicateKeyException e){
            //插入学员时可能发生的异常
            logger.info("Student insert failed, caused by duplicated key");
            throw new DuplicateKeyException("Insert failed ,id exists.");
        }
    }

    //删除一个学员信息
    @Override
    public boolean deleteAStudent(Long primeKey) throws Exception{
        logger.info("The result delete student which id is "+primeKey+" is ");
        return studentMapper.deleteStudent(primeKey);
    }

    //通过主键来查询一个学员
    @Override
    public Student findStudentById(Long id) throws Exception{
        logger.info("The result find student by id "+id+" is ");
        return studentMapper.findById(id);
    }

    //通过姓名模糊查询
    @Override
    public List<Student> findStudentByName(String name) throws Exception{
        logger.info("The result find student by name "+name+" is ");
        return studentMapper.findByName(name);
    }

    //通过学号查找
    @Override
    public List<Student> findStudentByNumber(String online_num)  throws Exception{
        logger.info("The result find student by name "+online_num+" is ");
        return studentMapper.findByNumber(online_num);
    }

    //更新信息
    @Override
    public boolean updateStudent(Student student) throws Exception{
        student.setUpdateAt(System.currentTimeMillis());
        logger.info("The result update student which name is "+student.getName()+" is ");
        return studentMapper.updateStudent(student);
    }

    //清空表格
//    @Override
//    public void reset() throws Exception {
//        studentMapper.reset();
//    }

    //查询所有用户数据
    @Override
    public List<Student> selectStudentList() throws Exception{
        logger.info("Select all records.");
        return studentMapper.selectStudentList();
    }

    //查询用户记录总数
    @Override
    public int selectCount() throws Exception{
        logger.info("Select count of records.");
        return studentMapper.selectCount();
    }

    //根据分页数据start 和size查询数据
    @Override
    public PageBean<Student> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Student> pageBean = new PageBean<Student>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=10;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = studentMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Student> lists = studentMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }
}