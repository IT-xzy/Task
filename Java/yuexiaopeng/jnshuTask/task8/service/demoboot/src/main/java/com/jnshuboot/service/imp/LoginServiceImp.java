package com.jnshuboot.service.imp;

import com.jnshuboot.dao.LoginMapper;
import com.jnshuboot.pojo.Login;
import com.jnshuboot.pojo.example.LoginExample;
import com.jnshuboot.service.LoginService;
import com.jnshuboot.util.loginUtil.LoginFormat;
import com.jnshuboot.util.loginUtil.Md5Salt;
import com.jnshuboot.util.thirdUtil.SMSUtil;
import com.jnshuboot.util.thirdUtil.SendMaiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LoginServiceImp implements LoginService {
    @Autowired(required = false)
    private LoginMapper loginMapper;
    @Autowired
    private LoginExample loginExample;
    @Autowired
    private LoginFormat loginFormat;
    @Autowired
    private Md5Salt md5Salt;

    @Override
    public int register(Login login) {
        int i = -999;
        //格式符合
        if (verifyFormat(login)) {
            //判断存在
            if (!existAll(login)) {
                //不存在，填入账户基本信息，对密码进行md5加密并存入，盐值
                String salt = (int) ((Math.random() * 9 + 1) * 100000) + "";
                String passEncrypt = md5Salt.encrypt(login.getLoginPassword(), salt);
                login.setLoginPassword(passEncrypt);
                login.setLoginSalt(salt);
                login.setCreateAt(System.currentTimeMillis());
                login.setUpdateAt(System.currentTimeMillis());
                if (login.getLoginAccount() == null) {
                    login.setLoginAccount("account" + (int) ((Math.random() * 9 + 1) * 100000));
                }
                i = loginMapper.insertSelective(login);
                log.info("注册账号成功");
                return i;
            }
        }
        log.info("注册账号失败");
        return i;
    }

    @Override
    public int delete(Long loginId) {
        int i = -999;
//        loginExample.clear();
        if (loginId != null) {
//            LoginExample.Criteria criteria = loginExample.createCriteria();
//            criteria.andLoginIdEqualTo(loginId);
            LoginExample loginExample = new LoginExample();
            loginExample.createCriteria().andLoginIdEqualTo(loginId);
            i = loginMapper.deleteByExample(loginExample);
            log.info("删除账号成功");
            return i;
        }
        log.info("删除账号失败");
        return i;
    }

    //修改账户信息,根据账户loginId，不确定是用账户，手机，邮箱的哪个
    @Override
    public int changInfo(Login login) {
        int i = -999;
        //清除残存条件
        loginExample.clear();
        if (login.getLoginId() != null) {
            LoginExample.Criteria criteria = loginExample.createCriteria();
            criteria.andLoginIdEqualTo(login.getLoginId());
            login.setUpdateAt(System.currentTimeMillis());
            i = loginMapper.updateByExampleSelective(login, loginExample);
            log.info("更新信息成功");
            return i;
        }
        log.info("更新信息失败");
        return i;
    }

    @Override
    public int changePass(Login login) {
        int i = -999;
        return i;
    }

    //登录验证,验证之前进行过格式验证了
    @Override
    public boolean logining(Login login) {
        boolean boo = false;
        LoginExample.Criteria criteria = loginExample.createCriteria();
        //格式正确，账号存在
        if (verifyFormat(login) && existAll(login)) {
            //通用账号验证
            if (login.getLoginAccount() != null) {
                //清除残存条件
                loginExample.clear();
                criteria.andLoginAccountEqualTo(login.getLoginAccount());
                List<Login> list1 = loginMapper.selectByExample(loginExample);
                Login login1 = list1.get(0);
                String passEncrypt = md5Salt.encrypt(login.getLoginPassword(), login1.getLoginSalt());
                boolean b = login1.getLoginPassword().equals(passEncrypt);
                if (b) {
                    log.info("通用账号及密码验证成功");
                    return boo = true;
                }
                log.info("通用账号密码错误");
            }
            //手机账号验证；
            if (login.getLoginMobile() != null) {
                //清除残存条件
                loginExample.clear();
                criteria.andLoginMobileEqualTo(login.getLoginMobile());
                List<Login> list1 = loginMapper.selectByExample(loginExample);
                Login login1 = list1.get(0);
                String passEncrypt = md5Salt.encrypt(login.getLoginPassword(), login1.getLoginSalt());
                boolean b = login1.getLoginPassword().equals(passEncrypt);
                if (b) {
                    log.info("手机账号及密码验证成功");
                    return boo = true;
                }
                log.info("手机账号密码错误");
            }
            //邮箱账号验证；
            if (login.getLoginMail() != null) {
                //清除残存条件
                loginExample.clear();
                criteria.andLoginMailEqualTo(login.getLoginMail());
                List<Login> list1 = loginMapper.selectByExample(loginExample);
                Login login1 = list1.get(0);
                String passEncrypt = md5Salt.encrypt(login.getLoginPassword(), login1.getLoginSalt());
                boolean b = login1.getLoginPassword().equals(passEncrypt);
                if (b) {
                    log.info("邮箱账号及密码验证成功");
                    return boo = true;
                }
                log.info("邮箱账号密码错误");
            }
        }
        log.info("账号格式错误或任何账号都不存在");
        return boo;
    }

    @Override
    public boolean existAll(Login login) {
        boolean boo = false;
        int i = existAccount(login.getLoginAccount());
        int j = existMobile(login.getLoginMobile());
        int k = existMail(login.getLoginMail());
        if (i == 1611 || j == 1622 || k == 1633) {
            log.info("**通用账号**或手机号**或邮箱号**存在");
            return boo = true;
        }
        return boo;
    }

    //账号存在判断
    @Override
    public int existAccount(String loginAccount) {
        int status = -1500;
        //清除残存条件
        loginExample.clear();
        //判断通用账号
        if (loginFormat.account(loginAccount)) {
            //生成条件
            loginExample.or().andLoginAccountEqualTo(loginAccount);
            List<Login> list1 = loginMapper.selectByExample(loginExample);
            if (list1.size() == 0) {
                log.info("**1711**通用账号不存在");
                return status = 1711;
            }
            log.info("**1611**通用账号存在");
            return status = 1611;
        }
        log.info("**(-1500)**通用账号格式错误");
        return status;
    }

    //判断手机账号
    @Override
    public int existMobile(String loginMobile) {
        int status = -1500;
        //清除残存条件
        loginExample.clear();
        if (loginFormat.mobile(loginMobile)) {
            //生成条件
            loginExample.or().andLoginMobileEqualTo(loginMobile);
            List<Login> list1 = loginMapper.selectByExample(loginExample);
            if (list1.size() == 0) {
                log.info("**1722**手机账号不存在");
                return status = 1722;
            }
            log.info("**1622**手机账号存在");
            return status = 1622;
        }
        log.info("**(-1500)**手机账号格式错误");
        return status = -1500;
    }

    //判断邮箱账号
    @Override
    public int existMail(String loginMail) {
        int status = -1500;
        //清除残存条件
        loginExample.clear();
        if (loginFormat.mail(loginMail)) {
            //生成条件
            loginExample.or().andLoginMailEqualTo(loginMail);
            List<Login> list1 = loginMapper.selectByExample(loginExample);
            if (list1.size() == 0) {
                log.info("**1733**邮箱账号不存在");
                return status = 1733;
            }
            log.info("**1633**邮箱账号存在");
            return status = 1633;
        }
        log.info("**(-1500)**邮箱账号格式错误");
        return status;
    }

    //联合格式确认，登录使用；
    @Override
    public boolean verifyFormat(Login login) {
        boolean boo = false;
        //分别和密码联合验证格式，结果有符合的进行下一步
        boolean boo1 = loginFormat.account(login.getLoginAccount()) && loginFormat.password(login.getLoginPassword());
        boolean boo2 = loginFormat.mobile(login.getLoginMobile()) && loginFormat.password(login.getLoginPassword());
        boolean boo3 = loginFormat.mail(login.getLoginMail()) && loginFormat.password(login.getLoginPassword());
        if (boo1 || boo2 || boo3) {
            if (!boo1) {
                log.info("通用账户或密码**格式**不正确");
            }
            if (!boo2) {
                log.info("手机账户或密码**格式**不正确");
            }
            if (!boo3) {
                log.info("邮箱账户或密码**格式**不正确");
            }
            return boo = true;
        }
        log.info("所有账户及密码**格式**都不正确");
        return boo;
    }

    @Autowired
    SMSUtil smsUtil;

    @Override
    public String verifyMobile(String loginMobile) {
        String code = "-2500";
        if (loginFormat.mobile(loginMobile)) {
            code = smsUtil.getSMS(loginMobile);
            return code;
        }
        return code;
    }

    @Autowired
    SendMaiUtil sendMaiUtil;

    @Override
    public String verifyMail(String loginMail) {
        String code = "-3000";
        if (loginFormat.mail(loginMail)) {
            code = sendMaiUtil.sendCommon(loginMail);
            return code;
        }
        return code;
    }

    @Override
    public List pageLogin(Integer pageNum, Integer pageSize) {

        //输入格式错误给一个默认值；
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0 || pageSize >= 10) {
            pageSize = 5;
        }
        //清除残存条件
        loginExample.clear();
        Integer pageStart = pageNum * pageSize - pageSize;
        loginExample.setOffset(pageStart);
        loginExample.setLimit(pageSize);
        List<Login> list = loginMapper.selectByExample(loginExample);
        return list;
    }

    @Override
    public long countLogin() {
        //查询出数据库的总数目；
        loginExample.clear();
        long count = loginMapper.countByExample(loginExample);
        return count;
    }

    @Override
    public List<Login> selectById(Long loginId) {
        loginExample.clear();
        loginExample.createCriteria().andLoginIdEqualTo(loginId);
        List<Login> listLogin = loginMapper.selectByExample(loginExample);
        log.info("从数据库查询的id为{}的数据成功,数据为{}", loginId, listLogin);
        return listLogin;
    }
}
