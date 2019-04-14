package com.ptteng.service.impl;

import com.ptteng.dao.CompanyMapper;
import com.ptteng.entity.Company;
import com.ptteng.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CompanyServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  11:24
 * @Version 1.0
 **/
@Service
public class CompanyServiceImp implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return companyMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(Company record) {
        return companyMapper.insert(record);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Long id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Company> selectAll() {
        return companyMapper.selectAll();
    }
}
