package com.jnshu.serviceimpl;

import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.service.Student4Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("NoCache")
public class Student4ServiceImpl implements Student4Service {
    Logger logger = LogManager.getLogger(Student4ServiceImpl.class.getName());
    @Autowired
    Student4Mapper student4Mapper;

    @Override
    public long CountSelective(String job,boolean state ) {
        logger.info("CountSelective======\n"+"job=====" + job);
        long count=0;
        Student4 student4 = new Student4();
        student4.setPosition(job);
        student4.setState(state);
        count = student4Mapper.selectCount(student4);
        return count;
    }

    @Override
    public long SelectCountByState(boolean state) {
        logger.info("CountSelective======\n"+"state=====\n" + state);
        //通用Example查询
        Example example = new Example(Student4.class);// 创建Example
        long count;
        //创建Criteria
        Example.Criteria criteria = example.createCriteria();
        //按工资升序排列
        //状态为false的是已毕业学员
        criteria.andEqualTo("state", state);
        count = student4Mapper.selectCountByExample(example);
        return count;
    }

    @Override
    public List<Student4> getOrderByKeyWords(Student4 student4) {
        logger.info("CountSelective======\n"+"student4=====\n" + student4.toString());
        //String keyWords = student4.getSalary();
        //通用Example查询
        Example example = new Example(Student4.class);// 创建Example
        //创建Criteria
        Example.Criteria criteria = example.createCriteria();
        //按工资升序排列
        example.setOrderByClause("salary DESC");
        //状态为false的是已毕业学员
        criteria.andEqualTo("state", student4.getState());
        List<Student4> student4List = student4Mapper.selectByExample(example);
        return student4List;
    }

    @Override
    public List<Student4> findAll() {
        return student4Mapper.selectAll();
    }
    @Override
    public Student4 findStudent4ById(Long id){
       return student4Mapper.findById(id);
       // return student4Mapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean batchSave(List<Student4> student4List) {
        logger.info("batchSave======="+student4List);
        boolean flag=false;
        Long uid = student4Mapper.batchSave(student4List);
        if(uid != 0){
            logger.info("新增数量：======="+uid);
            flag = true;
        }
        return flag;
    }

    @Override
    public long addStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public int updateStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public int deleteStudent4(Student4 student4) {
        return student4Mapper.deleteByExample(student4);
    }

    @Override
    public List<Student4> getStudent4ByPage(int pageIndex, int pageSize) {
        return null;
    }

}

