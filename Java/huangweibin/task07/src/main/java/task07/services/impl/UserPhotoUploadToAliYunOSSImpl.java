package task07.services.impl;

import com.aliyun.oss.OSSClient;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import task07.controller.UserLoginController;
import task07.dao.UserLoginDao;
import task07.pojo.UserLogin;
import task07.services.UserPhotoUploadStrategy;
import task07.util.aliyun.oss.OSSUtilsByALiYun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */

@Service
public class UserPhotoUploadToAliYunOSSImpl implements UserPhotoUploadStrategy {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	private ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");

	@Autowired
	private UserLoginDao userLoginDao;

	/**
	 *
	 * @param request 请求信息
	 * @param response 响应信息
	 * @param file 文件输入流
	 * @return key 存在于OSS 的键值
	 * @throws IOException IO流异常
	 */
	@Override
	public String userPhotoUploadToOSS(HttpServletRequest request, HttpServletResponse response,
									   MultipartFile file) throws IOException {

		applicationContext.getBean("oSSUtilsByALiYun");

		String key = "";
		String result ="";

				// 获取上传前源文件名、文件大小
		String originalFileName = file.getOriginalFilename();
		Long originalFileSize  = file.getSize();
		logger.info("上传前的文件名：" + originalFileName);

		// 将 multipartfilein 转化为 inputstream流
		CommonsMultipartFile cFile = (CommonsMultipartFile) file;
		DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
		InputStream inputStream = fileItem.getInputStream();

		if (!file.isEmpty()){
			OSSClient ossClient = task07.util.aliyun.oss.OSSUtilsByALiYun.getOSSClient();
			String newFileName = null;
			if (originalFileName.length()>0){
				newFileName = UUID.randomUUID() +"";
			}
			// 将文件上传并获得返回值 key(文件名称)
			key = OSSUtilsByALiYun.uploadObject2OSS(ossClient, inputStream,
					OSSUtilsByALiYun.getBucketName(), originalFileName,newFileName,
					originalFileSize,OSSUtilsByALiYun.getFolder());

		}
		//将文件名写入数据库
		if (!key.equals("")){
			HttpSession userNamesession =request.getSession();
			String userName = (String) userNamesession.getAttribute("userName");

			if (userName.equals(null)){
				logger.info("写入数据库出错，用户名为 null");

			}

			logger.info("userName:" + userName );
			logger.info("key:" + key );

			System.out.println(userLoginDao);
			System.out.println(userLoginDao.queryByName(userName).toString());
			userLoginDao.updateHeadPhoto(userName,key);

			UserLogin userLoginText = userLoginDao.queryByName(userName);
			String databaseHeadPho =  userLoginText.getHead_photo();
			logger.info("写入数据库的key 值为： " + databaseHeadPho);
			// 将 key 值写入数据库


			if (databaseHeadPho.equals(key)){
				logger.info("写入文件一致，上传成功！");
				result = "文件上传成功!";
			}else{
				result = "上传成功，写入数据库不一致!";
			}


		}else {
			logger.info("文件上传失败！");
			result = "文件上传失败!";
		}

		return result;
	}
}
