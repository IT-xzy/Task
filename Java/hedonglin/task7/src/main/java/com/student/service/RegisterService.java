package com.student.service;

import com.student.model.Register;
import com.student.model.Student;

import java.util.List;

public interface RegisterService {
    int deleteByPrimaryKey(Long id);

    int insert(Register register);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Register record);

    Long updateByPrimaryKey(Register register);

    Register selectFinalCodeByCellphone(String cellphone);

    Long selectCellphoneSize(String cellphone);

    List<Register> getAllRegister();

    String getEmailCodeByEmail(String email);
}
