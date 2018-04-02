package lujing.serviceimpl;

import lujing.Constant;
import lujing.mapper.UserMapper;
import lujing.pojo.User;
import lujing.security.JwtUtils;
import lujing.security.MessageDigestUtils;
import lujing.security.SaltGenerate;
import lujing.service.UserService;
import lujing.util.CookieUtils;
import lujing.util.SendCloudAPIV2_44;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/5 14:45
 */

@Service("userServiceImpl")

public class UserServiceImpl implements UserService {
    
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    UserMapper userMapper;
    
    
    /**
     * 用户登录认证
     *
     * @param session
     * @param response
     * @param user     前端分离后的用户
     * @param password 前端回传的密码
     * @return 0:认证成功。1：用户不存在。-1：认证失败。2:未激活
     */
    @Override
    public int verifyUser(HttpSession session, HttpServletResponse response,
                          User user, String password) {
        User record = userMapper.findUserCustom(user);
        
        if (null != record) {
            if(record.getEmailStatus() !=null&&record.getEmailStatus() == 0){
                return 2;
            }
            
            //获得用户的盐值
            String salt = record.getSalt();
            //再次生成加密后的密码
            String verifyDesPwd = MessageDigestUtils.SHA256(password + salt);
            if (verifyDesPwd.equals(record.getDesPassword())) {
                //登录成功，使用工具类生成TOKEN;
                String token = JwtUtils.
                        generateToken(Constant.siginKey, record.getName(), 30 * 60 * 1000l);
                //将生成的token,放入制定域对象的cookie中，并设置有效时长。
                CookieUtils.createCookie(response, Constant.jwtCookieName, token, 30 * 60);
                //生成session
                session.setAttribute("username", record.getName());
                session.setMaxInactiveInterval(30 * 60);
                return 0;
            }
            return -1;
        }
        return 1;
        
    }
    
    @Override
    public String findUserByName(String name) {
        return null;
    }
    
    
    /**
     * 注册请求
     *
     * @param record 页面回传的注册信息
     * @return
     */
    @Override
    public String siginUser(User record, String RecordPassWord) {
        //不判断是否存在相同用户名啦。。。。

//        User userFinder = userMapper.findUserCustom();
//        if (userFinder != null) {
//            return Constant.signFail;
//        }
        
        //生成注册用户的盐值
        String salt = SaltGenerate.getSalt();
        record.setSalt(salt);
        //将盐值混入密码中
        StringBuffer hex = new StringBuffer();
        hex.append(RecordPassWord).append(salt);
        String message = hex.toString();
        //des加密
        String desPwd = MessageDigestUtils.SHA256(message);
        //存入record中
        record.setDesPassword(desPwd);
        
        
        //执行判断语句并判断插入是否成功
        int result = userMapper.insertSelective(record);
        if (result == 0) {
            return Constant.signFail;
        }
        
        return Constant.signSuccess;
    }
    
    /**
     * 验证用户是否存在
     *
     * @param userRecord
     * @return 1：手机号存在，0：什么都没有,2：用户名存在,3：邮箱存在。
     */
    @Override
    public int findUserCustom(User userRecord) {
        String name = userRecord.getName();
        String phoneNum = userRecord.getPhoneNum();
        String email = userRecord.getEmail();
        User test = new User();
        test.setName(name);
        
        if (null != userMapper.findUserCustom(test)) {
            return 2;
        } else {
            if (null != phoneNum && !phoneNum.equals("")) {
                //清空用户名
                test.setName("");
                test.setPhoneNum(phoneNum);
                if (null != userMapper.findUserCustom(test)) {
                    return 1;
                }
            }
            if (null != email && !email.equals("")) {
                //清空用户名
                test.setName("");
                test.setEmail(email);
                if (null != userMapper.findUserCustom(test)) {
                    return 3;
                }
            }
        }
        return 0;
    }
    
    /**
     * @param to  邮箱接收地址
     * @param ttl 激活链接
     * @return 0:发送成功。else 发送失败httpstatus
     */
    @Override
    public int sendActiveEmail(String to, String subject, HttpServletRequest request, Long ttl) {
        
        String token = JwtUtils.generateToken(Constant.siginKey, subject, ttl);
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        
        StringBuffer sbb = new StringBuffer();
        sbb.append(basePath).append("/activeEmail").append("?").append("name=").append(subject);
        sbb.append("&token=").append(token);
        String url = sbb.toString();
        logger.info("激活链接" + url);
        int result = SendCloudAPIV2_44.send_template(to, subject, url);
        if (result == 200) {
            return 0;
        }
        logger.info("发送状态" + result);
        return result;
    }
}