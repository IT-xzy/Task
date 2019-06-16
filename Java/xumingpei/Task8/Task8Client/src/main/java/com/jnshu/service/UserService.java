package com.jnshu.service;

import com.jnshu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:12
 */
public interface UserService {
    int insert(User record);
    User selectById(Long id);
    List<User> selectByName(String name);
    List<User>  selectByNameAndPassword(@Param("name") String name, @Param("password") String password);
    int sendPhone(String phone, String msgCode);
    int checkPhoneCode(String phone, String code);
    User selectByPhone(String phone);
    int sendEmail(String email, String msgCode);
    int cheakEmail(String email, String code);
    User selectByEmail(String email);
    String upload(User user, MultipartFile multipartFile, String url);
}
