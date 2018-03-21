package com.student.dao;


import com.student.model.Register;

import java.util.List;

public interface RegisterDao {
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