package com.jnshu.tools;


import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;


/**
 * @program: QINIUSDKImage
 * @description: MultFile 转换为 IoFile 文件流
 * @author: Mr.xweiba
 * @create: 2018-06-01 00:23
 **/

public class MultFileToIoFile {
    private final static Logger LOGGER = LoggerFactory.getLogger(MultFileToIoFile.class);
    public static InputStream multipartToInputStream(MultipartFile multipartFile){
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
    }
}
