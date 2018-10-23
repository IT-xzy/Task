package com.jnshutask.service.imp;


import com.github.pagehelper.PageHelper;
import com.jnshutask.dao.TaLoginDao;
import com.jnshutask.pojo.TaLogin;
import com.jnshutask.pojo.example.TaLoginExample;
import com.jnshutask.service.TaLoginService;
import com.jnshutask.util.loginUtil.LoginFormat;
import com.jnshutask.util.loginUtil.Md5Salt;
import com.jnshutask.util.thirdUtil.SMSUtil;
import com.jnshutask.util.thirdUtil.SendMaiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaLoginServiceImp implements TaLoginService {
    @Autowired(required = false)
    private TaLoginDao taLoginDao;
    @Autowired
    private TaLoginExample taLoginExample;
    @Autowired
    private LoginFormat loginFormat;
    @Autowired
    private Md5Salt md5Salt;

    @Override
    public int register(TaLogin login) {
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
                i = taLoginDao.insertSelective(login);
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
            TaLoginExample loginExample = new TaLoginExample();
            loginExample.createCriteria().andLoginIdEqualTo(loginId);
            i = taLoginDao.deleteByExample(loginExample);
            log.info("删除账号成功");
            return i;
        }
        log.info("删除账号失败");
        return i;
    }

    //修改账户信息,根据账户loginId，不确定是用账户，手机，邮箱的哪个
    @Override
    public int changInfo(TaLogin login) {
        int i = -999;
        //清除残存条件
        taLoginExample.clear();
        if (login.getLoginId() != null) {
            TaLoginExample.Criteria criteria = taLoginExample.createCriteria();
            criteria.andLoginIdEqualTo(login.getLoginId());
            login.setUpdateAt(System.currentTimeMillis());
            i = taLoginDao.updateByExampleSelective(login, taLoginExample);
            log.info("更新信息成功");
            return i;
        }
        log.info("更新信息失败");
        return i;
    }

    @Override
    public int changePass(TaLogin login) {
        int i = -999;
        return i;
    }

    //登录验证,验证之前进行过格式验证了
    @Override
    public boolean logining(TaLogin login) {
        boolean boo = false;
        TaLoginExample.Criteria criteria = taLoginExample.createCriteria();
        //格式正确，账号存在
        if (verifyFormat(login) && existAll(login)) {
            //通用账号验证
            if (login.getLoginAccount() != null) {
                //清除残存条件
                taLoginExample.clear();
                criteria.andLoginAccountEqualTo(login.getLoginAccount());
                List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
                TaLogin login1 = list1.get(0);
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
                taLoginExample.clear();
                criteria.andLoginMobileEqualTo(login.getLoginMobile());
                List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
                TaLogin login1 = list1.get(0);
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
                taLoginExample.clear();
                criteria.andLoginMailEqualTo(login.getLoginMail());
                List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
                TaLogin login1 = list1.get(0);
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
    public boolean existAll(TaLogin login) {
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
        taLoginExample.clear();
        //判断通用账号
        if (loginFormat.account(loginAccount)) {
            //生成条件
            taLoginExample.or().andLoginAccountEqualTo(loginAccount);
            List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
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
        taLoginExample.clear();
        if (loginFormat.mobile(loginMobile)) {
            //生成条件
            taLoginExample.or().andLoginMobileEqualTo(loginMobile);
            List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
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
        taLoginExample.clear();
        if (loginFormat.mail(loginMail)) {
            //生成条件
            taLoginExample.or().andLoginMailEqualTo(loginMail);
            List<TaLogin> list1 = taLoginDao.selectByExample(taLoginExample);
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
    public boolean verifyFormat(TaLogin login) {
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
    public List<TaLogin> pageLogin(Integer pageNum, Integer pageSize) {
        //参数为null报空指针，num为负没事，size为负查询到为空list
        taLoginExample.clear();
        List<TaLogin> loginList=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            loginList=taLoginDao.selectByExample(taLoginExample);
            log.info("从数据库查询分页数据成功,第一条数据为{}",loginList.get(0));
            return loginList;
        }catch(NullPointerException ne){
            //参数为null
            log.error("参数为null异常{}",ne.getMessage());
        }catch (Exception e){
            //参数为负,参数值越界
            log.error("参数值为负或越界异常{}",e.getMessage());
        }
        return loginList;
    }

    @Override
    public long countLogin() {
        //查询出数据库的总数目；
        taLoginExample.clear();
        long count = taLoginDao.countByExample(taLoginExample);
        return count;
    }

    @Override
    public TaLogin selectById(Long loginId) {
        taLoginExample.clear();
        taLoginExample.createCriteria().andLoginIdEqualTo(loginId);
        List<TaLogin> listLogin = taLoginDao.selectByExample(taLoginExample);
        TaLogin taLogin=new TaLogin();
        try{
            taLogin=listLogin.get(0);
            log.info("从数据库查询的id为{}的数据成功,数据为{}", loginId, listLogin);
        }catch (IndexOutOfBoundsException e1) {
            //id不存在
            log.error("查询数据出错,id:{}不存在,具体错误信息为:{}",loginId,e1.getMessage());
        }
        catch(Exception e2){
            //id值为null
            log.error("查询数据出错,id为null,具体错误信息为:{}",e2.getMessage());
        }
        return taLogin;
    }
}
