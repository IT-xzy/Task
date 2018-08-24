package strategy;
import com.aliyun.oss.OSSClient;
import java.io.InputStream;

public class OperrationAliOSS implements Strategy {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucket;

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	@Override
	public void doOperation(String key, InputStream inputStream) {
    // 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    // 上传文件流。
		ossClient.putObject(bucket, key, inputStream);
    // 关闭OSSClient。
		ossClient.shutdown();
	}
}
