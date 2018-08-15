package service.impl;
import dao.LoginMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import pojo.User;
import service.LoginService;
import util.DesUtil;
import util.Md5Util;

import javax.annotation.Resource;
import javax.servlet.http.*;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);
	@Resource
	private LoginMapper loginMapper;
	@Override
	public boolean judgeUser(String name, String password) throws Exception {
		User user = loginMapper.judgeUser(name);
		String DBSaltPassword = user.getPassword();
		String salt = user.getSalt();
		String DBName = user.getName();
		boolean isUserExistence = false;
		//如果加密盐不存在,直接返回验证用户名和密码失败
		if(salt == null) {
			return false;
		}else {
			//加密盐存在，继续查询加密后的密码
			String UserSaltPassword = Md5Util.getSaltMD5(password, salt);
			//核对数据库密码和用户密码；用户输入的名字和数据库的名字
			if (DBSaltPassword.equals(UserSaltPassword) && (DBName.equals(name))){
				isUserExistence = true;
			}
		}
		return isUserExistence;
	}

	@Override
	public String saveToken(String name) throws Exception {
		User user = loginMapper.judgeUser(name);
		//登录成功，DES加密用户ID和时间
		DesUtil desUtil = new DesUtil("FuckYou");
		int id = user.getId();
		//根据id和系统当前时间加密生成token
		String loginToken = desUtil.encrypt(id + "." + System.currentTimeMillis() + "");
		return loginToken;
	}
}
