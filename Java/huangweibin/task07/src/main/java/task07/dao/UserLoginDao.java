package task07.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import task07.pojo.UserLogin;

@Repository
public interface UserLoginDao {

     UserLogin login(UserLogin userLogin);

     void register(UserLogin userLogin);

     UserLogin queryByName(String name);

     void insertDes(String s);

     void updateDes(@Param("despassword")String despassword,@Param("id")int id);

     String registerQueryName(String name);

     String registerQueryPhoneNumber(String phone_number);

     String registerQueryEmail(String email);

     void updateHeadPhoto(@Param("name") String name,@Param("head_photo") String head_photo);


}
