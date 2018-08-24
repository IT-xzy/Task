package util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

//阿里云OSS迁移数据到七牛OSS
public class ALiOssToQiNiuOssUtil {
	private static final Log log = LogFactory.getLog(ALiOssToQiNiuOssUtil.class);
	//七牛OSS配置
	private String qiNiuAccessKeyId;
	private String qiNiuAccessKeySecret;
	private String qiNiuBucket;
	
	//阿里云OSS配置
	private String aLiBucket;
	private String aLiAccessKeyId;
	private String aLiAccessKeySecret;
	private String aLiEndpoint;

	public void setQiNiuAccessKeyId(String qiNiuAccessKeyId) {
		this.qiNiuAccessKeyId = qiNiuAccessKeyId;
	}

	public void setQiNiuAccessKeySecret(String qiNiuAccessKeySecret) {
		this.qiNiuAccessKeySecret = qiNiuAccessKeySecret;
	}

	public void setQiNiuBucket(String qiNiuBucket) {
		this.qiNiuBucket = qiNiuBucket;
	}

	public void setaLiBucket(String aLiBucket) {
		this.aLiBucket = aLiBucket;
	}

	public void setaLiAccessKeyId(String aLiAccessKeyId) {
		this.aLiAccessKeyId = aLiAccessKeyId;
	}

	public void setaLiAccessKeySecret(String aLiAccessKeySecret) {
		this.aLiAccessKeySecret = aLiAccessKeySecret;
	}

	public void setaLiEndpoint(String aLiEndpoint) {
		this.aLiEndpoint = aLiEndpoint;
	}
	/**
	 * 将阿里云的文件迁移到七牛云
	 */
	public void moveFile(){
		//得到阿里云的文件keys
		List<String> listKeys = getKeys();

		//图片迁移
		Configuration cfg = new Configuration(Zone.zone2());
		Auth auth = Auth.create(qiNiuAccessKeyId, qiNiuAccessKeySecret);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		OSSClient ossClient = new OSSClient(aLiEndpoint, aLiAccessKeyId, aLiAccessKeySecret);
		for (String key : listKeys) {
			//拼接阿里云OSS的文件url
			String remoteSrcUrl = "https://ch0918public." + "oss-cn-shenzhen.aliyuncs.com/" + key;
			log.info(remoteSrcUrl);
			try {
				//remoteSrcUrl 阿里云oss的url
				//BUCKECT_NAME 要把下载的文件放到这里
				//key 要在好的文件的名称
				bucketManager.fetch(remoteSrcUrl, qiNiuBucket, key);

				//删掉阿里云OSS原来的照片
				ossClient.deleteObject(aLiBucket, key);
				log.info(key + ":迁移成功");
			} catch (QiniuException e) {
				log.info(key + ":迁移失败");
				e.printStackTrace();
			}
		}
	    ossClient.shutdown();
	}

	/**
	 * 将阿里云的文件keys放到一个列表里面
	 * @return List<String>
	 */
	private List<String> getKeys() {
		OSSClient ossClient = new OSSClient(aLiEndpoint, aLiAccessKeyId, aLiAccessKeySecret);
		ObjectListing ch0918 = ossClient.listObjects(aLiBucket);
		List<OSSObjectSummary> objectSummaries = ch0918.getObjectSummaries();
		//将key放到一个列表里
		List<String> listKeys = new ArrayList<>();
		for (OSSObjectSummary o : objectSummaries) {
			listKeys.add(o.getKey());
		}
		return listKeys;
	}
}
