package yxpTask6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxpTask6.dao.LoginDao;
import yxpTask6.pojo.Login;
import yxpTask6.service.LoginService;

@Service
public class LoginServiceImp implements LoginService
{
    @Autowired
    private LoginDao loginDao;
    //注册用户名和密码
    public int registerLogin(Login login){return loginDao.insertLogin(login); }
    //查询账户信息
    public Login selectLogin(String loginAccount){return loginDao.selectLogin(loginAccount);}
    //更新账户密码及其他数据
    public int updateLogin(Login login){return loginDao.updateLogin(login);}
    //更新账号的密码
    public int updatePassword(Login login){return loginDao.updatePassword(login);}
}
