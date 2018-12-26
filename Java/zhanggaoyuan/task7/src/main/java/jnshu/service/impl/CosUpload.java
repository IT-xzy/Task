package jnshu.service.impl;

import jnshu.service.StrategyService;
import jnshu.tool.api.Cos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public class CosUpload implements StrategyService {

    @Autowired
    Cos cos;

    @Override
    public String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {
        return cos.upload (fileName, multipartFile.getInputStream ());
    }
}
