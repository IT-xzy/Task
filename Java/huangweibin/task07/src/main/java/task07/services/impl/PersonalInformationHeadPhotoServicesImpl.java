package task07.services.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import task07.services.PersonalInformationHeadPhotoServices;
import task07.util.aliyun.oss.OSSUtilsByALiYun;
import task07.util.qiniuyun.QiNiuYunUtils;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
@Service
public class PersonalInformationHeadPhotoServicesImpl implements PersonalInformationHeadPhotoServices {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PersonalInformationHeadPhotoServicesImpl.class);
	@Override
	public String getHeadPhotoURL(String key) {
		String photoURL = null;
		logger.info("key ：" + key );
		if (key != null){
			if (OSSUtilsByALiYun.isExistFile(key)){
				photoURL = "https://" + OSSUtilsByALiYun.getBucketName() + ".oss-cn-shenzhen.aliyuncs.com/"  + key;
				logger.info("photoURL :" + photoURL);
				System.out.println("获取阿里云URL成功");

			}
			if (QiNiuYunUtils.isExistFile(QiNiuYunUtils.getBucket(),key)){
				photoURL = "http://pdsm406p4.bkt.clouddn.com/" + key;
				logger.info("photoURL :" + photoURL);
				System.out.println("获取七牛云URL成功");
		}
	}
	return photoURL;
	}
}
