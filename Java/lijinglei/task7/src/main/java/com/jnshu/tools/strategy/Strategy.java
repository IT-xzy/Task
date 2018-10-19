package com.jnshu.tools.strategy;

import org.springframework.web.multipart.MultipartFile;


public interface Strategy {

    String doUp(MultipartFile file , String trueFileName);
}