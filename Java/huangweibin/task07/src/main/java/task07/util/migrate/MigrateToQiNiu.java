package task07.util.migrate;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FetchRet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import task07.util.aliyun.oss.OSSUtilsByALiYun;
import task07.util.qiniuyun.QiNiuYunUtils;

import java.io.InputStream;
import java.util.List;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class MigrateToQiNiu implements MigrateStrtegy {
	private static final Log LOGGER = LogFactory.getLog("MigrateToQiNiu.class");
	private InputStream inputStream;

	@Override
	public void migrate(String targetOSS) {

		if (targetOSS.equals("QiNiuYun")){
			BucketManager bucketManager =QiNiuYunUtils.getBucketManager();
			List<String> fileList = OSSUtilsByALiYun.getFileList("ALiYun","QiNiu");
			if (fileList!=null){
				LOGGER.info("获取文件列表：");
				for (String aFileList : fileList){
					// photoURL = "https://" + OSSUtilsByALiYun.getBucketName() +
					// 		".oss-cn-shenzhen.aliyuncs.com/"  + key;

					String fileURL = "https://" + OSSUtilsByALiYun.getBucketName() +
							".oss-cn-shenzhen.aliyuncs.com/" + aFileList;
					LOGGER.info("fileURL:"  + fileURL);

					// 抓取网络资源
					try {
						FetchRet fetchRet = bucketManager.fetch(fileURL,
								QiNiuYunUtils.getBucket(), aFileList);
						LOGGER.info(fetchRet.hash);
						LOGGER.info(fetchRet.key);
						LOGGER.info(fetchRet.mimeType);
						LOGGER.info(fetchRet.fsize);

					} catch (QiniuException ex) {
						System.err.println(ex.response.toString());
					}
				}

			}else {
				LOGGER.info("所选择的 bucket 为空，请核查！");
			}
			LOGGER.info("文件成功从阿里云迁移到七牛云");
		}else {
			LOGGER.info("迁移目标有误！");
		}

		}

}
