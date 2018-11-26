package com.service.ServiceImpl;


import com.dao.CompanyDao;
import com.entity.Company;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;


    @Override
    public List<Company> findCompany() {
        return companyDao.findCompany();
    }
}
