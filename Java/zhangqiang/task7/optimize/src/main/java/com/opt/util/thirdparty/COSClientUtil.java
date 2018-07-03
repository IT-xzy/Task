package com.opt.util.thirdparty;

import com.opt.util.safe.COSClientCredentials;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.util.*;

/**
 * @class:COSClientUtil
 * @descript:java使用TencentCOS存储对象上传图片
 * @date:2018年6月26日 下午15:59:08
 * @author Mr.Zhang
 */
public class COSClientUtil {

    //腾讯云API的秘钥ID accessKey
    private static String SECRET_ID;
    //腾讯云API的秘钥 secretKey
    private static String SECRET_KEY;
    //腾讯云对象储存 区域名
    private static String BUCKET_ACER;
    //腾讯云对象储存 储存桶Name
    private static String BACKET_NAME;
    //储存位置
    private static String FOLDER;

    private static Logger logger = Logger.getLogger(COSClientUtil.class);

    //初始化属性
    static{
        SECRET_ID = COSClientCredentials.SECRET_ID;
        SECRET_KEY = COSClientCredentials.SECRET_KEY;
        BUCKET_ACER = COSClientCredentials.BUCKET;
        BACKET_NAME = COSClientCredentials.BUCKET_NAME;
        FOLDER = COSClientCredentials.FOLDER;
    }


    /**
     * 获取腾讯云客户端对象
     * @return ossClient
     */
    public static COSClient getConClient(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(BUCKET_ACER));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = BACKET_NAME;

        return cosclient;
    }

    /**
     * 上传文件
     * @return Map<String,Object> map
     */
    public Map updateFile(File file){

        COSClient cosClient = getConClient();

        String fileName = file.getName();

        String key = FOLDER + System.currentTimeMillis() + fileName;

        System.out.println(key);
//
//        PutObjectRequest  putObjectRequest  = new PutObjectRequest(BACKET_NAME, key , file);
//        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        PutObjectResult putObjectResult = null;


        putObjectResult = cosClient.putObject(BACKET_NAME, key, file);

        String resultStr = putObjectResult.getETag();

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("url",resultStr);
        map.put("key",key);

        cosClient.shutdown();

        return map;
    }


    /**
     * 获取腾讯云客户端对象
     * @return ossClient
     */
    public String getUrl(){

        return "";
    }


    /**
     * 获取腾讯云桶 所有文件
     * @return ObjectListing
     */
    public static ObjectListing listObjects() throws CosClientException, CosServiceException {

            COSClient cosClient  = COSClientUtil.getConClient();

            // bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            String bucketName = BACKET_NAME;

            // 获取 bucket 下成员（设置 delimiter）
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();

            listObjectsRequest.setBucketName(bucketName);

            // 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
            listObjectsRequest.setPrefix("");

            // 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
//            listObjectsRequest.setDelimiter("/");

            // 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
            listObjectsRequest.setMarker("");

            // 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
            listObjectsRequest.setMaxKeys(100);

            ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);

            // 获取下次 list 的 marker
            String nextMarker = objectListing.getNextMarker();

            // 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
            boolean isTruncated = objectListing.isTruncated();

            List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();

            for (COSObjectSummary cosObjectSummary : objectSummaries) {
                // 文件路径
                String key = cosObjectSummary.getKey();
                // 获取文件长度
                long fileSize = cosObjectSummary.getSize();
                // 获取文件ETag
                String eTag = cosObjectSummary.getETag();
                // 获取最后修改时间
                Date lastModified = cosObjectSummary.getLastModified();
                // 获取文件的存储类型
                String StorageClassStr = cosObjectSummary.getStorageClass();
            }

            return objectListing;
    }


    /**
     * 获取腾讯云桶 所有文件
     * @return List<String>
     */
    public static List<String> getObjectListingKey(){

        ObjectListing objectListing = listObjects();

        List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
        List<String> keys = new ArrayList<>();

        for(COSObjectSummary cosObject  : cosObjectSummaries){
            keys.add(cosObject.getKey());
            System.out.println(cosObject.getKey());
        }
        return keys;
    }

    @Test
    public void test(){


//        File file = new File("F:\\picture\\head_ico\\24.png");
//
//        Map map = updateFile(file);
//        System.out.println(map.get("url"));
//        System.out.println(map.get("key"));

          ObjectListing objectListing = listObjects();

          List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();

          for(COSObjectSummary cosObject  : cosObjectSummaries){
              System.out.println(cosObject.getKey());
          }

//        /**
//         * find jar file
//         */
//        String LOCATION = "";
//        String URLLOCATION = "";
//        try {
//            LOCATION =COSClientUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
//            URLLOCATION =  URLDecoder.decode(LOCATION, "UTF-8");
//            logger.debug("** loc=" + LOCATION + "; URLLoc=" + URLLOCATION);
//        } catch (UnsupportedEncodingException e) {
//            logger.error("get LOCATION error", e);
//        }



    }


}
