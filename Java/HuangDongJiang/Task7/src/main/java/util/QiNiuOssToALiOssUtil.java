package util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//七牛云OSS迁移数据到阿里OSS
public class QiNiuOssToALiOssUtil {
	private static final Log log = LogFactory.getLog(QiNiuOssToALiOssUtil.class);

	//七牛OSS配置
	private String qiNiuAccessKeyId;
	private String qiNiuAccessKeySecret;
	private String qiNiuBucket;
    private String qiuNiuDomain;
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

	public void setQiuNiuDomain(String qiuNiuDomain) {
		this.qiuNiuDomain = qiuNiuDomain;
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

	public void moveFile() {
		//得到七牛云OSS的文件key
		List<String> listKeys = getKeys();

        // 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(aLiEndpoint, aLiAccessKeyId, aLiAccessKeySecret);
        // 上传网络流。
		InputStream inputStream = null;

		for (String listKey : listKeys) {
			//拼接要传输源的url
			String remoteSrcUrl ="http://"+ qiuNiuDomain + "/" +listKey;
			log.info(remoteSrcUrl);
			//传输
			try {
				inputStream = new URL(remoteSrcUrl).openStream();
			} catch (IOException e) {
				log.info(listKey + "：构建流输入流失败！");
				e.printStackTrace();
			}
			PutObjectResult putObjectResult = ossClient.putObject(aLiBucket, listKey, inputStream);
			if (putObjectResult != null) {
				deleteFile(listKey);
			}
			log.info(listKey + " : 传输成功");
		}
        //关闭OSSClient。
		ossClient.shutdown();
	}

	//得到七牛云OSS所有文件的keys
	private List<String> getKeys() {
		List<String> listKeys = new ArrayList<>();
		
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone2());
		Auth auth = Auth.create(qiNiuAccessKeyId, qiNiuAccessKeySecret);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		
        //文件名前缀
		String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
		int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
		String delimiter = "";
        //列举空间文件列表
		BucketManager.FileListIterator fileListIterator = 
				bucketManager.createFileListIterator(qiNiuBucket, prefix, limit, delimiter);
		while (fileListIterator.hasNext()) {
			//处理获取的file list结果
			FileInfo[] items = fileListIterator.next();
			for (FileInfo item : items) {
				listKeys.add(item.key);
			}
		}
		return listKeys;
	}

	//删除单个七牛云OSS文件
	private void deleteFile(String key) {
		Configuration cfg = new Configuration(Zone.zone2());
		
		Auth auth = Auth.create(qiNiuAccessKeyId, qiNiuAccessKeySecret);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		//构造一个带指定Zone对象的配置类
		try {
			bucketManager.delete(qiNiuBucket, key);
		} catch (QiniuException ex) {
			//如果遇到异常，说明删除失败
			log.info(ex.code());
			log.info(ex.response.toString());
		}
	}
}
