package com.ptteng.service.impl;

import com.ptteng.dao.UserDAO;
import com.ptteng.manager.Redis;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.exception.ForbiddenException;
import com.ptteng.pojo.model.Email;
import com.ptteng.pojo.model.Login;
import com.ptteng.pojo.model.User;
import com.ptteng.service.LoginService;
import com.ptteng.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Redis cacheManager;

    @Override
    public Map<String, String> checkLogin(Login login) throws Exception {
        String type = login.getType();
        String definition = login.getDefinition();
        String key = login.getKey();
        if (type == null)
            throw new ForbiddenException("无效登录请求,用户名：" + definition + "密码" + key);
        User user;
        switch (type) {
            case "userName":
                DataCheckUtil.lenthCheck(definition, 4, 10);
                DataCheckUtil.isName(definition);
                user = userDAO.findByName(definition);
                break;
            case "mail":
                DataCheckUtil.isMail(definition);
                user = userDAO.findByMail(definition);
                break;
            case "cellphone":
                DataCheckUtil.isCellphone(definition);
                user = userDAO.findByCellphone(definition);
                break;
            default:
                throw new ForbiddenException("无效登录请求,用户名：" + definition + "密码" + key);
        }
        if (user == null) {
            throw new UnacceptableException("该用户不存在");
        }
        if (!Objects.equals(user.getUserKey(), Md5Util.getMd5(key))) {
            throw new UnacceptableException("密码错误");
        }
        Map<String, String> map = new HashMap<>();
        //设置有效时间和Cookie的有效时间一致
        String token = JWTUtil.sign(login, 60 * 60 * 3 * 1000);
        map.put("token", token);
        String name = user.getUserName();
        map.put("name", name);
        user.setLoginAt(System.currentTimeMillis());
        userDAO.modifyLoginTime(user);
        return map;
    }

    @Override
    public String sendPhoneCode(User user, String ip) throws Exception {
        String name = user.getUserName();
        String cellphone = user.getCellphone();
        DataCheckUtil.lenthCheck(name, 4, 10);
        DataCheckUtil.isName(name);
        DataCheckUtil.isCellphone(cellphone);
        //一个用户名只能注册一个
        if (userDAO.findByName(name) != null) {
            throw new UnacceptableException("该用户名已被注册");
        }
        //一个手机只能注册一个
        if (userDAO.findByCellphone(cellphone) != null) {
            throw new UnacceptableException("该手机号已被注册");
        }
        //从缓存中取出该ip十小时内的发送数
        Object count = cacheManager.get(ip, "cellphone");
        int number;
        if (count == null) {
            cacheManager.put(ip, "cellphone", 0, 36000L);
            number = 0;
        } else {
            number = (int) count;
        }
        //超过限定额，直接返回错误码，不再往下执行
        if (number >= 5) {
            throw new UnacceptableException("该ip请求太频繁");
        }
        //1分钟内不能发送第二条短信
        if (cacheManager.get(cellphone, "sign") != null) {
            throw new UnacceptableException("发送短信太频繁");
        } else {
            cacheManager.put(cellphone, "sign", "ok", 60L);
        }
        //生成随机数
        String phoneCode = RandomUtil.getRandom(6);
        //发送验证码,如果返回状态码不是OK(详情见阿里云文档)，就视为失败
        String status = SMSUtil.sendSms(phoneCode, cellphone).getCode();
        if (!status.equals("OK")) {
            throw new UnacceptableException("验证短信发送失败");
        }
        //发送成功则增加计数
        number++;
        //添加新的ip请求次数到缓存中
        cacheManager.put(ip, "cellphone", number, 36000L);
        return phoneCode;
    }

    @Override
    public Long registerByPhone(User user) throws Exception {
        String name = user.getUserName();
        String key = user.getUserKey();
        String cellphone = user.getCellphone();
        //后端数据再次校核
        DataCheckUtil.lenthCheck(name, 4, 10);
        DataCheckUtil.isName(name);
        DataCheckUtil.lenthCheck(key, 6, 20);
        DataCheckUtil.isCellphone(cellphone);
        /*加密，使得数据库和登录校核时，加密的规则和结果一致
        也能防止运营人员窃取用户信息*/
        user.setUserKey(Md5Util.getMd5(user.getUserKey()));
        user.setCreateAt(System.currentTimeMillis());
        Boolean success;
        try {
            success = userDAO.insertUser(user);
        } catch (DuplicateKeyException e) {
            throw new UnacceptableException("请勿重复提交注册信息");
        }
        if (!success)
            throw new UnacceptableException("未知原因，注册失败");
        return user.getId();
    }

    @Override
    public void checkSigningMail(User user) throws Exception {
        String mail = user.getMail();
        String userName = user.getUserName();
        //检测用户名是否已经被注册，如果用户没有填写，跳过检测
        if (userName != null && !userName.equals("")) {
            DataCheckUtil.isName(userName);
            if (userDAO.findByName(userName) != null) {
                throw new UnacceptableException("用户名已经被注册");
            }
        }
        //检测邮箱是否已经被注册，如果用户没有填写，跳过检测
        if (mail != null && !mail.equals("")) {
            DataCheckUtil.isMail(mail);
            if (userDAO.findByMail(mail) != null) {
                throw new UnacceptableException("邮箱已经被注册");
            }
        }
    }

    @Override
    public String sendActivateMail(Email email, String basePath) throws Exception {
        String name = email.getName();
        String key = email.getKey();
        String mailbox = email.getMailbox();
        String ip = email.getIp();
        DataCheckUtil.lenthCheck(name, 4, 10);
        DataCheckUtil.lenthCheck(key, 6, 20);
        DataCheckUtil.isName(name);
        DataCheckUtil.isMail(mailbox);
        //一个用户名只能注册一个
        if (userDAO.findByName(name) != null) {
            throw new UnacceptableException("该用户名已被注册");
        }
        //一个手机只能注册一个
        if (userDAO.findByMail(mailbox) != null) {
            throw new UnacceptableException("该手机号已被注册");
        }
        //从缓存中取出该ip十小时内的发送数
        Object count = cacheManager.get(ip, "mail");
        int number;
        if (count == null) {
            cacheManager.put(ip, "mail", 0, 36000L);
            number = 0;
        } else {
            number = (int) count;
        }
        //超过限定额，直接返回错误码，不再往下执行
        if (number >= 5) {
            throw new UnacceptableException("该ip请求太频繁");
        }
        //1分钟内不能发送第二条短信
        if (cacheManager.get(mailbox, "sign") != null) {
            throw new UnacceptableException("发送邮件太频繁");
        } else {
            cacheManager.put(mailbox, "sign", "ok", 60L);
        }
        String token = JWTUtil.sign(email, EmailUtil.ALIVE_MS);
        StringBuffer sb = new StringBuffer();
        //拼接链接
        sb.append(basePath).append("/a/mail/activation").append("?token=").append(token);
        String link = sb.toString();
        //发送邮件
        String envId = EmailUtil.sendSingleEmail(mailbox, link).getEnvId();
        //发送成功则增加计数
        number++;
        //添加新的ip请求次数到缓存中
        cacheManager.put(ip, "mail", number, 36000L);
        return envId;
    }

    @Override
    public User registerByMail(String token, String ip) throws Exception {
        Email email = JWTUtil.unsign(token, Email.class);
        String tokenIp = email.getIp();
        if (!tokenIp.equals(ip)) {
            throw new ForbiddenException("异常的注册激活邮件,注册生成时IP:" + tokenIp);
        }
        User user = new User();
        user.setCreateAt(System.currentTimeMillis());
        user.setUserName(email.getName());
        user.setUserKey(Md5Util.getMd5(email.getKey()));
        user.setMail(email.getMailbox());
        boolean success;
        try {
            success = userDAO.insertUser(user);
        } catch (DuplicateKeyException e) {
            throw new UnacceptableException("请勿重复提交注册信息");
        }
        if (!success)
            throw new UnacceptableException("未知原因，注册失败");
        return user;
    }
}
