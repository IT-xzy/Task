package com.service;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Migration {

    private String accessKey;
    private String secretKey;
    private String bucketqiniu;
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketali;

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setBucketqiniu(String bucketqiniu) {
        this.bucketqiniu = bucketqiniu;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setBucketali(String bucketali) {
        this.bucketali = bucketali;
    }

    public void doalitoqiniu(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        String key;
        String remoteSrcUrl;
        //获取列表
        Map<String,String> urlList = this.doGetAliNameUrlMap();
        for(Map.Entry<String, String> entry : urlList.entrySet()) {
            key = entry.getKey();
            remoteSrcUrl = entry.getValue();
            Auth auth = Auth.create(accessKey, secretKey);
            BucketManager bucketManager = new BucketManager(auth, cfg);
            //抓取网络资源到空间
            try {
                FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl, bucketqiniu, key);
                //System.out.println(fetchRet.hash);
                //System.out.println(fetchRet.key);
                //System.out.println(fetchRet.mimeType);
                //System.out.println(fetchRet.fsize);
            } catch (QiniuException ex) {
                System.err.println(ex.response.toString());
            }
        }
    }

    public  void doqiniutoali() throws IOException {
        // endpoint以杭州为例，其它region请按实际情况填写
        String key;
        String url;
// 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传
        Map<String,String> nameUrl = this.doGetQiniuNameUrlMap();
        for(Map.Entry<String, String> entry : nameUrl.entrySet()) {
            key = entry.getKey();
            url = entry.getValue();
            InputStream inputStream = new URL(url).openStream();
            ossClient.putObject(bucketali, key, inputStream);
        }
// 关闭client
        ossClient.shutdown();
    }


    public Map<String,String> doGetQiniuNameUrlMap(){
        Map<String,String> nameToUrl= new HashMap<String,String>();
        String urlPrefix = "http://p376820e8.bkt.clouddn.com/";
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
//文件名前缀
        String prefix = "";
//每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
//列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucketqiniu, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                //System.out.println(item.key);
                //url.add(urlPrefix + item.key);
                nameToUrl.put(item.key,urlPrefix + item.key);
                //System.out.println(item.hash);
                //System.out.println(item.fsize);
                //System.out.println(item.mimeType);
                //System.out.println(item.putTime);
                //System.out.println(item.endUser);
            }
        }
        return nameToUrl;
    }

    public Map<String,String> doGetAliNameUrlMap(){
        Map<String,String> nameToUrl= new HashMap<String,String>();
        //List<String> url = new ArrayList<String>();
        String urlPrefix = "http://pictureok.oss-cn-shenzhen.aliyuncs.com/";
// 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        final int maxKeys = 1000;
        String nextMarker = null;
        ObjectListing objectListing;
        do {
            objectListing = ossClient.listObjects(new ListObjectsRequest(bucketali).withMarker(nextMarker).withMaxKeys(maxKeys));
            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                //System.out.println(s.getKey());
                //拼接url
                //url.add(urlPrefix + s.getKey());
                nameToUrl.put(s.getKey(),urlPrefix + s.getKey());
            }
            nextMarker = objectListing.getNextMarker();
        } while (objectListing.isTruncated());
// 关闭client
        ossClient.shutdown();
        return nameToUrl;
    }
}
