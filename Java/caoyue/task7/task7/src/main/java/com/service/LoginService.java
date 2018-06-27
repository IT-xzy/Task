package com.service;

import com.POJO.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task7
 * @description: the service for login
 * @create: 2018/5/28 下午1:45
 */

public interface LoginService {
    List<Student> testJson();
    //上传用户头像至OSS服务器，并且取回URL值
    String uploadAvatar(MultipartFile file, String userName, String ip) throws Exception;
}
