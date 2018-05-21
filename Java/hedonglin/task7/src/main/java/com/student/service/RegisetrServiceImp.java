package com.student.service;

import com.student.dao.RegisterDao;
import com.student.model.Register;
import com.student.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegisetrServiceImp implements RegisterService {

    @Resource
    private RegisterDao registerDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return registerDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Register register) {
        return registerDao.insert(register);
    }

    @Override
    public int insertSelective(Register register) {
        return 0;
    }

    @Override
    public Register selectByPrimaryKey(Long id) {
        return registerDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Register record) {
        return 0;
    }

    @Override
    public Long updateByPrimaryKey(Register register) {
        return registerDao.updateByPrimaryKey(register);
    }

    @Override
    public Register selectFinalCodeByCellphone(String cellphone) {
        return registerDao.selectFinalCodeByCellphone(cellphone);
    }

    @Override
    public Long selectCellphoneSize(String cellphone) {
        return registerDao.selectCellphoneSize(cellphone);
    }

    @Override
    public  List<Register> getAllRegister() {
        return registerDao.getAllRegister();
    }

    @Override
    public String getEmailCodeByEmail(String email) {
        return registerDao.getEmailCodeByEmail(email);
    }


}
