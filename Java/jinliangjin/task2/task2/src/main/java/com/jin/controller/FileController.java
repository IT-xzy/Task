package com.jin.controller;

import com.jin.pojo.User;
import com.jin.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @ProjectName: task2
 * @Package: com.jin.controller
 * @ClassName: FileController
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/15 21:00
 * @UpdateUser:
 * @UpdateDate: 2018/5/15 21:00
 * @UpdateRemark:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private StudentService studentService;
    private Logger logger = Logger.getLogger(Object.class);

    @RequestMapping(value = "/uploadFile")
    public String upload() {
        return "uploadFile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, @RequestParam(value = "description", required = false) String description,
                             @RequestParam("file") MultipartFile file) throws Exception {
        logger.info(description);
        //如果文件不为空
        if (!file.isEmpty()) {
            //文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //文件名
            String fileName = file.getOriginalFilename();
            File filePath = new File(path, fileName);
            //如果路径不存在则新建
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            //将文件保存在/images/目录之中
            file.transferTo(new File(path + File.separator + fileName));
            return "fileSuccess";
        } else {
            return "fileFail";
        }
    }

    //文件上传页面，输入描述信息并上传文件，点击提交后上传
    @RequestMapping("/registerFile")
    public String registerFile() {
        return "registerForm";
    }

    //执行文件上传
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute User user, HttpServletRequest request) throws Exception {
        logger.info(user.getName());
        if (!user.getFile().isEmpty()) {
            String path = request.getServletContext().getRealPath("/images/");
            String filename = user.getFile().getOriginalFilename();
            File filepath = new File(path, filename);
            if (filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            user.getFile().transferTo(new File(path + File.separator + filename));
            model.addAttribute("user", user);
            return "userInfo";
        }
        return "fileFail";
    }

    @RequestMapping("/download")
    //ResponseEntity<T>继承了HttpStatus<T>，它实现了响应头、文件数据（以字节存储）、状态封装在一起
    // 交给浏览器处理以实现浏览器的文件下载
    public ResponseEntity<byte[]> download(HttpServletRequest request, Model model,
                                           @RequestParam("filename") String filename) throws Exception {
        //需要被下载的文件的路径
        String path = request.getServletContext().getRealPath("/images/");
        //用得到的文件路径和请求中的文件名新建文件
        File file = new File(path + File.separator + filename);
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置文件名的字符，解决乱码问题
        String downloadFilename = new String(filename.getBytes("utf-8"), "iso-8859-1");
        //让浏览器以attachment（下载）方式打开文件
        httpHeaders.setContentDispositionFormData("attachment", downloadFilename);
        //二进制流数据
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }

}
