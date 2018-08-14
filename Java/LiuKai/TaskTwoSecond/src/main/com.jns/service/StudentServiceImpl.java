package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.PageBean;
import pojo.Student;

import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public long insertStudent(Student student) {
        long time=System.currentTimeMillis();
        student.setCreateTime(time);
        student.setUpdateTime(time);
        studentDao.insertStudent(student);
        return student.getId();
    }

    @Override
    public boolean deleteById(long id) {


        return studentDao.deleteById(id);
    }

    @Override
    public void deleteAll() {

        studentDao.deleteAll();
    }

    @Override
    public boolean updateStudent(Student student) {
        long time=System.currentTimeMillis();
        student.setUpdateTime(time);
        return studentDao.updateStudent(student);
    }

    @Override
    public Student findById(long id) {



        return studentDao.findById(id);
    }

    @Override
    public List<Student> findLikeName(String name) {
        return studentDao.findLikeName(name);
    }

    @Override
    public List<Student> findAll() {
        return   studentDao.findAll();
    }

    @Override
    public List<Student> findByPage(int currentPage) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        PageBean<Student> pageBean=new PageBean<Student>();
        pageBean.setCurrPage(currentPage);
        int pageSize=2;
        pageBean.setPageSize(pageSize);
        int totalCount=studentDao.findAll().size();
        pageBean.setTotalCount(totalCount);
        double tc=totalCount;
        Double num= Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start", (currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        List<Student> lists=studentDao.findByPage(map) ;
//        pageBean.setLists(lists);
//        return pageBean;
        return lists;
    }
//
//    public PageBean<Student> findByPage(int currentPage) {
//        HashMap<String,Object> map=new HashMap<String,Object>();
//        PageBean<Student> pageBean=new PageBean<Student>();
//        pageBean.setCurrPage(currentPage);
//        int pageSize=2;
//        pageBean.setPageSize(pageSize);
//        int totalCount=studentDao.findAll().size();
//        pageBean.setTotalCount(totalCount);
//        double tc=totalCount;
//        Double num= Math.ceil(tc/pageSize);
//        pageBean.setTotalPage(num.intValue());
//        map.put("start", (currentPage-1)*pageSize);
//        map.put("size", pageBean.getPageSize());
//        List<Student> lists=studentDao.findByPage(map) ;
//        pageBean.setLists(lists);
//        return pageBean;
//    }


    @Override
    public List<Student> getList(int start, int pageNum) {
        return studentDao.queryAll(start,pageNum);
    }
}
