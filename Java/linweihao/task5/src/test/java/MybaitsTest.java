import com.github.qcloudsms.httpclient.HTTPException;
import com.iceneet.Application;
import com.iceneet.config.QcloudConfig;
import com.iceneet.dao.MemberMapper;
import com.iceneet.dao.UserMapper;
import com.iceneet.service.Jobservice;
import com.iceneet.service.Userservice;
import com.iceneet.untils.*;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ObjectMetadata;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MybaitsTest {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private Jobservice jobservice;

    @Autowired
    private Userservice userservice;
    @Autowired
    private UserMapper userMapper;
    private Logger logger = Logger.getLogger(MybaitsTest.class);

    @Autowired
    private qcloudsms qcloudsms;

    @Autowired
    private qcloudmail qcloudmail;
//
//    @Autowired
//    private qiniuUtils qiniuUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private QcloudConfig qcloudConfig;



    @Test
    public void MybatisTest() throws HTTPException, IOException, TemplateException, MessagingException {
//        qcloudmail.send("651369070@qq.com");
//        System.out.println("freehtml:"+qcloudmail.getMailText("1111"));
//        String salt = MD5Untils.createUUID();
//        System.out.println(salt);
//        String md5 =MD5Untils.generate("password",salt);
//        Boolean t = MD5Untils.verify("password","bc7c49c08da5d40285501b08d7b6ddc7","68e443ef642e4d10852bd35ca61eb956");
//        System.out.println(t);
//    redisTemplate.opsForValue().set("hello2","ss");
//        File localfile = new File("C:\\Users\\admin\\Desktop\\war\\坑6.png");
//        InputStream inputStream = new FileInputStream(localfile);
//        ObjectMetadata meta = new ObjectMetadata();
//        meta.setContentLength(localfile.length());
//        qcloudcos.UploadStream("hello.png",inputStream,meta);
//        TransferContext TransferContext = new TransferContext(false);
//        System.out.println(TransferContext.UploadStream("saywhy.png",inputStream,meta));
//        List<String> imgList = new ArrayList<>();
//        imgList = qiniuUtils.getFileList();
//        for (int i = 0; i < imgList.size() ; i++) {
//            System.out.println(imgList.get(i));
//        }
//        qiniuUtils.fetch();

//        System.out.println("验证结果："+VaildCode.vaild("18819457395","iceneet@163.com","3290"));
//        List<COSObjectSummary> objectSummaries = qcloudcos.GetCosObject();
//        for (COSObjectSummary cosObjectSummary:objectSummaries) {
//            String key = cosObjectSummary.getKey();
//            String url = qcloudcos.getLink()+key;
//            qiniuUtils.fetch(url,key);
//        }
//
//        List<String> imgList = qiniuUtils.getFileList();
//        for (int i = 0; i <imgList.size() ; i++) {
//            String key1 = imgList.get(i);
//            String url2 = qiniuUtils.getLink()+key1;
//            URL urls = new URL(url2);
//            URLConnection uc = urls.openConnection();
//            int fileSize = uc.getContentLength();
//            InputStream inputStream = urls.openStream();
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentLength(fileSize);
//            qcloudcos.UploadStream(key1,inputStream,meta);
//        }

    }
}
