package task05.services;

import task05.pojo.UserLogin;

public interface UserLoginServices {

        UserLogin login(UserLogin userLogin);

        void  register(UserLogin userLogin);

        UserLogin queryByName(String name);

        void insertDes(String s);

        void updateDes(String despassword,int id);


}
