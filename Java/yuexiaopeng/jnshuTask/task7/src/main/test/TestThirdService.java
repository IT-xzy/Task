import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxpTask6.util.ImageAliyun;
import yxpTask6.util.QNossUtil;
import yxpTask6.util.SMSUtil;
import yxpTask6.util.SendMaiUtil;

import java.util.List;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestThirdService
{
    static Logger logger=Logger.getLogger(TestThirdService.class);
    @Autowired
    private SMSUtil smsUtil;
    @Test
    public void TestSMS()
    {

        String string=smsUtil.getSMS("17744404682");
//        System.out.println((int)((Math.random()*9+1)*1000));

        logger.info("手机号的验证码为："+string);
    }
    @Autowired
    private ImageAliyun imageAliyun;
    @Test
    public void testImg()
    {
        String str=imageAliyun.uploadImg("blue.jpg","C:\\imgFile\\blue.jpg");
        logger.info("上传后的图片链接为 :"+str);
//        Boolean boo=imageAliyun.downloadImg("timg.jpg","c:\\imgFile\\timg.jpg");
//        logger.info("下载图片的结果为: "+boo);
//        List list=imageAliyun.imgList("yxp-picture");
//        System.out.println("oss的文件列表为："+list);
//        String imgPath;
//        for(int i=0;i<list.size();i++)
//        {
//            imgPath="c:\\imgFile\\"+list.get(i).toString();
//            //从阿里云下载到本地
//            imageAliyun.downloadImg(list.get(i).toString(),imgPath);
//            //从本地到七牛云
//            qNossUtil.uploadImage(list.get(i).toString());
//        }

    }
    @Autowired
    SendMaiUtil sendMaiUtil;
    @Test
    public void testMail() throws Exception
    {
        String code=sendMaiUtil.sendCommon("892499056@qq.com");
        logger.info("返回到验证码为"+code);
//        String regex="^\\w+@\\w+\\.\\w+(\\.?|\\w?)\\w+$";
//        Boolean booMoblie=Pattern.matches(regex,"89767676kkkk56@77.cm");
//        logger.info("邮箱匹配到结果为"+booMoblie);
    }
    @Autowired
    QNossUtil qNossUtil;
    @Test
    public void testQiniu() throws Exception
    {
//        http://pe3kqzomh.bkt.clouddn.com/10w%E6%AC%A1%E7%9A%84redis%E8%A1%A8.png
//        http://pe3kqzomh.bkt.clouddn.com/20180202135348237.jpg
        qNossUtil.uploadImage("blue.jpg","C:\\imgFile\\");
        //图片迁移，从七牛云到阿里云
/*        List listImg=qNossUtil.getFileList("eagle.jpg");
        System.out.println(listImg);
        String localImgPath;
        for(int i=0;i<listImg.size();i++){
            //从七牛云下载图片到本地；
            localImgPath="c:\\imgFile\\"+listImg.get(i).toString();
            qNossUtil.getFile(listImg.get(i).toString(),localImgPath);
//            System.out.println(imgPath);
            //将本地图片上传至阿里云
            imageAliyun.uploadImg(listImg.get(i).toString(),localImgPath);
        }*/
    }
}
