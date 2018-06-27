package com.jnshu.tools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @program: QINIUSDKImage
 * @description: MultFile 转换为 IoFile 文件流
 * @author: Mr.xweiba
 * @create: 2018-06-01 00:23
 **/

public class MultFileToIoFile {
    private final static Logger LOGGER = LoggerFactory.getLogger(MultFileToIoFile.class);
    /*public static InputStream multipartToInputStream(MultipartFile multipartFile){
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        DiskFileItem diskFileItem = (DiskFileItem) cf.getFileItem();
        try {
            InputStream inputStream = diskFileItem.getInputStream();
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.debug("文件流转换失败");
        }
        return null;
    }*/
}
