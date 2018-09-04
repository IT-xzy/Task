package task07.services.impl;

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
import task07.util.qiniuyun.QiNiuYunUtils;

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
public class UserPhotoUploadToQiNiuYunOSSImpl implements UserPhotoUploadStrategy {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	private ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-qiniuyun.xml");


	@Autowired
	private UserLoginDao userLoginDao;


	@Override
	public String userPhotoUploadToOSS(HttpServletRequest request, HttpServletResponse response,
									   MultipartFile file) throws IOException {

		logger.info("进入service ");
		applicationContext.getBean("qiNiuYunUtils");

		String result ="";

		String originalFileName = file.getOriginalFilename();
		Long originalFileSize  = file.getSize();
		logger.info("上传前的文件名：" + originalFileName);

		// 将 multipartfilein 转化为 inputstream流
		CommonsMultipartFile cFile = (CommonsMultipartFile) file;
		DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
		InputStream inputStream = fileItem.getInputStream();


		if (!file.isEmpty()){

			String newFileName = null;
			if (originalFileName.length()>0){
				newFileName = UUID.randomUUID() + originalFileName.substring(
						originalFileName.lastIndexOf("."));
			}
			// 将文件上传，文件名称就是前面的 newFileName
			QiNiuYunUtils.Result result1 = QiNiuYunUtils.upload(QiNiuYunUtils.getBucket(),
					inputStream, newFileName);

			HttpSession userNameSession = request.getSession();
			String userName = (String) userNameSession.getAttribute("userName");

			if (userName.equals("")){
				logger.info("写入数据库失败，用户名为： null ");
			}

			userLoginDao.updateHeadPhoto(userName ,newFileName);
			// 检验传入的值是否一样
			UserLogin userLoginText = userLoginDao.queryByName(userName);
			String databaseHeadPho =  userLoginText.getHead_photo();
			logger.info("写入数据库的key 值为： " + databaseHeadPho);

			if (databaseHeadPho.equals(newFileName)){
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
