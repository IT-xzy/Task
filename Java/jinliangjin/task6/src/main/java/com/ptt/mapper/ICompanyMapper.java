package com.ptt.mapper;

import com.ptt.pojo.Company;

import java.util.List;

/**
 * @ClassName: ICompanyMapper
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/26 15:34
 * @Version: 1.0
 */
public interface ICompanyMapper {
    List<Company> selectAll();//合作公司
}
