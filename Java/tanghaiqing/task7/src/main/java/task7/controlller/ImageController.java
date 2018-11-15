package task7.controlller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import task7.service.thumbnail.Upload;
import task7.util.OSSClientUtil;
import task7.util.QNOSSUtil;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@Controller
@RequestMapping("/")
public class ImageController {
    private static Logger logger = Logger.getLogger(ImageController.class);
    @Autowired
    private Upload upload;

    private String name;
    private String thName;

    //文件上传并生成缩略图
    @RequestMapping(value = "/thumb", method = RequestMethod.POST)
    public String GenerateImage(@RequestParam("image") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //System.out.println("CommonsMultipartFile:"+file);
        ////根据相对路径获取绝对路径，图片上传后位于元数据中
        //String realUploadPath =request.getServletContext().getRealPath("/")+"images";
        //System.out.println("绝对地址为："+realUploadPath);
        ////获取上传后原图的相对地址
        //String imageUrl=upload.uploadImage(file,realUploadPath);
        //System.out.println("原图地址为："+imageUrl);
        ////获取生成缩略图的相对地址
        //String thumbImageUrl=thumbnail.generateThumbnail(file,realUploadPath);
        //System.out.println("生成缩略图相对地址:"+thumbImageUrl);
        logger.info("进入GenerateImage");
        logger.info(file);

        //设置上传后的文件名
        //调用上传工具类上传到阿里云
        thName=file.getOriginalFilename();
        name = QNOSSUtil.uploadImage(file);
        logger.info(name);
        logger.info(QNOSSUtil.getUrl(name));
      return null;
    }

    //显示所有图片
    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public String showImages(HttpServletRequest request) {
        ////根据相对路劲获取决定路径，图片位于原数据中
        //List<String> rawImagesList =new ArrayList<>();
        //String realUploadPath =request.getServletContext().getRealPath("/")+"images";
        //rawImagesList = ImageList.printFile(realUploadPath+"/rawImages");
        //System.out.println(rawImagesList);
        //ModelAndView mv =new ModelAndView();
        //mv.addObject("imageList",rawImagesList);
        //mv.setViewName("images");
        logger.info("进入showImages()");
        String url = OSSClientUtil.getImgUrl(name);
        logger.info(url);
        request.setAttribute("thNameUrl",thName);
        request.setAttribute("imgUrl",url);
        return "images";
    }

    //文件下载
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/") + "/images/rawImages/";
        String fileName = request.getParameter("filename");
        File file = new File(path + fileName);
        if (file.exists()) {
            //设置MIME类型
            response.setContentType("application/octet-stream");
            //或者为response.setContentType("application/x-msdownload");

            //设置头信息，设置文件下载时的默认文件名，同时解决中文名乱码问题
            response.addHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));

            InputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bs = new byte[1024];
            while ((inputStream.read(bs) > 0)) {
                outputStream.write(bs);
            }
            outputStream.close();
            inputStream.close();
        }
    }
}
