package com.ptt.dao;

import com.ptt.pojo.Company;

import java.util.List;

/**
 * @ClassName: IRecommendService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/26 15:36
 * @Version: 1.0
 */
public interface IRecommendService {
    List<Company> getCompanies();
}
