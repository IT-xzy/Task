package task.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.dao.LoginDao;
import task.pojo.Login;
import task.service.LoginService;

@Service
public class LoginServiceImp implements LoginService
{
    @Autowired
    private LoginDao loginDao;
    //插入用户名和密码
    public int insertLogin(Login login){return loginDao.insertLogin(login); }
    //查询账户及密码
    public Login selectLogin(Login login){return loginDao.selectLogin(login);}
    //更新账户密码及其他数据
    public int updateLogin(Login login){return loginDao.updateLogin(login);}
}
