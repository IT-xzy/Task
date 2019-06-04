package com.jnshu.pojo.tool;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 11:45
 */
public class UuidUtil {
    private static Logger logger = Logger.getLogger(UuidUtil.class);

    public static String getUUID(MultipartFile multipartFile) {
        logger.info ("MToF方法的入参是 multipartFile" + multipartFile.toString ());
        //获得文件类型
        String contentType = multipartFile.getContentType ();
        //获得文件后缀名
        String suffixName = contentType.substring (contentType.indexOf ("/") + 1);
        logger.info ("图片的后缀为：" + suffixName);

        //生成UUID并去除"-"符号
        String uuid = UUID.randomUUID ().toString ().replaceAll ("-", "");
        String fileName = "" + uuid + "." + suffixName;

        logger.info ("最终生成的图片名字为：" + fileName);
        return fileName;
    }
}
