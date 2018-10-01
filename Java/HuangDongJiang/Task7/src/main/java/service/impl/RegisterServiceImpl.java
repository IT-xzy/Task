package service.impl;

import dao.RegisterMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import pojo.User;
import service.RegisterService;
import util.Md5Util;

import javax.annotation.Resource;

@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService {
	private static final Log log = LogFactory.getLog(RegisterService.class);
	@Resource
	private RegisterMapper registerMapper;
	@Override
	public void addUser(User user) {
		//得到加密盐
		String salt = Md5Util.getSalt();
		//明文密码
		String oldPassword = user.getPassword();
		//加盐后的密码
		String saltPassword = Md5Util.getSaltMD5(oldPassword,salt);
		user.setPassword(saltPassword);
		user.setSalt(salt);
		log.info(user);
		registerMapper.addUser(user);
	}
}
