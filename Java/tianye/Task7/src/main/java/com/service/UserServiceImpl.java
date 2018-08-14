package com.service;


import com.API.message.SDKTestSendTemplateSMS;
import com.API.mail.SendCommonPostMail;
import com.Dao.UserDao;
import com.Pojo.User;
import com.Tool.MemcachedUtils;
import com.whalin.MemCached.MemCachedClient;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger= Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private SDKTestSendTemplateSMS sdkTestSendTemplateSMS;
    private MemCachedClient memCachedClient;
    MemcachedUtils memcachedUtils;
    @Autowired
    private SendCommonPostMail sendCommonPostMail;
@Autowired
private UserDao userDao;

@Override
public void message(String userTel){
    logger.info("用户的手机号"+userTel);
    sdkTestSendTemplateSMS.sendMessage(userTel);
}
@Override
public void insert(User user){
    userDao.doInsert(user);

}
    @Override
    public JSONObject add(String verifyCode, User user){
    logger.info("用户输入的值"+verifyCode);
    String s_verifyCode=sdkTestSendTemplateSMS.getS_verifyCode();
    logger.info("验证码为"+s_verifyCode);
    JSONObject jsonObject=new JSONObject();
    if (verifyCode.equals(s_verifyCode)){
        userDao.doInsert(user);
        jsonObject.put("data","报名成功");
        return jsonObject;
    }else {
        jsonObject.put("data","验证码错误");
        return jsonObject;
    }
}

@Override
    public void delete(String userId){
    userDao.doDelete(userId);
}
@Override
    public User selectById(String userId){
    return userDao.findById(userId);

}
@Override
    public List<User> selectAll(){
    return  this.userDao.findAll();
}
@Override
    public boolean update(User user){
    userDao.doUpdate(user);
    return false;
}

    @Override
    public JSONObject sendMail(String userMail) {
        return null;
    }

    @Override
    public JSONObject sendMail(String userMail, HttpServletRequest httpServletRequest,String userId){
            logger.info("用户输入的值"+userMail);
           String httpUrl=httpServletRequest.getRequestURL().toString();
           logger.info(httpUrl);
        JSONObject jsonObject=new JSONObject();
        sendCommonPostMail.sendMail(userMail,httpUrl,userId);
        if ((sendCommonPostMail.sendMail(userMail,httpUrl,userId))==false){
            jsonObject.put("data","你的邮箱有误或发送失败");
            return jsonObject;
        }else {
            jsonObject.put("data", "发送邮件成功，请去邮箱验证");
           return jsonObject;
            }
            }
        }




