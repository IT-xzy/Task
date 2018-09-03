package com.jnshu.controller;

import com.jnshu.model.User;
import com.jnshu.service.UserService;
import com.jnshu.tools.*;
import com.jnshu.tools.strategy.CosUp;
import com.jnshu.tools.strategy.UpFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.model.ObjectMetadata;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import static com.jnshu.controller.UserController.LongTime;

@Controller
public class RegController {

    @Autowired
    UserService userService;

    @Autowired
    COSClient cosClient;
    private Logger logger = Logger.getLogger(RegController.class);

    Redis cache = new Redis();

    QnOssUntil qnOssUntil = new QnOssUntil();

    /**
     * 发送验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/Code", method = {RequestMethod.POST})
    public void email(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException {
        PrintWriter out = response.getWriter();
        String timesKey;
        String value;
        int times = 0;
        long dateDifference = 5*60*1000;
        boolean rs;
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String validity = "5";
        String addr = request.getParameter("addr");
        timesKey = addr;
        String codeRecode = cache.getCacheObject(timesKey);
        if (codeRecode != null) {
            logger.info("\n缓存"+codeRecode);
            Long before = Long.valueOf(codeRecode.split(",")[0]);
            dateDifference = System.currentTimeMillis() - before;//计算时间差
            times = Integer.parseInt(codeRecode.split(",")[1]);
        }
        if (dateDifference >= 5 * 60 * 1000 && times <= 5) {

            try {
                cache.setCacheObject(addr, code, Long.valueOf(validity));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (addr.indexOf("@") != -1) {
                SendEmailUtil sendEmailUtil = new SendEmailUtil(addr, "验证码", code, validity);
                rs = sendEmailUtil.send();
            } else {
                String r = SmsUtil.SMS(addr, code, validity);
                if (r.indexOf("OK") == -1) {
                    rs = false;
                } else {
                    rs = true;
                }
            }

            logger.info(rs);
            if (rs == true) {
                times = times + 1;
                value = String.valueOf(System.currentTimeMillis()) + "," + times;
                cache.setCacheObject(timesKey, value,24*60);

                out.print(1);
                logger.info("验证码发送成功");
                logger.info("发送给" + addr + "，验证码为" + code + "，有效期为" + validity + "分钟");
            } else {
                out.print(0);
                logger.info("验证码发送失败");
            }
        } else if (times > 5) {
            out.print(2);
            logger.info("发送次数超限"+times);
        }else if (dateDifference < 5*60*1000){
            out.print(3);
            logger.info("操作过于频繁"+dateDifference);
        }

    }


    /**
     * 验证验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/checkCode", method = {RequestMethod.POST})
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        String data = request.getParameter("data");
        String code = data.toString().split(",")[0];
        String telNum = data.toString().split(",")[1];
        String email = data.toString().split(",")[2];
        System.out.println(data);
        String redisRs = cache.getCacheObject(telNum) + "," + cache.getCacheObject(email);

        System.out.println(redisRs);
        logger.info(redisRs);
        if (redisRs.indexOf(code) == -1 || code == null) {
            out.print(0);
            logger.info("验证码错误");
        } else {
            out.print(1);
            logger.info("验证码正确");
        }

    }


    /**
     * 注册跳转
     *
     * @return
     */

    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister(HttpServletRequest request) {

        LongTime(request);
        return "register";
    }

