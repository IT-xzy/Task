package com.service;

import com.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> listCompany();
    Company selectCompany(Company company);
}
