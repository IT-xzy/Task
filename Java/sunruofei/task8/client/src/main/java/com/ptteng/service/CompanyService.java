package com.ptteng.service;

import com.ptteng.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectAll();
}
