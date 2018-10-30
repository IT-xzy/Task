package thirdApi.com.aliyun.oss.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @Description: MultipartFile转File工具类
 */
public class MtoFUtil {
    public static Logger logger = LogManager.getLogger(MtoFUtil.class);

    public static File MToF(MultipartFile file, HttpServletRequest request) {

        //在当前项目根路径建立临时文件夹
        String path = request.getSession().getServletContext().getRealPath("");
        File dir = new File(path, "temp");
        if(!dir.exists()){
            dir.mkdirs();
            logger.info("temp文件夹已建立；");
        }
        File f = null;
        try {
            if (file.equals("") || file.getSize() <= 0) {
                file = null;
            } else {
                InputStream ins = file.getInputStream();
                f = new File(dir.getAbsolutePath(), file.getOriginalFilename());
                inputStreamToFile(ins, f);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return f;

    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
