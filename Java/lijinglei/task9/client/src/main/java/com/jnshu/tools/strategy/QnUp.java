package com.jnshu.tools.strategy;

import com.jnshu.tools.QnOssUntil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class QnUp implements Strategy {


    @Override
    public String doUp(MultipartFile file, String trueFileName) {
        try {
            InputStream inputStream = file.getInputStream();
            QnOssUntil.upFile(inputStream, trueFileName);
        } catch (IOException e) {
            return "七牛云上传失败";
        }
        return "七牛云上传成功";
    }
}