package com.ptteng.service.impl;

import com.ptteng.dao.ProfessionMapper;
import com.ptteng.model.Profession;
import com.ptteng.model.Temp;
import com.ptteng.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProfessionServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  11:36
 * @Version 1.0
 **/
@Service
public class ProfessionServiceImp implements ProfessionService {
 @Autowired
    ProfessionMapper professionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return professionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Profession record) {
        return professionMapper.insert(record);
    }

    @Override
    public int insertSelective(Profession record) {
        return professionMapper.insertSelective(record);
    }

    @Override
    public Profession selectByPrimaryKey(Long id) {
        return professionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Profession record) {
        return professionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Profession record) {
        return professionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Profession> selectByDynamicCondition(Long directionId) {
        return professionMapper.selectByDynamicCondition(directionId);
    }

    @Override
    public List<Profession> selectAll() {
        return professionMapper.selectAll();
    }

    @Override
    public List<Temp> selectStudentNumber() {
        return  professionMapper.selectStudentNumber();
    }
}
