package com.mvc.springUtil;

import com.aliyun.oss.OSSClient;
import com.mvc.util.AliYunOSS;
import com.mvc.util.MD5FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ALiYunOssAPI {
	public static Logger logger = LoggerFactory.getLogger(AliYunOSS.class);

	private static String endpoint;
	private static String accessKeyId;
	private static String accessKeySecret;
	private static String bucketName;
	private static String key;

	public ALiYunOssAPI(String endpoint,String accessKeyId,String accessKeySecret,String bucketName){
		this.endpoint = endpoint;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.bucketName = bucketName;
	}

	private static OSSClient getOssClient() {
		return new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	public static String setPhoto(MultipartFile A) throws Exception{
		// 创建OSSClient实例。
		OSSClient ossClient = getOssClient();
		// 上传文件流。
		InputStream inputStream = A.getInputStream();

		ByteArrayOutputStream baos = MD5FileUtil.getFile(inputStream);
		InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
		InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
		key = MD5FileUtil.getFileMD5String(stream1)+".jpg";
		logger.info("图片的名字是："+key);
		ossClient.putObject(bucketName,key,stream2);
		// 关闭OSSClient。
		ossClient.shutdown();
		return key;
	}
}
