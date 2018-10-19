package task07.util.aliyun.oss;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */

public class OSSUtilsByALiYun {


	// Endpoint以深圳为例，其它Region请按实际情况填写。
	private static String endpoint;
	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，
	//  请登录 https://ram.console.aliyun.com 创建RAM账号。
	private static String accessKeyId;
	// 创建OSSClient实例。
	private static String accessKeySecret;

	private static String bucketName;

	private static final Log logger = LogFactory.getLog("OSSUtilsByALiYun.class");

	// private String filedir = "data/";

	//阿里云API的文件夹名称
	private static String folder;


	/**
	 * 获取阿里云OSS客户端对象
	 *
	 * @return ossClient
	 */
	public static OSSClient getOSSClient() {
		return new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 官方测试
	 * 建立阿里云OSS客户端对象
	 */
	public static void CreateStorageObject() {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 创建存储空间。
		ossClient.createBucket(bucketName);
		// 关闭OSSClient。
		ossClient.shutdown();
	}


	/**
	 * 官方测试
	 * 上传文件至阿里云OSS客户端对象
	 */
	public static void uploadFiles() {
		String objectName = "HelloOss";
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件。
		String content = "Hello OSS";
		ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
		// 关闭OSSClient。
		ossClient.shutdown();

	}

	/**
	 * 官方测试
	 * 下载文件至阿里云OSS客户端对象
	 */
	public static void downloadFile() throws IOException {
		String objectName = "HelloOss";
		// 	创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
		InputStream content = ossObject.getObjectContent();
		if (content != null) {
			// BufferedReader 缓冲字符输入流 ，InputStreamReader 是将字节流转向字符流
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			while (true) {
				// 读取缓冲字符输入流
				String line = reader.readLine();
				if (line == null) break;
				System.out.println("\n" + line);
			}
			// 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
			content.close();
		}

		// 下载到本地
		ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("D:\\soft\\wjs.txt"));

		// 关闭OSSClient。
		ossClient.shutdown();
	}


	/**
	 * 创建存储空间
	 *
	 * @param ossClient  OSS连接
	 * @param bucketName 存储空间
	 * @return
	 */
	public static String createBucketName(OSSClient ossClient, String bucketName) {
		//存储空间
		final String bucketNames = bucketName;
		if (!ossClient.doesBucketExist(bucketName)) {
			//创建存储空间
			Bucket bucket = ossClient.createBucket(bucketName);
			logger.info("创建存储空间成功");
			return bucket.getName();
		}
		return bucketNames;
	}


	/**
	 * 删除存储空间buckName
	 *
	 * @param ossClient  oss对象
	 * @param bucketName 存储空间
	 */
	public static void deleteBucket(OSSClient ossClient, String bucketName) {
		ossClient.deleteBucket(bucketName);
		logger.info("删除" + bucketName + "Bucket成功");
	}

