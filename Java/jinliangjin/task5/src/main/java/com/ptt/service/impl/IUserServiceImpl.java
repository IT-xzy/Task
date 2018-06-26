package com.ptt.service.impl;

import com.ptt.mapper.PersistentLoginsMapper;
import com.ptt.mapper.UserMapper;
import com.ptt.pojo.PersistentLogins;
import com.ptt.pojo.User;
import com.ptt.service.IUserService;
import com.ptt.util.CookieUtil;
import com.ptt.util.DESUtil;
import com.ptt.util.Md5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: IUserServiceImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:37
 * @Version: 1.0
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Value("${salt}")
    private String salt;
    @Value("${cookieName}")
    private String cookieName;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PersistentLoginsMapper persistentLoginsMapper;

    private Logger logger = Logger.getLogger(IUserService.class);

    @Override
    public Boolean register(User user) {
        boolean flag = false;
        try {
            user.setPassword(Md5Util.encrypt(user.getPassword()));
            user.setCreateAt(System.currentTimeMillis());
            userMapper.insertSelective(user);
            logger.info("注册成功");
            flag = true;
            return flag;
        } catch (Exception e) {
            logger.info("注册失败。");
        }
        return flag;
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public User login(HttpServletResponse response, User user, String rememberMe) {
        User result = new User();
        //判断输入的用户名和密码不为空
        logger.info("判断用户名和密码是否为空");
        if(StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())){
            logger.info("用户名、密码不为空");
            //根据输入从数据库查询出用户详细信息
            String passwordGet = Md5Util.encrypt(user.getPassword());
            user.setPassword(passwordGet);
            result = userMapper.selectByUser(user);
            logger.info("查询用户");
            logger.info("验证用户是否为null，是否勾选rememberMe");
            //能找到用户信息（是已注册用户）
            if(null != result && StringUtils.isNotBlank(rememberMe)){
                logger.info("查询到用户：" + result);
                logger.info("已勾选rememberMe");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.HOUR, 1);//获取时间，一个小时
                Date validTime = calendar.getTime();//失效时间，一小时后
                //将时间转换为精确到毫秒的字符串
                String timeString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
                        + calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.HOUR_OF_DAY) + "-"
                        + calendar.get(Calendar.MINUTE) + "-" + calendar.get(Calendar.SECOND) + "-"
                        + calendar.get(Calendar.MILLISECOND);
                logger.info("字符串时间：" + timeString);
                String token = DESUtil.encrypt(result.getName() + "-" + result.getPassword() + "-"
                        + timeString + "-" + salt);
                logger.info("生成token：" + token);
                String uuidString = UUID.randomUUID().toString();
                logger.info("生成uuid：" + uuidString);
                String cookieValue = DESUtil.encrypt(result.getName() + ":" + uuidString);
                logger.info("将用户名和uuid加密生成cookieValue：" + cookieValue);
                logger.info("查询是否保存有自动登录记录");
                PersistentLogins persistentLogins = persistentLoginsMapper.selectByUsername(result.getName());
                if(null == persistentLogins){
                    logger.info("没有自动登录记录，新增中...");
                    logger.info(result.getName());
                    PersistentLogins login = new PersistentLogins();
                    login.setUsername(result.getName());
                    login.setSeries(uuidString);
                    login.setToken(token);
                    login.setValidtime(validTime);
                    persistentLoginsMapper.insertSelective(login);
                    logger.info("新增自动登录记录完成。");
                } else {
                    logger.info("存在自动登录记录，更新中...");
                    persistentLogins.setSeries(uuidString);
                    persistentLogins.setToken(token);
                    persistentLogins.setValidtime(validTime);
                    persistentLoginsMapper.updateByPrimaryKeySelective(persistentLogins);
                    logger.info("更新自动登录记录完成。");
                }
                logger.info("更新cookie。");
                CookieUtil.addCookie(response, cookieName, cookieValue);
            }//判断账号密码以及是否勾选记住我
        }
        return result;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        //根据请求查询到用户详情
        User user = (User) request.getSession().getAttribute("user");
        //根据用户名查询到自动登录信息
        PersistentLogins persistentLogins = persistentLoginsMapper.selectByUsername(user.getName());
        //存在自动登录信息则删除
        if(null != persistentLogins){
            persistentLoginsMapper.deleteByPrimaryKey(persistentLogins.getId());
        }
        //移除会话中的用户信息
        request.getSession().removeAttribute("user");
        //删除cookie
        CookieUtil.deleteCookie(request, response , cookieName);
    }
}
