package hzw.util;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;

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