    @RequestMapping(value = "/checkUser", method = {RequestMethod.POST})
    public void checkUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        User user = userService.selectByName(name);
        if (user == null) {
            out.print(1);
        } else {
            logger.info(user.getUserName());
            out.print(0);
        }
    }


    /**
     * 注册
     *
     * @param user
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(User user, HttpServletRequest request) {
        try {

            String timeStamp = String.valueOf(System.currentTimeMillis());
            LongTime(request);
            String password = user.getPassword();
            String salt = MD5Util.salt();
            String psSalt = MD5Util.generate(password, salt);
            logger.info("\n加盐前：" + password);
            logger.info("\n盐值：" + salt);
            logger.info("\n加盐后：" + psSalt);
            user.setSalt(salt);
            user.setPassword(psSalt);
            logger.info(user.getUserName() + "\t" + user.getPassword());
            //设置默认头像
            user.setUserImage("default.jpg");
            String str = userService.addInfo(user);
            logger.info(str);
            String data = user.getUserName() + "," + psSalt + "," + timeStamp;
            HttpSession session = request.getSession();
            session.setAttribute("session", data);//插入session
            request.setAttribute("InfoMessage", str);
            request.setAttribute("userName", user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "userImage";
        }
    }

    /**
     * 图片文件上传
     */
    @RequestMapping(value = "/photoUpload", method = RequestMethod.POST)
    public String photoUpload(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
        String upType = "Cos";
        if (file != null) {// 判断上传的文件是否为空
            String path;// 文件路径
            String type;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + type;
                    // 设置存放图片文件的路径
                    path = realPath + trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    session = request.getSession();
                    if (session.getAttribute("image") != null) {
                        upType = (String) session.getAttribute("image");
                    }
                    UpFile upFile = new UpFile();
                    upFile.type(upType);
                    upFile.up(file, trueFileName);
                    //session取出用户名
                    String se = (String) session.getAttribute("session");
                    System.out.println(se);
                    if (se != null) {
                        System.out.println("session");
                        String username = se.split(",")[0];
                        //文件名上传到数据库
                        String re = userService.uploadImage(username, trueFileName);
                        request.setAttribute("InfoMessage", re);
                    }

                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                System.out.println("文件类型为空");
            }
        } else {
            System.out.println("没有找到相对应的文件");
        }
        return "result";

    }

    /**
     * 七牛云传腾讯云
     */


    @RequestMapping(value = "/transToCos", method = RequestMethod.POST)
    public void tranToCos(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String fileName = null;
        String domainOfBucket = "http://pdotd3prr.bkt.clouddn.com/";
        List list = qnOssUntil.qnList();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            for (Object key : list) {
                fileName = (String) key;
                String encodedFileName = URLEncoder.encode(fileName, "utf-8");
                String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
                System.out.println(finalUrl);
                URL url = new URL(finalUrl);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.connect();
                InputStream iputstream = uc.getInputStream();
                int l = uc.getContentLength();
                System.out.println("\nHTTP" + l);
                objectMetadata.setContentLength(l);
                System.out.println(fileName + iputstream + objectMetadata);
                cosClient.putObject(qnOssUntil.getBucketName(), fileName, iputstream, objectMetadata);
            }
        } catch (Exception e) {
            out.print(0);
            logger.info("七牛到腾讯迁移失败，错误文件名为" + fileName);
        }

        out.print(1);
        logger.info("七牛到腾讯迁移成功");
        cosClient.shutdown();
        HttpSession session = request.getSession();
        session.setAttribute("image", "Cos");//插入session
    }

    /**
     * 腾讯云到七牛
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/transToQn", method = RequestMethod.POST)
    public void tranToQn(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        String fileName = null;
        try {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
            listObjectsRequest.setBucketName(qnOssUntil.getBucketName());
            listObjectsRequest.setPrefix("");
            listObjectsRequest.setDelimiter("/");
            listObjectsRequest.setMarker("");
            listObjectsRequest.setMaxKeys(100);
            ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);
            List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            String domainOfBucket = "https://logic-1255663509.cos.ap-guangzhou.myqcloud.com";
            for (COSObjectSummary cosObjectSummary : objectSummaries) {
// 文件路径
                fileName = cosObjectSummary.getKey();
// 获取文件长度
//            long fileSize = cosObjectSummary.getSize();
                String encodedFileName = URLEncoder.encode(fileName, "utf-8");
                String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
                URL url = new URL(finalUrl);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.connect();
                InputStream iputstream = uc.getInputStream();
                QnOssUntil.upFile(iputstream, fileName);
            }

        } catch (Exception e) {
            out.print(0);
            logger.info("腾讯到七牛迁移失败，错误文件名为" + fileName);
        }

        out.print(1);
        logger.info("腾讯到七牛迁移成功");
        HttpSession session = request.getSession();
        session.setAttribute("image", "Qn");//插入session

    }


}
