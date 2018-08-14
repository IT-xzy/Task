package com.encryption;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.qiniu.util.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class qiniuDownLoad {
    //AccessKey值
    private static String accessKey = "WRiTooy-8OdMnm_7QUdFFnHiCv8ycON4jTacJXWX";
    //SecretKey值
    private static String secretKey = "3nrlTVDu4eGoFm-ZnPyGN8hubqrZplN56HWkIhdW";

    //密钥配置
    private static Auth auth = Auth.create(accessKey,secretKey);


    //获取下载文件路径，即：donwloadUrl
    public static String getDownloadUrl(String targetUrl) {
        String downloadUrl = auth.privateDownloadUrl(targetUrl);
        return downloadUrl;
    }


    //下载
    public static void download1(String targetUrl,String filePath,String fileName) {
        //获取downloadUrl
        String downloadUrl = getDownloadUrl(targetUrl);
        download2(downloadUrl, filePath,fileName);
    }


    //通过发送http get 请求获取文件资源
    private static void download2(String url, String filepath,String fileName) {
        OkHttpClient client = new OkHttpClient();
        System.out.println(url);
        Request req = new Request.Builder().url(url).build();
        Response resp = null;
        try {
            resp = client.newCall(req).execute();
            System.out.println(resp.isSuccessful());
            if(resp.isSuccessful()) {
                ResponseBody body = resp.body();
                InputStream is = body.byteStream();
                byte[] data = readInputStream(is);
                File imgFile = new File(filepath + fileName);          //下载到本地的图片命名
                FileOutputStream fops = new FileOutputStream(imgFile);
                fops.write(data);
                fops.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unexpected code " + resp);
        }
    }


    //读取字节输入流内容
    private static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024 * 2];
        int len = 0;
        try {
            while((len = is.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }


    //测试
    public static void main(String[] args) {
        //构造私有空间的需要生成的下载的链接；
        //格式： http://私有空间绑定的域名/空间下的文件名
        //外链域名下的图片路径
        String targetUrl = "http://pcau07bz8.bkt.clouddn.com/dog.png";
        qiniuDownLoad.download1(targetUrl,"D:/","tets.png");
    }

}
