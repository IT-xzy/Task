package com.jin.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @ProjectName: task2
 * @Package: com.jin.pojo
 * @ClassName: User
 * @Description: 用来接收上传的文件
 * @Author: Jin
 * @CreateDate: 2018/5/16 10:11
 * @UpdateUser:
 * @UpdateDate: 2018/5/16 10:11
 * @UpdateRemark:
 * @Version: 1.0
 */
public class User implements Serializable{
    private String name;
    private MultipartFile file;

    public User(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
