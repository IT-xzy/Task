package jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.dao.RestUserMapper;
import jnshu.dao.StudentMapper;
import jnshu.model.RestUser;
import jnshu.service.ApiService;
import jnshu.tool.api.*;
import jnshu.tool.redis.RedisTakes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApiServiceImpl implements ApiService {
    private static Logger logger = Logger.getLogger (String.valueOf (ApiServiceImpl.class));
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RestUserMapper userMapper;
    @Autowired
    RedisTakes redisTakes;
    long timeStamp = System.currentTimeMillis ();
    @Autowired
    Sms sms;
    @Autowired
    Email emailServe;

    @Autowired
    Cos cos;
    @Autowired
    Oss oss;


    /**
     * @param telNum 手机号码
     * @return 0为发送失败，1为发送成功，2为操作太频繁
     */
    @Override
    public int checkTelNum(String telNum) {
        logger.info ("进入apiServer：" + telNum);
        if (telNum == null || telNum.length () < 10 || telNum.length () > 11 || !telNum.matches ("[0-9]+")) {
            logger.info ("电话号码不规范");
            return 0;
        }

        String rs = (String) redisTakes.get (telNum);
        logger.info ("缓存里的验证码加时间戳加次数为：" + rs);
        if (rs != null) {
//          获取时间戳
            String i = (rs.split (","))[1];
            long ii = timeStamp - Long.valueOf (i);
            logger.info ("两次发送间隔时间为：" + ii / 1000 + "秒");

            if (ii < 30 * 100) {
                logger.info ("两次发送间隔少于30秒，操作太频繁");
                return 2;
            }
        }

//            产生一个四位数
        Random ra = new Random ();
        String num = String.valueOf (ra.nextInt (8999) + 1000);

        //        发送手机注册验证码
        int s = sms.smsUtil (telNum, num);
        logger.info ("手机验证码发送结果：" + s);

        if (s == 0) {
            logger.info ("发送不成功");
            return 0;
        }


        String numTime = num + "," + timeStamp + "," + 1;
//        存进缓存
        redisTakes.set (telNum, numTime, 50 * 60);
        logger.info ("缓存进去的key为：" + telNum + "存进去的值为" + numTime);
        return 1;
    }

    /**
     * 手机注册验证
     *
     * @param restUser 注册信息
     * @return 0为验证码错误，1为验证通过，2为同名注册冲突，3为错误次数过多，4为注册信息不完整
     */
    @Override
    public int phoneRegisterCheck(RestUser restUser) {
        logger.info ("进入注册信息验证：" + JSON.toJSONString (restUser));
        String code = restUser.getCode ();
        String phone = restUser.getPhone ();
        String name = restUser.getName ();
        String pwd = restUser.getPwd ();

        if (phone == null || name == null || pwd == null || pwd.isEmpty ()) {
            logger.info ("注册信息不完整");
            return 4;
        }

//       验证码是否为空
        if (code == null || code.isEmpty ()) {
            logger.info ("验证码为空,返回0");
            return 0;
        }

//            从缓存取出验证码
        String code1 = (String) redisTakes.get (phone);
        logger.info ("缓存里的验证码+时间戳+次数：" + code1);

//        判断缓存里是否存在验证码
        if (code1 == null || code1.isEmpty ()) {
            logger.info ("验证码不能为空,返回0");
            return 0;
        }

        String[] sl = code1.split (",");
        String c0 = sl[0];

        logger.info ("截取的数组值为" + JSON.toJSONString (sl) + c0);
        int c2 = Integer.valueOf (sl[2]);
        String c1 = sl[1];

//        判断是否输入错误的次数过多
        if (c2 > 8) {
            logger.info ("验证码输入错误次数过多，返回3");
            return 3;
        }

//        判断验证码是否一致，不一致则错误次数加1
        if (!c0.equals (code)) {
            String code0 = c0 + "," + c1 + "," + (c2 + 1);
            redisTakes.set (phone, code0, 2 * 60);
            logger.info ("验证码不相等，返回0，错误次数加一");
            return 0;
        }

        RestUser ru = userMapper.selectByName (restUser.getName ());
        logger.info ("数据库查询出来的值为" + JSON.toJSONString (ru));

//        判断是否存在同名注册
        if (ru == null) {
            logger.info ("不存在同名，返回1");
            return 1;
        }

        logger.info ("存在同名，返回2");
        return 2;
    }

    /**
     * 邮箱检查
     *
     * @param email 要注册的邮箱
     * @return 0为发送失败，1为发送成功，2为操作太频繁
     */
    @Override
    public int checkEmail(String email) {
        logger.info ("进入邮箱检查：" + email);
        if (email == null || email.length () < 5 || !email.matches (".*@.*")) {
            logger.info ("邮箱不规范");
            return 0;
        }

        String rs = (String) redisTakes.get (email);
        logger.info ("缓存里的验证码加时间戳加次数为：" + rs);
        if (rs != null) {
//          获取时间戳
            String i = (rs.split (","))[1];
            long ii = timeStamp - Long.valueOf (i);
            logger.info ("两次发送间隔时间为：" + ii / 1000 + "秒");

            if (ii < 60 * 1000) {
                logger.info ("两次发送间隔少于30秒，操作太频繁");
                return 2;
            }
        }

//            产生一个四位数
        Random ra = new Random ();
        String num = String.valueOf (ra.nextInt (8999) + 1000);

        //        发送邮箱注册验证码
        int s = emailServe.sample (num, email);
        logger.info ("验证码发送结果：" + s);

        if (s == 0) {
            logger.info ("发送不成功");
            return 0;
        }

//验证码+时间戳+次数
        String numTime = num + "," + timeStamp + "," + 1;
//        存进缓存
        redisTakes.set (email, numTime, 50 * 60);
        logger.info ("缓存进去的key为：" + email + "存进去的值为" + numTime);
        return 1;
    }

    /**
     * 邮箱注册验证
     *
     * @param restUser 注册信息
     * @return 0为验证码错误，1为验证通过，2为同名注册冲突，3为错误次数过多，4为注册信息不完整
     */
    @Override
    public int emailRegisterCheck(RestUser restUser) {
        logger.info ("进入注册信息验证：" + JSON.toJSONString (restUser));
        String code = restUser.getCode ();
        String email = restUser.getEmail ();
        String name = restUser.getName ();
        String pwd = restUser.getPwd ();

        if (email == null || name == null || pwd == null || pwd.isEmpty ()) {
            logger.info ("注册信息不完整");
            return 4;
        }

//       验证码是否为空
        if (code == null || code.isEmpty ()) {
            logger.info ("验证码为空,返回0");
            return 0;
        }

//            从缓存取出验证码
        String code1 = (String) redisTakes.get (email);
        logger.info ("缓存里的验证码+时间戳+次数：" + code1);

//        判断缓存里是否存在验证码
        if (code1 == null || code1.isEmpty ()) {
            logger.info ("缓存里验证码不能为空,返回0");
            return 0;
        }

        String[] sl = code1.split (",");
        String c0 = sl[0];

        logger.info ("截取的数组值为" + JSON.toJSONString (sl) + c0);
        int c2 = Integer.valueOf (sl[2]);
        String c1 = sl[1];
//        String c0=sl[0];

//        判断是否输入错误的次数过多
        if (c2 > 8) {
            logger.info ("验证码输入错误次数过多，返回3");
            return 3;
        }

//        判断验证码是否一致，不一致则错误次数加1
        if (!c0.equals (code)) {
            String code0 = c0 + "," + c1 + "," + (c2 + 1);
            redisTakes.set (email, code0, 8 * 60);
            logger.info ("验证码不相等，返回0，错误次数加一");
            return 0;
        }

        RestUser ru = userMapper.selectByName (restUser.getName ());
        logger.info ("数据库查询出来的值为" + JSON.toJSONString (ru));

//        判断是否存在同名注册
        if (ru == null) {
            logger.info ("不存在同名，返回1");
            return 1;
        }

        logger.info ("存在同名，返回2");
        return 2;
    }

    /**
     * 上传图片
     *
     * @return
     */
    @Override
    public String upload(RestUser user, String url) {

        MultipartFile multipartFile = user.getFile ();
        int check = MultipartFileUtil.check (multipartFile);
        logger.info ("multipartFile检查结果为:" + check);

        if (check != 1) {
            logger.info ("文件检查没通过");
            return null;
        }

        String fileName = MultipartFileUtil.fileName (multipartFile);
        logger.info ("生成的fileName：" + fileName);
//        logger.info ("使用的上传方式为" + uploadByWay);
//        try {
//            logger.info ("_________________________________________________");
//            if (uploadByWay != null && uploadByWay.equals ("oss")) {
//                logger.info ("使用阿里云上传图片");
//                url = oss.upload (fileName, multipartFile.getInputStream ());
//            } else {
//                logger.info ("使用腾讯云上传图片");
//                url = cos.upload (fileName, multipartFile.getInputStream ());
//            }
//        } catch ( IOException e ) {
//            logger.info ("图片上传失败");
//            e.printStackTrace ();
//        }
        try {
            url=UploadPhoto.photoUpload (fileName,multipartFile );
            logger.info ("上传图片后返回的url为："+url);
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
        if (url == null) {
            return null;
        }

        logger.info ("url不为空，存进数据库");
        user.setUpdateTime (timeStamp);
        user.setImg (url);
        int rsdb = userMapper.updateByName (user);
        logger.info ("存储数据库结果：" + rsdb);
        if (rsdb == 0) {
            return null;
        }

        return url;
    }

    @Override
    public List<String> tranToCos() throws Exception {
        logger.info ("开始阿里云转到腾讯云");
        List<String> rsurl = new ArrayList ();
        List<String> urlList = oss.ListforOss ();

        for (String urlKey : urlList) {

            String key = urlKey;
            logger.info ("获取列表成功");

            String OssKey = ("https://jnshuz.oss-cn-shenzhen.aliyuncs.com/" + key);
            logger.info ("得到的阿里云的图片链接为：" + OssKey);

            URL url = new URL (OssKey);
//        通过url对象打开连接,这里需要注意打开连接之后，这个函数返回的是不是httpUrlconnection类型而是 URLConnection类型，可以直接强转。
            HttpURLConnection conn = (HttpURLConnection) url.openConnection ();
            //设置请求方式
            conn.setRequestProperty ("Charset", "UTF-8");// 设置文件字符集:
            conn.setRequestProperty ("Content-type", "image/jpeg");

            conn.setDoInput (true);//是否打开输入流 ， 此方法默认为true
            conn.setDoOutput (true);//是否打开输出流， 此方法默认为false

            logger.info ("开始连接");
            conn.connect ();// 开始连接请求
            int code = conn.getResponseCode ();//服务器会返回一个响应码
            logger.info ("连接返回的状态码" + code);

            String rs = null;
            InputStream inputstream = conn.getInputStream ();
            if (inputstream != null) {
                rs = cos.upload (key, inputstream);
            }
            rsurl.add (rs);
            logger.info ("连接结束");
            inputstream.close ();
            conn.disconnect ();
        }

        return rsurl;
    }

        /**
         * 文件迁移，腾讯云到阿里云
         *
         * @return
         * @throws Exception
         */
        @Override
        public List trantoOss () throws Exception {
            logger.info ("开始腾讯云转到阿里云");
            List rsurl = new ArrayList ();
            List<String> keyList = cos.ListCos ();

            for (String urlKey:keyList) {
//                取出文件的key
                String key = urlKey;
                logger.info ("获取列表成功");

                String CosKey = ("https://jnshu-1257664104.cos.ap-guangzhou.myqcloud.com/" + key);
                logger.info ("得到的Cos的图片链接为：" + CosKey);

                URL url = new URL (CosKey);
//        通过url对象打开连接,这里需要注意打开连接之后，这个函数返回的是不是httpUrlconnection类型而是 URLConnection类型，可以直接强转。
                HttpURLConnection conn = (HttpURLConnection) url.openConnection ();

                //设置请求方式
//        conn.setRequestMethod ("GET");
                conn.setRequestProperty ("Charset", "UTF-8");// 设置文件字符集:
                conn.setRequestProperty ("Content-type", "image/jpeg");

                conn.setDoInput (true);//是否打开输入流 ， 此方法默认为true
                conn.setDoOutput (true);//是否打开输出流， 此方法默认为false

                logger.info ("开始连接");
                conn.connect ();// 开始连接请求
                int code = conn.getResponseCode ();//服务器会返回一个响应码
                logger.info ("连接返回的状态码" + code);

                String rs = null;
                InputStream inputstream = conn.getInputStream ();
                if (inputstream != null) {
                    rs = oss.upload (key, inputstream);
                    rsurl.add (rs);
                }else {
                    logger.info ("迁移失败的图片URL为："+urlKey);
                }
                logger.info ("连接结束");
                inputstream.close ();
                conn.disconnect ();
            }
        return rsurl;
    }

}
