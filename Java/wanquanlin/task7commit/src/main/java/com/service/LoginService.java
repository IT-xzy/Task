package com.service;

import com.POJO.*;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * User类业务层接口
 */
public interface LoginService {
    //task-4
    List<GoodStudent> findGood();
    int selectCount();
    int selectCountGraduate();
    List<Images1> findImgaes1();
    //查找第一种职业的数据 test3页面中使用
    List<JobList> findJobList1();
    SignIn clientLogin(Long ID);
    SignIn clientLogin2(String account);
    String register(Register register,File file);

}
