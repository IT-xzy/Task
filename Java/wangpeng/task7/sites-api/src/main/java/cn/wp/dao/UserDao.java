package cn.wp.dao;

import cn.wp.model.User;
import org.apache.ibatis.annotations.Param;

/** @author 老王 */
public interface UserDao {

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
