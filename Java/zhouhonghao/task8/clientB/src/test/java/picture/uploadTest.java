package picture;

import com.aliyun.oss.OSSClient;
import com.jns.utils.OssDemo;

import java.io.File;

public class uploadTest {
    public static void main(String args[]){
        OssDemo ossDemo=new OssDemo();
        OSSClient ossClient=OssDemo.getOssClient();
        //bucket名    自定义上传文件的名字，   文件在本地的具体路径，\ 用 \\代替
        ossDemo.upload(ossClient,"does", "1.png", new File("D:\\kjk.png"));
    }
}
