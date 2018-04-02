package jnshu.taskeight.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-11
 * @Time: 下午 4:07
 * Description:
 **/
public class FileInformation implements Serializable {

    String filename;
    String contentType;
    byte[] content;

    public String getFilename() {
        return filename;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public FileInformation(String filename,String contentType,byte[] content){
        this.filename = filename;
        this.contentType = contentType;
        this.content = content;
    }

}