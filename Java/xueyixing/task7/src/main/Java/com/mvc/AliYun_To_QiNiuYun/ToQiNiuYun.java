package com.mvc.AliYun_To_QiNiuYun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.mvc.springUtil.ALiYunOssAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ToQiNiuYun {

	private static Logger logger = LoggerFactory.getLogger(ToQiNiuYun.class);

	private static String endpoint = "o";
	private static String accessKeyId = "";
	private static String accessKeySecret = "";
	private static String bucketName = "";


	public static void main(String[] args)throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		ObjectListing objectListing = ossClient.listObjects(bucketName, null);
		List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
		for (OSSObjectSummary s : sums) {
			logger.info("快看这里");
			System.out.println("\t" + s.getKey());
			OSSObject ossObject = ossClient.getObject(bucketName, s.getKey());
			InputStream is = ossObject.getObjectContent();
			String sk = ccc.setPhoto(is,s.getKey());
			logger.info("key为："+ sk);
		}
	}
}
