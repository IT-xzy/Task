package jnshu.tool;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class photo {
    private static Logger logger = Logger.getLogger (photo.class);

    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

        if (file != null) {
            //获取上传文件的原始名称
            String originalFilename = file.getOriginalFilename ();
            String newFileName = "";
            String pic_path;
            // 上传图片
            if (originalFilename != null && originalFilename.length () > 0) {
                //获取Tomcat服务器所在的路径
                String tomcat_path = System.getProperty ("user.dir");
                System.out.println (tomcat_path);
                logger.info ("tomcat_path:" + tomcat_path);

                //获取Tomcat服务器所在路径的最后一个文件目录
                String bin_path = tomcat_path.substring (tomcat_path.lastIndexOf ("\\") + 1, tomcat_path.length ());
                System.out.println (bin_path);
                //若最后一个文件目录为bin目录，则服务器为手动启动
                if (("bin").equals (bin_path)) {//手动启动Tomcat时获取路径为：D:\Software\Tomcat-8.5\bin
                    //获取保存上传图片的文件路径
                    pic_path = tomcat_path.substring (0, System.getProperty ("user.dir").lastIndexOf ("\\")) + "\\webapps" + "\\pic_file\\";
                } else {//服务中自启动Tomcat时获取路径为：D:\Software\Tomcat-8.5
                    pic_path = tomcat_path + "\\webapps" + "\\pic_file\\";
                }
                // 新的图片名称
                newFileName = UUID.randomUUID () + originalFilename.substring (originalFilename.lastIndexOf ("."));
                logger.info ("上传图片的路径：" + pic_path + newFileName);
                // 新图片
                File newFile = new File (pic_path + newFileName);
                // 将内存中的数据写入磁盘
                file.transferTo (newFile);
            }
            return newFileName;
        } else {
            return null;
        }
    }

}
