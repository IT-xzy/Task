package task07.services;

import org.springframework.validation.BindingResult;
import task07.pojo.UserLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public interface EmailByAliyunServices {

	boolean getEmailVerify(HttpServletRequest httpServletRequest,
					  HttpServletResponse httpServletResponse,
					  UserLogin userLogin);

	String getEmailVerifyJudgment(UserLogin userLogin,BindingResult bindingResult);

}
