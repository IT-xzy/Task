package strategy;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;

public class OperationQiNiuOSS implements Strategy {
	private static Log log = LogFactory.getLog(OperationQiNiuOSS.class);

	private String accessKey;//七牛云API的密钥Access Key ID
	private String accessKeySecret;//七牛云API的密钥Access Key Secret
	private String bucket;//七牛云上的buckect名称
	private String domain;//七牛云域名

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public void doOperation(String key, InputStream inputStream) {
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone2());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);

		//FileInputStream fis = new FileInputStream(key);
		Auth auth = Auth.create(accessKey, accessKeySecret);
		String upToken = auth.uploadToken(bucket);
		try {
			log.info("七牛迁移程序执行");
			Response response = uploadManager.put(inputStream,key,upToken,null, null);
			//解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			log.info(putRet.key);
			log.info(putRet.hash);
		} catch (QiniuException ex) {
			Response r = ex.response;
			log.info(r.toString());
			try {
				log.info(r.bodyString());
			} catch (QiniuException ex2) {
				//ignore
				log.info(ex2.toString());
			}
		}
	}
}
