package com.leo.client;

import com.leo.service.Login5Service;
import com.leo.service.Student4Service;
import com.leo.service.Student5Service;
import com.leo.utils.VerificationCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.remoting.RemoteConnectFailureException;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.util.NestedServletException;

import javax.servlet.ServletException;
import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @Belong:
 * @Description:
 * @Author: jk-leo
 * @Date: 2018/10/2 22:09
 */
@Configuration
public class ClientConfig {
	
	private static final Logger logger = (Logger) LogManager.getLogger("mylog");
	
	public RmiProxyFactoryBean login5Service1(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/login5Service");
		return rmiProxyFactoryBean;
	}
	
	public RmiProxyFactoryBean login5Service2(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/login5Service");
		return rmiProxyFactoryBean;
	}
	
	@Lazy
	@Bean(name = "log5Service")
	public RmiProxyFactoryBean getLogin5Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number ==1){
			try {
				rmiProxyFactoryBean = login5Service1();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = login5Service2();
			}
		} else {
			try {
				rmiProxyFactoryBean = login5Service2();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = login5Service1();
			}
		}
		return rmiProxyFactoryBean;
	}
	
	public RmiProxyFactoryBean student4Service1(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student4Service");
		return rmiProxyFactoryBean;
	}
	
	public RmiProxyFactoryBean student4Service2(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student4Service");
		return rmiProxyFactoryBean;
	}
	
	@Lazy
	@Bean(name = "student4Service")
	public RmiProxyFactoryBean getStudent4Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number ==1){
			try {
				rmiProxyFactoryBean = student4Service1();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = student4Service2();
			}
		} else {
			try {
				rmiProxyFactoryBean = student4Service2();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = student4Service1();
			}
		}
		return rmiProxyFactoryBean;
	}
	
	public RmiProxyFactoryBean student5Service1(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student5Service");
		return rmiProxyFactoryBean;
	}

	public RmiProxyFactoryBean student5Service2(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student5Service");
		return rmiProxyFactoryBean;
	}
	
	@Lazy
	@Bean(name = "student5Service")
	public RmiProxyFactoryBean getStudent5Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number ==1){
			try {
				rmiProxyFactoryBean = student5Service1();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = student5Service2();
			}
		} else {
			try {
				rmiProxyFactoryBean = student5Service2();
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = student5Service1();
			}
		}
		return rmiProxyFactoryBean;
	}
	
/*	@Lazy
	@Bean(name = "login5Service")
	public RmiProxyFactoryBean login5Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number == 1){
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/login5Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/login5Service");
			}
		} else {
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/login5Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Login5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/login5Service");
			}
		}
		return rmiProxyFactoryBean;
	}

	@Lazy
	@Bean(name = "student4Service")
	public RmiProxyFactoryBean student4Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number == 1){
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student4Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student4Service");
			}
		} else {
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student4Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student4Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student4Service");
			}
		}
		return rmiProxyFactoryBean;
	}
	
	@Lazy
	@Bean(name = "student5Service")
	public RmiProxyFactoryBean student5Service(){
		int number = VerificationCode.getOneNumber();
		RmiProxyFactoryBean rmiProxyFactoryBean;
		if (number == 1){
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student5Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student5Service");
			}
		} else {
			try {
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7788/student5Service");
			} catch (Exception e) {
				logger.error("出现异常，正在切换");
				rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(Student5Service.class);
				rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:7777/student5Service");
			}
		}
		return rmiProxyFactoryBean;
	}*/
}
