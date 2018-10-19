package com.service;

import com.entity.Excellent_Stu;
import com.entity.User;
import com.entity.User2;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserService {
    List<Excellent_Stu> getAll();

    List<Excellent_Stu> limit();

    /**
     * 判断用户是否存在
     *
     * @param name
     * @param password
     * @return
     */
    boolean judgeUser(String name, String password) throws Exception;

    /**
     * 保存token
     *
     * @param name
     * @return
     */
    String saveToken(String name) throws Exception;

/**
* @Description:  添加注册用户
* @Author: Sometimes
* @Date:
*/
    void addUser(User user);

 /**
 * @Description:  判断用户名是否已经被注册
 * @Author: Sometimes
 * @Date:
 */
     User findUserByName(String name);
/**
* @Description:  判断手机号码是否已经注册了
* @Author: Sometimes
* @Date:
*/
    User finUserByPhone(String phone);

    /**
     * @Description:  判断邮箱是否已经注册了
     * @Author: Sometimes
     * @Date:
     */
    User findUserByEmail(String email);

    /**
    * @Description:  添加头像
    * @Author: Sometimes
    * @Date:
    */
    Boolean updateUserByName(String name,String photo);

    /**
    * @Description:  根据用户显示图片
    * @Author: Sometimes
    * @Date:
    */
    String findPhotoByName(String name);

    /**
    * @Description:  查询用户是否存在
    * @Author: Sometimes
    * @Date:
    */
    Boolean judgeUserExist(String name);
}

