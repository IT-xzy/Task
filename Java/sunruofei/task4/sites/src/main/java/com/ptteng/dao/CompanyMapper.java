package com.ptteng.dao;

import com.ptteng.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectAll();
}