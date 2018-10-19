package com.strategy;
import com.tools.QiniuUp;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


public class QiniuOss implements OssPattern {
    private Logger logger=Logger.getLogger(QiniuOss.class);
    private String style;
    private String url;
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Resource
    private QiniuUp qiniuUp;


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

    @Override
    public void osstransfer() {
        qiniuUp.transfer();

    }

    @Override
    public void uploadFile(CommonsMultipartFile file, String objectName) {
        logger.info("com.strategy.uploadFile的入参是 CommonsMultipartFile "+file+" ; objectName 是 "+objectName);
        qiniuUp.uploadFile(file,objectName);
    }

    @Override
    public Map<String,String> urlChange() {
        String buttonName = "七牛OOS";
        Map<String,String> map=new HashMap<>();
        map.put("style",style);
        map.put("url",url);
        map.put("format",format);
        map.put("buttonName",buttonName);
        return map;
    }


}
