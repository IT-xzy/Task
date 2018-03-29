package jnshu.taskeight.APIUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-02
 * @Time: 下午 4:10
 * Description:
 **/

@Component("readFileServiceImpl")
public class ReadFileServiceImpl implements ReadFileService {

    @Autowired
    FileService fileService;

    private static Logger loggerReadFileUtil = LoggerFactory.getLogger(ReadFileServiceImpl.class);


    public static String[] Picture_Ext_Name = new String[]{
            "gif", "jpg", "jpeg", "png", "bmp", "tiff", "pcx", "tga",
            "exif", "fpx", "svg", "psd", "cdr", "pcd", "dxf", "ufo",
            "eps", "ai", "raw", "WMF"};

    String FILE_TYPE = "image";


    @Override
    public String readPicture(HttpServletRequest request, String user) throws ServletException, IOException {


        String message = "";
        //使用Apache文件上传组件处理文件上传步骤：
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2. 创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long pBytesRead, long pContentLength, int arg2) {
                loggerReadFileUtil.info("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
            }
        });

        //解决上传文件名的中文乱码问题
        upload.setHeaderEncoding("UTF-8");
        //设置内存的临界值为500K
        factory.setSizeThreshold(1024 * 500);
        //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
        upload.setFileSizeMax(1024 * 1024);
        //设置上传的文件总的大小不能超过5M
        upload.setSizeMax(1024 * 1024 * 5);

        //3. 判断提交上来的数据是否是上传表单
        if (!ServletFileUpload.isMultipartContent(request)) {
            message = "上传为表单！";
            return message;
        }
        try {
            //使用ServletFileUpload解析器解析上传数据，
            // 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                /*isFormField方法用来判断FileItem对象里面封装的数据是一个普通文本表单字段，
                 *还是一个文件表单字段。如果是普通文本表单字段，返回一个true否则返回一个false。
                 *因此可以用该方法判断是否是普通表单域还是文件上传表单域。
                 * 如果fileitem中封装的是普通输入项的数据
                 */
                if (item.isFormField()) {
                    //getFieldName方法用来返回表单标签的name属性的值。
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    loggerReadFileUtil.info(name + " = " + value);
                }
                //如果fileitem中封装的是上传文件
                else {
                    //得到上传的文件名称
                    String fileName = item.getName();
                    loggerReadFileUtil.info("file name : " + fileName);

                    /*
                     * String.trim()去掉字符串两端的多余的空格以及：
                     *('/t', '/n', '/v', '/f', '/r', ' ', '/x0085', '/x00a0',
                     *  ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                     *  ' ', '?', '/u2028', '/u2029', ' ', '?')
                     */
                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    /*
                     *注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
                     * 如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                     * 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                     */
                    //截取掉从首字母起长度为filename.lastIndexOf("\\")+1的字符串，将剩余字符串赋值给filename ；
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);

                    // 得到上传文件的扩展名
                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                    loggerReadFileUtil.info("fileExt: " + fileExt);
                    //设置文件类型
                    String contentType = FILE_TYPE + "/" + fileExt;
                    int sign = 0;
                    // 检查扩展名
                    for (String str : Picture_Ext_Name) {
                        //检查字符串(参数parameterValue)是否包含字符串(参数str), 忽略大小写.返回类型boolean
                        if (StringUtils.containsIgnoreCase(fileExt, str)) {
                            sign = 1;
                        }
                    }
                    if (sign == 0) {
                        message = "图片类型非法！";
                        loggerReadFileUtil.info("上传文件扩展名是不允许的扩展名：" + fileExt);
                        return message;
                    }

                    //重新给文件命名
                    String time = String.valueOf(System.currentTimeMillis());
                    int random = ThreadLocalRandom.current().nextInt(999999);
                    /* 命名规则： u:username   time: 当前时间戳   r: 随机6位数   f: 文件名*/
                    fileName = "u_" + user + "-t_" + time + "-r_" + random + "-f_" + fileName;
                    loggerReadFileUtil.info("new  file name : " + fileName);

                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();

                    int count = 0;
                    //保证流传输到
                    try {
                        while (count == 0) {
                            count = in.available();
                        }
                    } catch (IOException e) {
                        message = "IO传输错误";
                        e.printStackTrace();
                        loggerReadFileUtil.error("IO传输错误");
                        return message;
                    }

                    String ossFileNamre = fileService.uploadStream("image",fileName,in,contentType);
                    in.close();
                    item.delete();

                    loggerReadFileUtil.info("ossFileNamre: " + ossFileNamre);

                    if(ossFileNamre.equals(fileName)){
                        return ossFileNamre;
                    }
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            message = "单个文件超出最大值！！！";
            return message;
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            message = "上传文件的总的大小超出限制的最大值!!!";
            return message;
        } catch (Exception e) {
            message = "文件上传失败";
            e.printStackTrace();
            return message;
        }
        message = "文件上传失败";
        return message;
    }


    @Override
    public String readPicture(MultipartFile file,String user) throws ServletException, IOException {
        String contentType = null;
        String fileName = null;
        String message = null;

        if(!file.isEmpty()){

            try {
                fileName = file.getOriginalFilename();
                if (fileName == null || fileName.trim().equals("")) {
                    return "文件名错误";
                }
                //截取掉从首字母起长度为filename.lastIndexOf("\\")+1的字符串，将剩余字符串赋值给filename ；
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);

                // 得到上传文件的扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                int sign = 0;
                // 检查扩展名
                for (String str : Picture_Ext_Name) {
                    //检查字符串(参数parameterValue)是否包含字符串(参数str), 忽略大小写.返回类型boolean
                    if (StringUtils.containsIgnoreCase(fileExt, str)) {
                        sign = 1;
                    }
                }
                if (sign == 0) {
                    message = "图片类型非法！";
                    loggerReadFileUtil.info("上传文件扩展名是不允许的扩展名：" + fileExt);
                    return message;
                }

                contentType = file.getContentType();

                //重新给文件命名
                String time = String.valueOf(System.currentTimeMillis());
                int random = ThreadLocalRandom.current().nextInt(999999);

                    /* 命名规则： u:username   time: 当前时间戳   r: 随机6位数   f: 文件名*/
                fileName = "u_" + user + "-t_" + time + "-r_" + random + "-f_" + fileName;
                loggerReadFileUtil.info("new  file name : " + fileName);

                InputStream in = file.getInputStream();

                int count = 0;
                //保证流传输到
                try {
                    while (count == 0) {
                        count = in.available();
                    }
                } catch (IOException e) {
                    message = "IO传输错误";
                    e.printStackTrace();
                    loggerReadFileUtil.error("IO传输错误");
                    return message;
                }

                String ossFileNamre = fileService.uploadStream("image", fileName, in, contentType);
                in.close();

                loggerReadFileUtil.info("ossFileNamre: " + ossFileNamre);

                if (ossFileNamre.equals(fileName)) {
                    return ossFileNamre;
                }
            }catch (Exception e) {
                message = "文件上传失败";
                e.printStackTrace();
                return message;
            }
            message = "文件上传失败";
            return message;

        }
        else {
            return "文件为空！";
        }
    }

}