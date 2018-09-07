package task07.util.aliyun.oss;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class ossUtilsTest {

	private ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");


	@Test
	public void createStorageObject() {
		OSSUtilsByALiYun.CreateStorageObject();
		System.out.println("创建 对象存储OSS ");
	}

	@Test
	public void uploadFiles() {
		OSSUtilsByALiYun.uploadFiles();
		System.out.println("上传文档至 对象存储OSS ");

	}

	@Test
	public void downloadFile() throws IOException {
		OSSUtilsByALiYun.downloadFile();
		System.out.println("从对象存储OSS 下载文件 ");
	}


	@Test
	public void uploadObject2OSS(){
		OSSClient ossClient = task07.util.aliyun.oss.OSSUtilsByALiYun.getOSSClient();
		String filename = "H:\\琐文杂图\\星空\\psb (1).jpg";
		File file = new File(filename);
		OSSUtilsByALiYun ossUtilsByALiYun = new OSSUtilsByALiYun();
		// String folder = ""

		// OSSUtilsByALiYun.uploadObject2OSS(ossClient,file,OSSUtilsByALiYun.getBucketName()
				// ,filename);

		System.out.println("1111111111111111111111");
	}

	@Test
	public void getFileList(){
		System.out.println(OSSUtilsByALiYun.getFileList("1", "2"));

	}

}
