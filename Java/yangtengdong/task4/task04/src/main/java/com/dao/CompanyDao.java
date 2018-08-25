package com.dao;

import com.entity.Company;

import java.util.List;

public interface CompanyDao {
    Company findById(Integer id);
    List<Company> findAll();
}
