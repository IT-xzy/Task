package com.service;

import com.entity.Company;

import java.util.List;

public interface CompanyService {
    Company findById(Integer id);
    List<Company> findAll();
}
