package com.jnshu.tools.strategy;

import org.springframework.web.multipart.MultipartFile;


public class UpFile {
    public String type;
Strategy strategy ;
    public void type(String type){
        this.type = type;
        if (type.equals("Cos")){
strategy = new CosUp();
        }else if (type.equals("Qn")){
            strategy = new QnUp();
        }
    }
    public String up(MultipartFile file , String trueFileName){
        return strategy.doUp(file,trueFileName);
    }
}
