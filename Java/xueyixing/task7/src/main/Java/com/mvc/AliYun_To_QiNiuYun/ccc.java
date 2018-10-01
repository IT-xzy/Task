package com.mvc.AliYun_To_QiNiuYun;

import com.google.gson.Gson;
import com.mvc.util.MD5Util;
import com.mvc.util.PhotoAPIQiNiu;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

import static com.mvc.springUtil.QiNiuYunOssAPI.getAuth;

public class ccc {

	private static Logger logger = LoggerFactory.getLogger(PhotoAPIQiNiu.class);
	private static String accessKey = "c";
	private static String secretKey = "K";
	private static String bucket = "w";

	public static String setPhoto(InputStream A,String B)throws Exception{

		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		Auth auth = Auth.create(accessKey,secretKey);
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(A, B, upToken,null,null);
			//解析上传成功的结果
			new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			return B;
		} catch (QiniuException ex) {
			Response s = ex.response;
			logger.info(s.toString());
			return s.toString();
		}
	}
}
