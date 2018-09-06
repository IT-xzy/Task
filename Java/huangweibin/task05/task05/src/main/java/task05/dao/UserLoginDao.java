package task05.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import task05.pojo.UserLogin;

@Repository
public interface UserLoginDao {

     UserLogin login(UserLogin userLogin);

     void register(UserLogin userLogin);

     UserLogin queryByName(String name);

     void insertDes(String s);

     void updateDes(@Param("despassword")String despassword,@Param("id")int id);



}
