package com.ptteng.service.Impl;

import com.ptteng.dao.OccupationDao;
import com.ptteng.dao.StudentsDao;
import com.ptteng.model.Occupation;
import com.ptteng.model.Student;
import com.ptteng.service.OccupationService;
import com.ptteng.util.MemcacheUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("occupationServiceImpl")
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    OccupationDao occupationDao;
    static MemcacheUtil memcacheUtil = new MemcacheUtil();
    static Logger logger = Logger.getLogger(OccupationServiceImpl.class);

    @Override
    public List<Occupation> get() throws Exception {

        List<Occupation> occupations= null;
        if (memcacheUtil.isExist("home3")){
            occupations= (List<Occupation>) memcacheUtil.getValue("home3");
            logger.info("The date of home1 gets from Memcache. ");
        }else {
            occupations = occupationDao.getAll();
            memcacheUtil.saveKyeAndValue("home3", occupations);
            logger.info("The date of home1 gets from MySQL. " );
        }
        return occupations;
    }
    @Autowired
    StudentsDao studentsDao;
    public List<Student> get1() throws  Exception{
        List<Student> students= null;
        if (memcacheUtil.isExist("home1")){
            students= (List<Student>) memcacheUtil.getValue("home1");
            logger.info("The date of home1 gets from Memcache. ");
        }else {
            students = studentsDao.getall();
            memcacheUtil.saveKyeAndValue("home1", students);
            logger.info("The date of home1 gets from MySQL. " );
        }
        return students;
    }
}
