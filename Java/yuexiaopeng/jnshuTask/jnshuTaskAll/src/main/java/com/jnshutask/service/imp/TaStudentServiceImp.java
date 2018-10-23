package com.jnshutask.service.imp;


import com.github.pagehelper.PageHelper;
import com.jnshutask.dao.TaStudentDao;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.pojo.example.TaStudentExample;
import com.jnshutask.service.TaStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 24569
 */
@Slf4j
@Service
public class TaStudentServiceImp implements TaStudentService {

    @Autowired(required = false)
    private TaStudentDao taStudentDao;
    @Autowired
    private TaStudentExample taStudentExample;

    @Override
    public TaStudent insertSelective(TaStudent taStudent) {
        //增加数据，如果不填写会有默认值；studyId不填写会有-10返回,进行插入；
//        int i = -999;
        taStudentExample.clear();
        taStudent.setCreateAt(System.currentTimeMillis());
        taStudent.setUpdateAt(System.currentTimeMillis());
        taStudentDao.insertSelective(taStudent);
        log.info("数据库插入ID为{}的student数据成功", taStudent.getId());
        taStudentExample.createCriteria().andIdEqualTo(taStudent.getId());
        List<TaStudent> list = taStudentDao.selectByExample(taStudentExample);
        TaStudent taStudent1 = list.get(0);
        log.info("从数据库返回ID为{}的student数据成功", taStudent.getId());
        return taStudent1;
    }

    @Override
    public int deleteById( Integer id) {
        //根据studyId删除数据,空的studyId返回-10；
        int i = -999;
        taStudentExample.clear();
        try {
            taStudentExample.createCriteria().andIdEqualTo(id);
            i = taStudentDao.deleteByExample(taStudentExample);
            log.info("数据库删除ID为{}的student数据记录的数量为{}", id,i);
            return i;
        }catch(Exception e){
            //id值为null
            log.error("删除数据出错,传入的id值为null,具体错误信息为{}",e.getMessage());
        }
        return i;
    }


    @Override
    public TaStudent updateById(TaStudent taStudent) {
        //更新数据，条件为Id不为空；
        int i = -999;
        TaStudent student1 = new TaStudent();
        taStudentExample.clear();
        try{
            taStudentExample.createCriteria().andIdEqualTo(taStudent.getId());
            taStudent.setUpdateAt(System.currentTimeMillis());
            i = taStudentDao.updateByExampleSelective(taStudent, taStudentExample);
            taStudentExample.createCriteria().andIdEqualTo(taStudent.getId());
            List<TaStudent> list = taStudentDao.selectByExample(taStudentExample);
            student1 = list.get(0);
            log.info("数据库更新ID为:{}的student数据记录的数量为:{}", taStudent.getId(),i);
            return student1;
        }catch (IndexOutOfBoundsException ie){
            //出错情况为id为不存在
            log.error("更新数据出错,id:{}不存在，具体出错原因:{}",taStudent.getId(),ie.getMessage());
        }catch (Exception e){
            //出错情况为id=null
            log.error("更新数据出错,id为null,具体出错原因:{}",e.getMessage());
        }
        return student1;
    }

    @Override
    public TaStudent selectById( Integer id) {
        TaStudent student1 = new TaStudent();
        taStudentExample.clear();
        try {
            taStudentExample.createCriteria().andIdEqualTo(id);
            List<TaStudent> studentList = taStudentDao.selectByExample(taStudentExample);
            //数据不存在时，会出现index异常；
            student1 = studentList.get(0);
            log.info("从数据库查询的id为:{}的student数据记录成功!", id);
            return student1;
        } catch (IndexOutOfBoundsException e1) {
            //id不存在
            log.error("查询数据出错,id:{}不存在,具体错误信息为:{}",id,e1.getMessage());
        }
        catch(Exception e2){
            //id值为null
            log.error("查询数据出错,id为null,具体错误信息为:{}",e2.getMessage());
        }
        return student1;
    }

    @Override
    public List<TaStudent> selectPage(Integer pageNum, Integer pageSize) {
        //参数为null报空指针，num为负没事，size为负查询到为空list
        taStudentExample.clear();
        List<TaStudent> taStudentList=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            taStudentList=taStudentDao.selectByExample(taStudentExample);
            log.info("从数据库查询分页数据成功,第一条数据为{}",taStudentList.get(0));
            return taStudentList;
        }catch(NullPointerException ne){
            //参数为null
            log.error("参数为null异常{}",ne.getMessage());
        }catch (Exception e){
            //参数为负
            log.error("参数值异常{}",e.getMessage());
        }
        return taStudentList;
    }

    @Override
    public int exist(TaStudent student) {
        int i = -999;
        taStudentExample.clear();
        return i;
    }

    @Override
    public long countAll() {
        Long lon = -999L;
        taStudentExample.clear();
        lon = taStudentDao.countByExample(taStudentExample);
        return lon;
    }
}
