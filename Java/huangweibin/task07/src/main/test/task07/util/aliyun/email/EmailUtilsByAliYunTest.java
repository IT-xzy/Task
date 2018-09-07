package task07.util.aliyun.email;

import com.aliyuncs.exceptions.ClientException;
import org.junit.Test;
import task07.pojo.UserLogin;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class EmailUtilsByAliYunTest {

	@Test
	public void singletest11() throws ClientException {
		System.out.println("1111111111111111");
		UserLogin userLogin1 = new UserLogin();

		userLogin1.setEmail("1070800859@qq.com");
		userLogin1.setName("zz");

		String code = "1221";
		EmailUtilsByAliYun.getSMSVerify(userLogin1 ,code);
	}
}