package jnshu.service.impl;

import jnshu.service.StrategyService;
import jnshu.tool.api.Oss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@Service
public class OssUpload implements StrategyService {
    @Autowired
    Oss oss;

    @Override
    public String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {
        return oss.upload (fileName, multipartFile.getInputStream ());
    }
}