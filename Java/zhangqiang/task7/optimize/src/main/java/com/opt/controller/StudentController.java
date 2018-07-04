package com.opt.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.opt.model.Page;
import com.opt.model.Student;
import com.opt.service.impl.ProfessionServiceImpl;
import com.opt.service.impl.StudentServiceImpl;
import com.opt.service.impl.UserServiceImpl;
import com.opt.util.RandomStudent;
import com.opt.util.thirdparty.AliyunOSSClientUtil;
import com.whalin.MemCached.MemCachedClient;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.opt.util.safe.OSSClientConstants.BACKET_NAME;
import static com.opt.util.safe.OSSClientConstants.FOLDER;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
public class StudentController {

    private static Logger logger = Logger.getLogger(OptController.class);
    private RandomStudent randomStudent = new RandomStudent();
    private String message = "似乎遇到点问题";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");
//    ProfessionServiceImpl professionService = (ProfessionServiceImpl) applicationContext.getBean("professionService");
//    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
//    MemCachedClient memCachedClient = (MemCachedClient) applicationContext.getBean("memcachedClient");
//    JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
//    private Jedis jedis = jedisPool.getResource();


    @RequestMapping(value = "/u/student/{id}")
    public String toUpdStudent(@PathVariable("id")Integer id, Model model){
        Student student = studentService.findByID(id);
        if (student!=null){

            model.addAttribute("studentInfo",student);
        }
        return "updStudent";
    }


    @RequestMapping(value = "/u/student",method = PUT)
    public String updStudent(Student student,Model model){
        logger.info("\n信息："+student);
        int flag = studentService.updateOne(student);
        if (flag!=0){
            message = "修改成功";
        }else {
            message = "修改失败";
            model.addAttribute("message",message);
            return "redirect:updStudent";
        }
        model.addAttribute("message",message);
        return "redirect:list";
    }

    @RequestMapping(value = "/u/photo/{id}")
    public String updHeadIco(@PathVariable("id")Integer id,Model model) throws ServletException, IOException {
        logger.info("\n修改id号："+id);
        String img = studentService.findByID(id).getStuPhoto();
        model.addAttribute("imgPath",img);
        model.addAttribute("imgId",id);
//        request.getRequestDispatcher("/WEB-INF/jsp/body/updHeadIco.jsp").forward(request, response);
//        response.sendRedirect("/WEB-INF/jsp/body/updHeadIco.jsp");
//        return "forward:/WEB-INF/jsp/body/updHeadIco.jsp";
        return "imgHead";
    }


