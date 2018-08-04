package com.Tool;


import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;


public class MultFileToIoFile{
    private  static Logger logger = Logger.getLogger(MultFileToIoFile.class);
    public static DiskFileItem multipartFile(MultipartFile multipartFile){
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        return (DiskFileItem) cf.getFileItem();
    }
    public static InputStream multipartToInputStream(MultipartFile multipartFile){
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        DiskFileItem diskFileItem = (DiskFileItem) cf.getFileItem();
        try {
            InputStream inputStream = diskFileItem.getInputStream();
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("文件流转换失败");
        }
        return null;
    }
}
