package com.strategy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.Map;


public interface OssPattern {
    void osstransfer();
    void uploadFile(CommonsMultipartFile file, String objectName);
    Map<String,String> urlChange();
}
