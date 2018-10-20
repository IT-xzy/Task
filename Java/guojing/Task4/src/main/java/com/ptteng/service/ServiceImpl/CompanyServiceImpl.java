package com.ptteng.service.ServiceImpl;


import com.ptteng.dao.CompanyDao;
import com.ptteng.entity.Company;
import com.ptteng.service.CompanyService;
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
