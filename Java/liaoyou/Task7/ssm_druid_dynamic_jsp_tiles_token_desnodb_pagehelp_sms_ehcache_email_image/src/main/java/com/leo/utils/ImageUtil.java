package com.leo.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * @Belong: task7
 * @Description: 图片云存储工具类
 * @Author: jk-leo
 * @Date: 2018/9/21 9:50
 */
public class ImageUtil {
	
	
	
	/**
	 * @Desciption: 以二进制流方式上传图片到七牛云
	 * @Param: 图片的二进制流
	 * @Return: 图片名：若上传成功，返回生成的图片名，若上传失败，返回null
	 * @Author: jk-leo
	 * @Date: 2018/9/21 12:49
	 */
	public static String qUploadImage(InputStream imageFileStream){
		
		Properties properties = new Properties();
		try {
			properties.load(ImageUtil.class.getResourceAsStream("/qiniuCloud.properties"));
		} catch (IOException e) {
			System.out.println("读取配置文件失败");
		}
		
		String accessKey = properties.getProperty("accessKey");
		String secretKey = properties.getProperty("secretKey");
		String bucket = properties.getProperty("bucket");

		// 构造一个配置类，配置机房点 华北
		Configuration configuration = new Configuration(Zone.zone1());
		UploadManager uploadManager = new UploadManager(configuration);

		// 生成上传凭证
		Auth auth = Auth.create(accessKey,secretKey);
		String upToken = auth.uploadToken(bucket);
		System.out.println("上传凭证："+upToken);

		// 用UUID生成图片名，感觉不太好
		// String newFileName = UUID.randomUUID().toString()+".jpg";
		// 使用时间戳命名图片
		String newFileName = System.currentTimeMillis()+".jpg";
		String key = newFileName;

		try {
			// mine为媒体文件类型，若为null则默认为未知二进制流
			Response response = uploadManager.put(imageFileStream,key,upToken,null,null);
			// 查看是否上传成功
			System.out.println("上传图片至七牛云是否成功："+response.isOK());

			// 如果存储成功，返回文件名
			if (response.isOK()){
				return  newFileName;
			}

		} catch (QiniuException e) {
			Response response = e.response;
			System.err.println(response.toString());
			try {
				System.err.println(response.bodyString());
			} catch (QiniuException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public static String tUploadImage(InputStream imageFileStream, long contentLength){
		
		Properties properties = new Properties();
		try {
			properties.load(ImageUtil.class.getResourceAsStream("/tengxunCloud.properties"));
		} catch (IOException e) {
			System.out.println("读取配置文件失败");
		}
		
		String accessKey = properties.getProperty("accessKey");
		String secretKey = properties.getProperty("secretKey");
		// bucket名需包含appid
		String bucketName = properties.getProperty("bucketName");

		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cosCredentials = new BasicCOSCredentials(accessKey,secretKey);
		// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
		// 3 生成cos客户端
		COSClient cosClient = new COSClient(cosCredentials,clientConfig);

		ObjectMetadata objectMetadata = new ObjectMetadata();
		// 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
		objectMetadata.setContentLength(contentLength);

		// 设置contenttype默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
		// 默认是 application/octet-stream，腾讯云能自动识别文件类型
		// objectMetadata.setContentType("image/jpeg");

		// 使用时间戳命名图片
		String newFileName = System.currentTimeMillis()+".jpg";
		String key = newFileName;

		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, imageFileStream, objectMetadata);

		// 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
		putObjectRequest.setStorageClass(StorageClass.Standard);

		try {
 			PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
			// putobjectResult会返回文件的etag，etag为上传文件的MD5值
			String etag = putObjectResult.getETag();
			System.out.println("上传文件的MD5值为："+etag);
			if (etag != null){
				return newFileName;
			}
		} catch (CosServiceException e) {
			e.printStackTrace();
		} catch (CosClientException e) {
			e.printStackTrace();
		} finally {
			// 关闭客户端
			cosClient.shutdown();
		}
		return null;
	}
	
}
