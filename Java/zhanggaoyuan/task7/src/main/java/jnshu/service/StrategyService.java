package jnshu.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StrategyService {
    String photoUpload(String fileName,MultipartFile multipartFile) throws IOException;
}