    //上传头像
    @RequestMapping(value = "/u/head_ico/{id}",method = RequestMethod.POST)
    public String uplodeHeadIco(@PathVariable("id")Integer id, HttpServletRequest request, Model model) throws FileUploadException {

        String url;

        //Spring框架的上传文件类
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest mrequest = resolver.resolveMultipart(request);


        MultipartFile file = mrequest.getFile("file");

        if (!file.isEmpty()) {

            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            String newfileName = new Date().getTime() + String.valueOf(fileName);
            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            // 项目下相对路径
            String path = "/upload/images/"+newfileName;
            // 创建文件实例 保存路径为pathRoot + path
            File imgFile = new File(pathRoot + path);

            /*if(FileCheUtil.checkFileSize((File) file,3,"M")){
                message = "上传文件不得大于3M";
                model.addAttribute("message",message);
                return "imgHead";
            }*/

            if (!imgFile.getParentFile().exists()) {
                imgFile.getParentFile().mkdirs();
                System.out.println("创建文件父目录");
            }
            if (!imgFile.exists()) {
                imgFile.mkdirs();
                System.out.println("创建文件目录");
            }

            try {

                //写入磁盘
                file.transferTo(imgFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                //初始化OSSClient
                OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
                //上传文件
                File filess=new File(pathRoot + path);
                Map map = AliyunOSSClientUtil.uploadObject2OSS(ossClient, filess, BACKET_NAME, FOLDER);

                String md5key = (String) map.get("MD5Key");
                String key = (String) map.get("key");
                url = AliyunOSSClientUtil.getUrl(ossClient,BACKET_NAME,key);

                Map icoMap = new HashMap();
                icoMap.put("id",id);
                icoMap.put("stuPhoto",url);

                //删除之前的文件
                /*if(ossClient.doesObjectExist("<yourBucketName>", "<yourObjectName>")){
                    ossClient.deleteObject("<yourBucketName>", "<yourObjectName>");
                }*/

                studentService.updateHeadIcoById(icoMap);

                logger.info("url="+url);
                logger.info("上传后的文件MD5数字唯一签名:" + md5key);

                //删除本地服务器缓存文件
                imgFile.delete();

                //关闭连接
                ossClient.shutdown();

            }catch (OSSException o){
                o.getMessage();
                return "";
            }

            model.addAttribute("fileUrl", url);
        }
        return "forward:/u/student/"+id;
    }



    @RequestMapping(value = "/u/list")
    public String studentList(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowpage,
                              @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize,Model model){

        logger.info("\nnowpage="+ nowpage + "pagesize=" + pagesize);

        Page<Student> page = studentService.findByPage(nowpage,pagesize);

        model.addAttribute("nowPages",page);

        logger.info("\npage size : "+page.getPages().size());

        return "list";
    }

//    使用memcache缓存
/*    @RequestMapping(value = "/u/list")
    public String studentList(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowpage,
                              @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize,Model model){

        logger.info("\nnowpage="+ nowpage + "pagesize=" + pagesize);

        List<Student> students = (List<Student>) memCachedClient.get("pageList");
        String JsonPageInfo = (String) memCachedClient.get("jsonPage"+nowpage);
        Page<Student> pageInfo = JSON.parseObject(JsonPageInfo,Page.class);
        logger.info("\nstudents: "+students);
        logger.info("\njsonPage"+ nowpage +":"+pageInfo);

        Page<Student> page;

//        如果有缓存读取缓存，如果没有就查询数据库，在用户修改之后在更新操作里同步更新/删除cache
        if (pageInfo!=null && pageInfo.getCurrPage() == nowpage){
            page=pageInfo;
        }else {
            page = studentService.findByPage(nowpage,pagesize);
            String jsonPage = JSON.toJSONString(page);
            memCachedClient.set("pageList",page.getPages());
            memCachedClient.set("jsonPage"+nowpage,jsonPage);
        }
        model.addAttribute("nowPages",page);
        logger.info(page.getPages().toString());
        return "list";
    }*/

//    使用redis缓存
/*    @RequestMapping(value = "/u/list")
    public String studentList(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowpage,
                              @RequestParam(value = "pagesize",defaultValue = "5")Integer pagesize,Model model){

        logger.info("\nnowpage="+ nowpage + "pagesize=" + pagesize);

        String JsonPageInfo = jedis.get("jsonPage"+nowpage);
        logger.info("\n获取到的key："+"jsonPage"+nowpage+":"+JsonPageInfo);
        Page<Student> pageInfo = JSON.parseObject(JsonPageInfo,Page.class);

        logger.info("\njsonPage"+ nowpage +":"+pageInfo);

        Page<Student> page;

//        如果有缓存读取缓存，如果没有就查询数据库，在用户修改之后在更新操作里同步更新/删除cache
        if (pageInfo!=null && pageInfo.getCurrPage() == nowpage){
            logger.info("\n查询到有缓存，使用缓存\n");
            page = pageInfo;

        }else {
            logger.info("\n未查询到缓存内容，查询数据库内容\n");
            page = studentService.findByPage(nowpage,pagesize);

            String jsonPage = JSON.toJSONString(page);

            jedis.set("jsonPage"+nowpage,jsonPage);
        }

        model.addAttribute("nowPages",page);

        logger.info(page.getPages().toString());

        return "list";
    }*/




}
