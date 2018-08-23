package com.strategy;
import com.tools.AliUploadFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class AliOss implements OssPattern {
    private String style;
    private String url;
    private String format;


//    private org.springframework.context.ApplicationContext ap=new ClassPathXmlApplicationContext("spring-mybatis.xml");
//    private AliUploadFile aliUploadFile= (AliUploadFile) ap.getBean("aliUploadFile");
    @Resource
    private AliUploadFile aliUploadFile;


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void osstransfer() {
        aliUploadFile.transfer();
    }

    @Override
    public void uploadFile(CommonsMultipartFile file, String objectName) {
        System.out.println("com.strategy.AliOss.uploadFile的类AliUploadFile aliUploadFile是否为空 "+aliUploadFile);
        System.out.println("com.strategy.AliOss.uploadFile的入参是 file = "+file+"  ; object = "+objectName);
        aliUploadFile.upFile(file,objectName);
    }

    @Override
    public Map<String,String> urlChange() {
        String buttonName = "阿里OOS";
        Map<String,String> map=new HashMap<>();
        map.put("style",style);
        map.put("url",url);
        map.put("format",format);
        map.put("buttonName",buttonName);
        return map;
    }

}
