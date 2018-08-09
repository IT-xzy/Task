package com.mvc.third_PartyUtil;

import com.google.gson.Gson;
import com.mvc.otherUtil.Md5Util;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class QiNiuYunOssAPI {
	private static Logger logger = LoggerFactory.getLogger(QiNiuYunOssAPI.class);
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

	public String updatePhoto(MultipartFile multipartFile)throws Exception{
		InputStream inputStream = multipartFile.getInputStream();
		String fileName = Md5Util.getMultipartFileMd5(multipartFile);
		return setPhotoToQiNiuYun(inputStream,fileName);
	}

	public String updatePhoto(MultipartFile multipartFile,String fileName)throws Exception{
		InputStream inputStream = multipartFile.getInputStream();
		return setPhotoToQiNiuYun(inputStream,fileName);
	}

	public String updatePhoto(InputStream inputStream)throws Exception{
		ByteArrayOutputStream baos = Md5Util.getFile(inputStream);
		InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
		InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
		String fileName = Md5Util.getFileMD5String(stream1);
		return setPhotoToQiNiuYun(stream2,fileName);
	}

	public String updatePhoto(InputStream inputStream,String fileName)throws Exception{
		return setPhotoToQiNiuYun(inputStream,fileName);
	}

	private String setPhotoToQiNiuYun(InputStream inputStream, String fileName)throws Exception{
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		Auth auth = getAuth();
		String upToken = auth.uploadToken(bucket);
		String fileName1 = fileName+".jpg";
		Response response = uploadManager.put(inputStream, fileName1, upToken, null, null);
		//解析上传成功的结果
		new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

		return "http://pbftvhpus.bkt.clouddn.com/"+fileName1;
	}
}
