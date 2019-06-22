package cn.wp.service.impl;

import cn.wp.dao.ProfessionDao;
import cn.wp.model.Profession;
import cn.wp.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProfessionServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 12:18
 * @Version: 1.0
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionDao professionDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return professionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Profession record) {
        return professionDao.insert(record);
    }

    @Override
    public int insertSelective(Profession record) {
        return professionDao.insertSelective(record);
    }

    @Override
    public Profession selectByPrimaryKey(Long id) {
        return professionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Profession record) {
        return professionDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Profession record) {
        return professionDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Profession> selectByDynamicCondition(Long count) {
        return professionDao.selectByDynamicCondition(count);
    }

    @Override
    public List<Profession> selectAll() {
        return professionDao.selectAll();
    }

//    @Override
//    public List<Temp> selectStudentNumber() {
//        return professionDao.selectStudentNumber();
//    }
}
