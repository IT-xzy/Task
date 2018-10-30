package com.mapper;

import com.model.Company;

import java.util.List;

public interface CompanyMapper {
    List<Company> listCompany();
    Company selectCompany(Company company);
}