	/**
	 * 创建模拟文件夹
	 *
	 * @param ossClient  oss连接
	 * @param bucketName 存储空间
	 * @param folder     模拟文件夹名如"qj_nanjing/"
	 * @return 文件夹名
	 */
	public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
		//文件夹名
		final String keySuffixWithSlash = folder;
		//判断文件夹是否存在，不存在则创建
		if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
			//创建文件夹
			ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
			logger.info("创建文件夹成功");
			//得到文件夹名
			OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
			String fileDir = object.getKey();
			return fileDir;
		}
		return keySuffixWithSlash;
	}

	/**
	 * 根据key删除OSS服务器上的文件
	 *
	 * @param ossClient  oss连接
	 * @param bucketName 存储空间
	 * @param folder     模拟文件夹名 如"qj_nanjing/"
	 * @param key        Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
	 */
	public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
		ossClient.deleteObject(bucketName, folder + key);
		logger.info("删除" + bucketName + "下的文件" + folder + key + "成功");
	}

	/**
	 * 上传图片至OSS
	 *
	 * @param ossClient  oss连接
	 * @param inputStream       上传文件（文件全路径如：D:\\image\\cake.jpg）
	 * @param bucketName 存储空间
	 * @param folder     模拟文件夹名 如"qj_nanjing/"
	 * @return String key值  （修改前返回的唯一MD5数字签名）
	 */
	public static String uploadObject2OSS(OSSClient ossClient, InputStream inputStream,
										  String bucketName, String originalFileName ,
										  String newFileName,
										  Long originalFileSize,String folder) {

		String resultStr = null;
		String key = "";
		try {
			//以输入流的形式上传文件
			InputStream is = inputStream;

			//文件名
			// String fileName = file.getName();
			String fileName = originalFileName;
			System.out.println("fileName:" + fileName);
			//文件大小
			// Long fileSize = file.length();
			Long fileSize = originalFileSize;

			//创建上传Object的Metadata
			ObjectMetadata metadata = new ObjectMetadata();
			//上传的文件的长度
			metadata.setContentLength(is.available());
			//指定该Object被下载时的网页的缓存行为
			metadata.setCacheControl("no-cache");
			//指定该Object下设置Header
			metadata.setHeader("Pragma", "no-cache");
			//指定该Object被下载时的内容编码格式
			metadata.setContentEncoding("utf-8");
			//文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。
			// 如果用户没有指定则根据Key或文件名的扩展名生成，
			//如果没有扩展名则填默认值application/octet-stream
			metadata.setContentType(getContentType(fileName));
			//指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
			metadata.setContentDisposition("filename/filesize=" + newFileName + "/" + fileSize + "Byte.");
			//上传文件   (上传文件流的形式)
			key = folder + newFileName + fileName.substring(fileName.lastIndexOf("."));
			logger.info("key:" + key );
			PutObjectResult putResult = ossClient.putObject(bucketName, key , is, metadata);
			//解析结果

			resultStr = putResult.getETag();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
		}


		return key;
	}


	/**
	 * 通过文件名判断并获取OSS服务文件上传时文件的contentType
	 *
	 * @param fileName 文件名
	 * @return 文件的contentType
	 */
	public static String getContentType(String fileName) {
		//文件的后缀名
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));
		if (".bmp".equalsIgnoreCase(fileExtension)) {
			return "image/bmp";
		}
		if (".gif".equalsIgnoreCase(fileExtension)) {
			return "image/gif";
		}
		if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
			return "image/jpeg";
		}
		if (".html".equalsIgnoreCase(fileExtension)) {
			return "text/html";
		}
		if (".txt".equalsIgnoreCase(fileExtension)) {
			return "text/plain";
		}
		if (".vsd".equalsIgnoreCase(fileExtension)) {
			return "application/vnd.visio";
		}
		if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
			return "application/vnd.ms-powerpoint";
		}
		if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
			return "application/msword";
		}
		if (".xml".equalsIgnoreCase(fileExtension)) {
			return "text/xml";
		}
		//默认返回类型
		return "image/jpeg";
	}



	// /**
	//  * 获得url链接
	//  *
	//  * @param key
	//  * @return
	//  */
	// public String getUrl(String key) {
	// 	// 设置URL过期时间为10年  3600l* 1000*24*365*10
	// 	Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
	// 	// 生成URL
	// 	OSSClient ossUtilsByALiYun = OSSUtilsByALiYun.getOSSClient();
	// 	URL url = ossUtilsByALiYun.generatePresignedUrl(bucketName, key, expiration);
	// 	if (url != null) {
	// 		return url.toString();
	// 	}
	// 	return null;
	// }
	//
	//
	// /**
	//  * 获得图片路径
	//  *
	//  * @param fileUrl
	//  * @return
	//  */
	// public String getImgUrl(String fileUrl) {
	// 	if (!StringUtils.isEmpty(fileUrl)) {
	// 		String[] split = fileUrl.split("/");
	// 		return this.getUrl(this.filedir + split[split.length - 1]);
	// 	}
	// 	return null;
	// }

	/**
	 *
	 * @param key 文件键值
	 * @return true 存在
	 */
	public static boolean isExistFile (String key) {
		OSSClient ossClient = OSSUtilsByALiYun.getOSSClient();
		if (ossClient.doesObjectExist(OSSUtilsByALiYun.getBucketName(), key)) {
			return true;
		} else {
			return false;
		}
	}


	public static List<String> getFileList(String originalOSS ,String newOSS){
		// KeyPrefix，则列举包含指定前缀的文件。
		List<String> fileList = new ArrayList<>();
 		String KeyPrefix = "";

		OSSClient ossClient = OSSUtilsByALiYun.getOSSClient();
		ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
		List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
		for (OSSObjectSummary s : sums) {
			System.out.println("\t" + s.getKey());
			fileList.add(s.getKey());
			}

		ossClient.shutdown();
		return fileList;


	}



	public static String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		OSSUtilsByALiYun.endpoint = endpoint;
	}

	public static String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		OSSUtilsByALiYun.accessKeyId = accessKeyId;
	}

	public static String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		OSSUtilsByALiYun.accessKeySecret = accessKeySecret;
	}

	public static String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		OSSUtilsByALiYun.bucketName = bucketName;
	}

	public static String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		OSSUtilsByALiYun.folder = folder;
	}




}
