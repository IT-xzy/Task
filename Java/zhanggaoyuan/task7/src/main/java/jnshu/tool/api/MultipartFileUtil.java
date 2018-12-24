package jnshu.tool.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * 对前端传过来的文件进行处理，并把multipartFile转换成file
 */
public class MultipartFileUtil {
    private static Logger logger = Logger.getLogger (String.valueOf (MultipartFileUtil.class));

    /**
     * @param multipartFile 上传的文件
     * @return 为0表示文件为空，为2表示文件类型不是符合，为3表示文件太大。
     * @throws IOException
     */
    public static int check(MultipartFile multipartFile) {
        logger.info ("_______________________________________________");
        logger.info ("check方法的入参是 multipartFile" + multipartFile.toString ());


        if (multipartFile == null) {
            logger.info ("上传文件为空，返回0");
            return 0;
        }

//        单位字节，1024字节等于1k
        if (multipartFile.getSize () > 1024 * 512) {
            logger.info ("图片太大，返回3:" + multipartFile.getSize ());
            return 3;
        }


        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType = multipartFile.getContentType ();
        logger.info ("类型为：" + contentType);
        if (!contentType.matches (".*image.*")) {
            return 2;
        }

        return 1;
    }

    /**
     * @param multipartFile 传入非空的multipartFile
     * @return 返回图片的名字
     */
    public static String fileName(MultipartFile multipartFile) {
        logger.info ("_______________________________________________");
        logger.info ("MToF方法的入参是 multipartFile" + multipartFile.toString ());

        //获得文件类型
        String contentType = multipartFile.getContentType ();
        //获得文件后缀名
        String suffixName = contentType.substring (contentType.indexOf ("/") + 1);
        logger.info ("图片的后缀为：" + suffixName);

        //    生成UUID并去除-符号
        String uuid = UUID.randomUUID ().toString ().replaceAll ("-", "");
        String fileName = "jnshu/picture/" + uuid + "." + suffixName;

        logger.info ("最终生成的图片名字为：" + fileName);
        return fileName;
    }

}
