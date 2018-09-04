package task07.util.migrate;

import com.aliyun.oss.OSSClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import task07.util.aliyun.oss.OSSUtilsByALiYun;
import task07.util.qiniuyun.QiNiuYunUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0c
 */
public class MigrateToALi implements MigrateStrtegy {

	private static final Log LOGGER = LogFactory.getLog("MigrateToALi.class");
	private InputStream inputStream;

	@Override
	public void migrate(String targetOSS) {

	if (targetOSS.equals("ALiYun")){
		OSSClient ossClient = OSSUtilsByALiYun.getOSSClient();

		// 获取七牛云中目标 bucket的所有文件
		List<String> fileList = QiNiuYunUtils.getFileList("nianyiche");
		if (fileList!=null){
			for (String aFileList : fileList) {
				// photoURL = "http://pdsm406p4.bkt.clouddn.com/" + key;
				String fileURL = "http://pdsm406p4.bkt.clouddn.com/" + aFileList;
				System.out.println("fileURL:" + fileURL);

				// 上传网络流
				try {
					inputStream = new URL(fileURL).openStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ossClient.putObject(OSSUtilsByALiYun.getBucketName(),aFileList, inputStream);
			}
		}else {
			LOGGER.info("所选择的 bucket 为空，请核查！");
		}
		LOGGER.info("文件从七牛云迁移到阿里云成功!");
		ossClient.shutdown();

	}else {
		LOGGER.info("迁移目标有误！");
	}


	}

}

