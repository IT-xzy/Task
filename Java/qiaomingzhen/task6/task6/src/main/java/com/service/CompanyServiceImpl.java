package com.service;/*
 * @ClassName:CompanyServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/7/27 15:31
 **/

import com.mapper.CompanyMapper;
import com.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{
@Autowired
private CompanyMapper companyMapper;
    @Override
    public List<Company> listCompany() {
        return companyMapper.listCompany();
    }

    @Override
    public Company selectCompany(Company company) {
        return companyMapper.selectCompany(company);
    }
}
