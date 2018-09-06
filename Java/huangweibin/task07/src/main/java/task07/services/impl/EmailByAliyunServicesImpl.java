package task07.services.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import task07.controller.UserLoginController;
import task07.dao.UserLoginDao;
import task07.pojo.UserLogin;
import task07.services.EmailByAliyunServices;
import task07.util.aliyun.email.EmailUtilsByAliYun;
import task07.util.redis.RedisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */

@Service
public class EmailByAliyunServicesImpl implements EmailByAliyunServices {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	private ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");

	@Autowired
	private UserLoginDao userLoginDao;

	// redis 部分
	private static ApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
	private static RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");

	// 首次获取时间存入缓存失效时长
	private static Long GetVerifyfailureTime = 1000*60*60*24L;



	/**
	 *
	 * @param userLogin 用户信息
	 * 需要传入的参数：Email 邮箱地址
	 * 需要传入的参数：name 用户名称
	 *
	 */
	@Override
	public boolean getEmailVerify(HttpServletRequest httpServletRequest,
							 HttpServletResponse httpServletResponse,
							 UserLogin userLogin) {

		logger.info("进入service");
		// 初始化验证码次数
		int getVerifyTime = 0;
		String userGetEmailVerifyTime = userLogin.getPhone_number() + "GetEmailVerifyTime";

		// Session 部分
		HttpSession session = httpServletRequest.getSession();
		// 单个用户存在 session 中的验证码信息
		String sessionSMSVerifyName = "EmailVerify" + userLogin.getName();
		String verifyStatus = (String) session.getAttribute(sessionSMSVerifyName);
		logger.info("verifyStatus:" + verifyStatus);

		if (verifyStatus == null){

			// logger.info("userGetEmailVerifyTime 是否存在：" + redisUtil.get(userGetEmailVerifyTime));
			if (redisUtil.get(userGetEmailVerifyTime) ==null){

				boolean success ;
				success = redisUtil.set(userGetEmailVerifyTime,getVerifyTime,GetVerifyfailureTime);
				logger.info("success :" + success);
				logger.info("写入redis：" + userGetEmailVerifyTime + redisUtil.get(userGetEmailVerifyTime));
			}

			logger.info("userGetEmailVerifyTime 是否存在：" + redisUtil.get(userGetEmailVerifyTime));
			if ((int)redisUtil.get(userGetEmailVerifyTime) < 5 ){
				int getVerifyTimeUpdate = (int) redisUtil.get(userGetEmailVerifyTime);
				getVerifyTimeUpdate = getVerifyTimeUpdate + 1;
				redisUtil.set(userGetEmailVerifyTime,getVerifyTimeUpdate,GetVerifyfailureTime);
				logger.info("写入redis“：" + userGetEmailVerifyTime + redisUtil.get(userGetEmailVerifyTime));

				// 前端返回的邮箱
				String email = userLogin.getEmail();
				logger.info("从前端传回的邮箱地址：" + email);
				// 前端返回的用户名
				String name = userLogin.getName();
				logger.info("从前端传回的用户名：" + name);
				// 生成一个随机的四位数
				int codeInt = (int) ((Math.random()*9999)+100);
				String code = Integer.toString(codeInt);
				// 将用户信息及验证码传至工具类中
				EmailUtilsByAliYun.getSMSVerify(userLogin,code);


				// 将验证码存入 session 中
				// getSession()相当于getSession(false)，getSession(true)则不管当前是否存在Session都创建一个
				HttpSession requestSession = httpServletRequest.getSession(false);

				requestSession.setAttribute(sessionSMSVerifyName,code);
				requestSession.setMaxInactiveInterval(60 * 3);
			}
			return true;
		}else {
			return  false;
		}

	}

	@Override
	public String getEmailVerifyJudgment(UserLogin userLogin,BindingResult bindingResult) {

		// 存放 validation 中的所有错误信息
		List<ObjectError> allErrors = null;
		// 从 bindingResult 取出所有的错误信息
		allErrors = bindingResult.getAllErrors();
		// 状态描述
		String EmailStatus = "";

		// 对 validation 检验有问题的情况下
		if (bindingResult.hasErrors()){
			for (ObjectError objectError :allErrors){
				// validation 中的错误描述
				StringBuilder errorStatus = new StringBuilder();
				// 因为没有错误的值为 null ,此处过滤掉 null
				if (objectError.getDefaultMessage() != null){
					// 输出所有的错误信息
					logger.info(objectError.getDefaultMessage());
					errorStatus.append(objectError.getDefaultMessage()).append("\n");
					EmailStatus = errorStatus.toString();
				}
			}
		} else if (!bindingResult.hasErrors()){

			// 对 validation 检验没问题的情况下，再进行判断是否已注册
			if (userLoginDao.registerQueryEmail(userLogin.getEmail())!= null ){
				EmailStatus ="你输入的账户已存！";
				logger.info("status:" + EmailStatus );
			}else if (userLoginDao.registerQueryName(userLogin.getName())!= null){
				EmailStatus = "你输入的用户名已存在！";
				logger.info("status:" + EmailStatus );

			}
			logger.info("注册输入符合要求");
		}

		return EmailStatus;

	}


}
