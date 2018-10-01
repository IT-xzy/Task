package com.ptt.service;

import com.ptt.pojo.Company;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
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
