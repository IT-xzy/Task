package task07.services.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task07.controller.UserLoginController;
import task07.dao.UserLoginDao;
import task07.pojo.UserLogin;
import task07.services.UserLoginServices;
import task07.util.des.CharacterUtils;
import task07.util.des.DesUtil;
import task07.util.md5.MD5Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;


@Service
public class UserLoginServicesImpl implements UserLoginServices {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	private static final Charset CHARSET = Charset.forName("gb2312");

	@Autowired
	private UserLoginDao userLoginDao;

	@Override
	public UserLogin login(UserLogin userLogin) {
		return userLoginDao.login(userLogin);
	}

	@Override
	public void register(UserLogin userLogin) {
		userLoginDao.register(userLogin);
	}

	@Override
	public UserLogin queryByName(String name) {
		return userLoginDao.queryByName(name);
	}

	@Override
	public void insertDes(String s) {
		userLoginDao.insertDes(s);
	}

	@Override
	public void updateDes(String despassword, int id) {
		userLoginDao.updateDes(despassword, id);
	}

	@Override
	public String registerQueryName(String frontName) {
		return userLoginDao.registerQueryName(frontName);
	}

	@Override
	public String registerQueryPhoneNumber(String phoneNumber) {
		return userLoginDao.registerQueryPhoneNumber(phoneNumber);
	}

	@Override
	public String registerQueryEmail(String email) {
		return userLoginDao.registerQueryEmail(email);
	}

	@Override
	public boolean UserRegister(HttpServletRequest httpServletRequest,
								HttpServletResponse httpServletResponse,
								UserLogin userLogin, String reKey) {

		HttpSession session = httpServletRequest.getSession();
		String sessionSMSVerifyName = "SMSVerify" + userLogin.getName();
		String sessionEmailVerifyName = "EmailVerify" + userLogin.getName();
		String SMSVerif = (String) session.getAttribute(sessionSMSVerifyName);
		String EmailVerif = (String) session.getAttribute(sessionEmailVerifyName);

		if (reKey.equals(SMSVerif) || reKey.equals(EmailVerif)) {
			// 创建一个随机的 salt
			String salt = CharacterUtils.getRandomString(8);
			// 加密成密文保存到 password
			String password = MD5Util.MD5(userLogin.getPassword() + salt);
			// 将密文保存在 前端返回的对象中 userLogin
			userLogin.setPassword(password);
			// 将随机盐保存在 前端返回的对象中 userLogin
			userLogin.setSalt(salt);
			logger.info("userLogin:" + userLogin);
			// 将经过修改后前端返回的对象 userLogin 写入数据库中
			userLoginDao.register(userLogin);
			return true;
		}
		return false;
	}

	@Override
	public boolean UserLogin(HttpServletRequest request, HttpServletResponse response, UserLogin userLogin) {

		String name = userLogin.getName();
		String password = userLogin.getPassword();

		UserLogin userLoginDatabase = userLoginDao.queryByName(name);


		// 生成存于 session 和 cookie 里面的 token
		String key = CharacterUtils.getRandomString(8);
		String id = String.valueOf(userLoginDatabase.getId());
		String tokenBase = id + "," + System.currentTimeMillis();
		String token = DesUtil.encrypt(tokenBase, CHARSET, key);

		// 来对前端返回的密码 结合数据库中的 salt 二次加密，在比较两次加密的密文是否相等
		if (MD5Util.MD5(userLogin.getPassword() + userLoginDatabase.getSalt())
				.equals(userLoginDatabase.getPassword())) {

			// 创建 名为  tokenCookie 的cookie，然后将 token 内容写入 cookie 中
			Cookie tokenCookie = new Cookie("name", token);
			Cookie tokenCookieName = new Cookie("userName", name);

			// 设定 cookie 的有效时长
			tokenCookie.setMaxAge(60 * 60 * 24);
			tokenCookieName.setMaxAge(60 * 60 * 24);
			response.addCookie(tokenCookie);
			response.addCookie(tokenCookieName);

			// 生成 session
			// getSession()相当于getSession(false)，getSession(true)则不管当前是否存在Session都创建一个
			HttpSession session = request.getSession(false);
			session.setAttribute("userName", name);
			session.setAttribute("password", password);
			session.setMaxInactiveInterval(60 * 60 * 24);

			// 将 token 加密用的 salt 保存至数据库中
			userLoginDao.updateDes(key, userLoginDatabase.getId());
			System.out.println("登录信息正确");

			return true;
		}

		return false;
	}


}
