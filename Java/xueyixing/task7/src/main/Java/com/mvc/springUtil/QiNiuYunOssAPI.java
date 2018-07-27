package com.mvc.springUtil;

import com.google.gson.Gson;
import com.mvc.util.MD5FileUtil;
import com.mvc.util.MD5Util;
import com.mvc.util.PhotoAPIQiNiu;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class QiNiuYunOssAPI {

	private static Logger logger = LoggerFactory.getLogger(PhotoAPIQiNiu.class);
	private static String accessKey;
	private static String secretKey;
	private static String bucket;

	public QiNiuYunOssAPI(String accessKey,String secretKey,String bucket){
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.bucket = bucket;
	}

	public static Auth getAuth(){
		return Auth.create(accessKey, secretKey);
	}


	public static String setPhoto(MultipartFile A)throws Exception{

		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		InputStream SY = A.getInputStream();
		String key = MD5Util.getMultipartFileMd5(A)+".jpg";
		logger.info(key);
		Auth auth = getAuth();
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(SY, key, upToken,null,null);
			//解析上传成功的结果
			new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			String photoKey = "http://pbftvhpus.bkt.clouddn.com"+key;
			logger.info(key);
			return photoKey;
		} catch (QiniuException ex) {
			Response r = ex.response;
			logger.info(r.toString());
			try {
				logger.info(r.bodyString());
				return r.bodyString();
			} catch (QiniuException ex2) {
				//ignore
				logger.info(ex2.toString());
				return ex2.toString();
			}
		}
	}
}
