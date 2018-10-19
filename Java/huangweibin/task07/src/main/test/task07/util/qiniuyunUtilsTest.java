package task07.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task07.util.migrate.MigrateToALi;
import task07.util.migrate.MigrateToQiNiu;
import task07.util.qiniuyun.QiNiuYunUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class qiniuyunUtilsTest {

	private  static ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-qiniuyun.xml");

	private  static ApplicationContext applicationContext1 =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");

	private static final Log logger = LogFactory.getLog("qiniuyunUtilsTest.class");

	// ApplicationContext factory=new FileSystemXmlApplicationContext("classpath:Spring/spring-qiniuyun.xml");


		public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Administrator\\Desktop\\jnshu\\bug.jpg");

		// applicationContext.getBean("qiNiuYunUtils");
		System.out.println("accessKey:" + QiNiuYunUtils.getAccessKey());
		System.out.println("secretKey:" + QiNiuYunUtils.getSecretKey() );
		String bucketNm = "nianyiche";
		// 通过文件来传递
     	// upload(bucketNm,file);

		//通过文件流来上传文件
		InputStream in = new FileInputStream(file);
		QiNiuYunUtils.upload(bucketNm,in,"bug.gif");

		//删除bucket
//      delete(bucketNm, "fdafaf.gif");

		//获取文件信息
		String [] files = {"Fg2KGXu0vLjTQhGuOZhWIxWgVhy4"};
		QiNiuYunUtils.deletes(bucketNm,files);

		//获取所有bucketNm文件信息
		QiNiuYunUtils.getBucketsInfo();


		QiNiuYunUtils.getFileInfo(bucketNm);
	}

	@Test
	public void  isExistFile(){
		applicationContext.getBean("qiNiuYunUtils");
		System.out.println(QiNiuYunUtils.isExistFile("nianyiche" ,"8e125855-d6cd-43c2-981c-7e7007d2bdb9.jpg"));

		// QiNiuYunUtils.isExistFile("nianyiche" ,"8e125855-d6cd-43c2-981c-7e7007d2bdb9.jpg");
	}

	@Test
	public void getFileList(){
		applicationContext.getBean("qiNiuYunUtils");
		System.out.println(QiNiuYunUtils.getFileList("nianyiche").toString());
	}

	@Test
	public void migrate(){
		applicationContext.getBean("qiNiuYunUtils");
		applicationContext1.getBean("oSSUtilsByALiYun");

		MigrateToALi migrateToALi = new MigrateToALi();
		migrateToALi.migrate("AliYun");
	}

	@Test
	public void migrate2(){
		applicationContext.getBean("qiNiuYunUtils");
		applicationContext1.getBean("oSSUtilsByALiYun");

		MigrateToQiNiu migrateToQiNiu = new MigrateToQiNiu();
		migrateToQiNiu.migrate("QiNiu");
	}

}
