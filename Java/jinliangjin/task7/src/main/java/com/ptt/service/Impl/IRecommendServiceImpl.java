package com.ptt.service.Impl;

import com.ptt.mapper.ICompanyMapper;
import com.ptt.mapper.StudentMapper;
import com.ptt.pojo.Company;
import com.ptt.pojo.Student;
import com.ptt.service.IRecommendService;
import com.ptt.util.CookieUtil;
import com.ptt.util.DESUtil;
import com.ptt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: RecommendServiceImpl
 * @Description: The service of page-recommend.
 * @Author: Jin
 * @CreateDate: 2018/5/26 15:38
 * @Version: 1.0
 */
@Service
public class IRecommendServiceImpl implements IRecommendService {
    @Autowired
    private ICompanyMapper iCompanyMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Value("${cookieName}")
    private String cookieName;
    @Autowired
    private RedisUtil redis;
    private Logger logger = LoggerFactory.getLogger(IRecommendService.class);

    /**
     * @Description: Select all cooperate companies.
     * @return: java.util.List<com.ptt.pojo.Company>
     * @Date: 2018/5/26 15:40
     */
    @Override
    public List<Company> getCompanies(HttpServletRequest request, Model model) {
        List<Company> companies = null;
        String url = null;
        String name = null;
        try {
            companies = iCompanyMapper.selectAll();
            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");
            logger.info("student:{}",student);
            if (null != student) {
                model.addAttribute("name", student.getName());
                url = student.getProfilePhoto();
                model.addAttribute("url", url);
                return companies;
            }
            logger.info("cookieName：" + cookieName);
            String value = CookieUtil.getCookieValue(request, cookieName);
            logger.info("value：" + value);
            String cookieValue = DESUtil.decrypt(value);
            logger.info(cookieValue);
            if (null != cookieValue) {
                name = cookieValue.split("-")[0];
                logger.info("name:" + name);
                model.addAttribute("name", name);
                student = (Student) redis.getValue("student", name);
                logger.info("redis student:{}", student);
                if (student != null) {
                    url = student.getProfilePhoto() == null
                            ? "/task7/images/qy1.png" : student.getProfilePhoto();
                    logger.info("redis url:{}", url);
                    model.addAttribute("url", url);
                    session.setAttribute("student", student);
                    return companies;
                } else {
                    student = studentMapper.selectByName(name);
                    session.setAttribute("student", student);
                    logger.info("student:{}",student);
                    redis.add("student", name, student);
                    url = student.getProfilePhoto();
                    model.addAttribute("url", url);
                    return companies;
                }
            }
            model.addAttribute("name", "未登录");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return companies;
    }
}
