package com.mvc.third_PartyUtil;

import com.aliyun.oss.OSSClient;
import com.mvc.otherUtil.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALiYunOssAPI {
	public static Logger logger = LoggerFactory.getLogger(ALiYunOssAPI.class);

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

	public String updatePhoto(MultipartFile multipartFile)throws IOException{
		InputStream inputStream = multipartFile.getInputStream();
		String fileName = Md5Util.getMultipartFileMd5(multipartFile);
		return setPhotoToAliYun(inputStream,fileName);
	}

	public String updatePhoto(MultipartFile multipartFile,String fileName)throws IOException {
		InputStream inputStream = multipartFile.getInputStream();
		return setPhotoToAliYun(inputStream,fileName);
	}

	public String updatePhoto(InputStream inputStream)throws Exception{
		ByteArrayOutputStream baos = Md5Util.getFile(inputStream);
		InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
		InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
		String fileName = Md5Util.getFileMD5String(stream1);
		return setPhotoToAliYun(stream2,fileName);
	}

	public String updatePhoto(InputStream inputStream,String fileName){
		return setPhotoToAliYun(inputStream,fileName);
	}

	private String setPhotoToAliYun(InputStream inputStream,String fileName){
		// 创建OSSClient实例。
		OSSClient ossClient = getOssClient();

		String fileName1 = fileName+".jpg";
		ossClient.putObject(bucketName,fileName1,inputStream);
		// 关闭OSSClient。
		ossClient.shutdown();
		return "https://white-star-777.oss-cn-hangzhou.aliyuncs.com/"+fileName1;
	}
}
