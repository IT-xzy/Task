package com.dao;


import com.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {

    List<Company> findCompany();
}
