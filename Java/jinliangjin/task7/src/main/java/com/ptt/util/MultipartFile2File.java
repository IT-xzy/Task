package com.ptt.util;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @ClassName: MultipartFile2File
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/14 10:19
 * @Version: 1.0
 */
public class MultipartFile2File {
    private static Logger logger = LoggerFactory.getLogger(MultipartFile2File.class);

    public static File trans(MultipartFile multipartFile) {
        if (multipartFile == null) {
            logger.info("multipartFile = null");
            return null;
        }
        CommonsMultipartFile cmf = (CommonsMultipartFile) multipartFile;
        DiskFileItem dfi = (DiskFileItem) cmf.getFileItem();
        return dfi.getStoreLocation();
    }
}
