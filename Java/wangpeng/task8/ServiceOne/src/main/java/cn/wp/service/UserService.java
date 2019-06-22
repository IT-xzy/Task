package cn.wp.service;

import cn.wp.model.User;
import org.apache.ibatis.annotations.Param;

/** @ClassName: UserService @Description: @Author: 老王 @Date: 2019/5/23 12:38 @Version: 1.0 */
public interface UserService {

  boolean insert(User record);

  User selectByName(String name);

  User selectByCondition(@Param("name") String name, @Param("password") String password);

  User selectById(Long id);

  User selectCodePhone(@Param("phone") String phone, @Param("code") String code);

  User selectCodeMail(@Param("mail") String mail, @Param("code") String code);

  int insertMail(
          @Param("name") String name,
          @Param("password") String password,
          @Param("phone") String phone,
          @Param("mail") String mail);
}
