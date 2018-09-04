package task07.services.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
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
import task07.services.SMSVerifyServices;
import task07.util.aliyun.sms.SmsUtilsByALiYun;
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
public class SMSVerifyServicesImpl implements SMSVerifyServices {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	private ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");

	@Autowired
	private UserLoginDao userLoginDao;

	// reduis 部分
	private static ApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
	private static RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");

	// 首次获取时间存入缓存失效时长
	private static Long GetVerifyfailureTime = 1000*60*60*24L;





	/**
	 *
	 * @param userLogin 用户信息
	 */
	@Override
	public boolean getSMSVerify(HttpServletRequest httpServletRequest,
							 HttpServletResponse httpServletResponse,
							 UserLogin userLogin)  {

		logger.info("进入service");
		// 初始化获取验证码次数
		int getVerifyTime = 0;
		String userGetSMSVerifyTime = userLogin.getPhone_number() + "GetSMSVerifyTime";

		// Session 部分
		HttpSession session = httpServletRequest.getSession();
		// 单个用户存在 session 中的验证码信息
		String sessionSMSVerifyName = "SMSVerify" + userLogin.getName();
		String verifyStatus = (String) session.getAttribute(sessionSMSVerifyName);
		logger.info("verifyStatus:" + verifyStatus);


		if (verifyStatus == null){

			logger.info("userGetSMSVerifyTime 是否存在：" + redisUtil.get(userGetSMSVerifyTime));
			if (redisUtil.get(userGetSMSVerifyTime) ==null){

				redisUtil.set(userGetSMSVerifyTime,getVerifyTime,GetVerifyfailureTime);
				logger.info("写入redis:" + userGetSMSVerifyTime + redisUtil.get(userGetSMSVerifyTime) );
			}

			logger.info("userGetSMSVerifyTime 是否存在：" + redisUtil.get(userGetSMSVerifyTime));
			// 获取验证码次数少于5次，方可获取验证码
			if ((int)redisUtil.get(userGetSMSVerifyTime)<5){
				// 更新获取验证的次数
				int getVerifyTimeUpdate = (int) redisUtil.get(userGetSMSVerifyTime);
				getVerifyTimeUpdate = getVerifyTimeUpdate + 1;
				redisUtil.set(userGetSMSVerifyTime ,getVerifyTimeUpdate ,GetVerifyfailureTime);
				logger.info("写入redis:" + userGetSMSVerifyTime + redisUtil.get(userGetSMSVerifyTime) );

				// 从前端传回来的数据中获取接受验证码的手机
				String phone_number = userLogin.getPhone_number();
				logger.info("从前端传回的手机号码：" + phone_number);
				// 生成一个随机的四位数作为验证码
				SmsUtilsByALiYun.setNewcode();
				String code = Integer.toString(SmsUtilsByALiYun.getNewcode());
				// 根据前端传回的手机，发送特定的验证码给客户
				SendSmsResponse sendSmsResponse = null;
				try {
					sendSmsResponse = SmsUtilsByALiYun.sendSms(phone_number,code);
				} catch (ClientException e) {
					e.printStackTrace();
				}
				logger.info("短信接口返回的 Code:" + sendSmsResponse.getCode() );
				logger.info("短信接口返回的 getMessage：" + sendSmsResponse.getMessage() );
				logger.info("短信接口返回的 RequestId" + sendSmsResponse.getRequestId() );
				logger.info("短信接口返回的 BizId：" + sendSmsResponse.getBizId() );

				// 将验证码存入 session 中
				// getSession()相当于getSession(false)，getSession(true)则不管当前是否存在Session都创建一个
				HttpSession requestSession = httpServletRequest.getSession(false);

				requestSession.setAttribute(sessionSMSVerifyName ,code);
				requestSession.setMaxInactiveInterval(60 * 3);

				}


			return true;
		}else{
			return  false;}
	}

	@Override
	public String getSMSVerifyJudgment(UserLogin userLogin, BindingResult bindingResult) {

		// 存放 validation 中的所有错误信息
		List<ObjectError> allErrors = null;
		// 从 bindingResult 取出所有的错误信息
		allErrors = bindingResult.getAllErrors();
		// 状态描述
		String SMSStatus = "";

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
					SMSStatus = errorStatus.toString();
				}
			}
		} else if (!bindingResult.hasErrors()){

			// 对 validation 检验没问题的情况下，再进行判断是否已注册
			if (userLoginDao.registerQueryEmail(userLogin.getPhone_number())!= null ){
				SMSStatus ="你输入的手机号码已存在！";
				logger.info("status:" + SMSStatus );
			}else if (userLoginDao.registerQueryName(userLogin.getName())!= null){
				SMSStatus = "你输入的用户名已存在！";
				logger.info("status:" + SMSStatus );
			}
			logger.info("注册输入符合要求");
		}

		return SMSStatus;
	}
}
