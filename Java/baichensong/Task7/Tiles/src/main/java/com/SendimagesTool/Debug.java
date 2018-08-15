package com.SendimagesTool;

import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

public class Debug {
//    public static void main(String[] args){
//        Configuration cfg = new Configuration(Zone.zone1());
////...其他参数参考类注释
////...生成上传凭证，然后准备上传
//        String accessKey = "6TXc9AIzZ0cWmCbnXPNWOWsf9r2X0rctjvKp-wVn";
//        String secretKey = "DvWrjs1hkOyJdHw-V7cnW4RUY_RWVBq4SmO19qw6";
//        String bucket = "SendimagesTool";
////如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "D:\\linyuner.png";
////默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = null;
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
//        try {
//            //设置断点续传文件进度保存目录
//            FileRecorder fileRecorder = new FileRecorder(localTempDir);
//            UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
//            try {
//                Response response = uploadManager.put(localFilePath, key, upToken);
//                //解析上传成功的结果
//                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//                System.out.println(putRet.key);
//                System.out.println(putRet.hash);
//            } catch (QiniuException ex) {
//                Response r = ex.response;
//                System.err.println(r.toString());
//                try {
//                    System.err.println(r.bodyString());
//                } catch (QiniuException ex2) {
//                    //ignore
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//

    private String accessKey;
    private String secretKey;
    private String bucket;


    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

//----------图片上传方法
    public String sendImg() {
        //构造一个带指定Zone对象的配置类

        //        //...生成上传凭证，然后准备上传
//        String accessKey = "6TXc9AIzZ0cWmCbnXPNWOWsf9r2X0rctjvKp-wVn";
//        String secretKey = "DvWrjs1hkOyJdHw-V7cnW4RUY_RWVBq4SmO19qw6";
//        String bucket = "SendimagesTool";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println("上传凭证" + upToken);
        return upToken;
    }







//    获取文件列表------QiniuList调用
        public BucketManager.FileListIterator getObjectList(String bucketname,String prefix, int limit, String delimiter) {

            return getObjectListReal( bucketname,prefix, limit, delimiter);
        }


        public  BucketManager.FileListIterator getObjectListReal(String bucketname, String prefix, int limit, String delimiter) {
            Configuration cfg = new Configuration(Zone.zone1());
            Auth auth = Auth.create("6TXc9AIzZ0cWmCbnXPNWOWsf9r2X0rctjvKp-wVn", "DvWrjs1hkOyJdHw-V7cnW4RUY_RWVBq4SmO19qw6");
            BucketManager bucketManager = new BucketManager(auth,cfg);

            if (bucketManager != null) {
                System.out.println("bucketManager 不为空");
                //获取到列表 返回到------QiniuList
                return bucketManager.createFileListIterator(bucketname, prefix, limit, delimiter);
            }
            return null;
        }


}
