package task07.services;

import task07.pojo.UserLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserLoginServices {

        UserLogin login(UserLogin userLogin);

        void  register(UserLogin userLogin);

        UserLogin queryByName(String name);

        void insertDes(String s);

        void updateDes(String despassword,int id);


        String registerQueryName(String frontName);

        String registerQueryPhoneNumber(String phoneNumber);

        String registerQueryEmail (String email);

        boolean UserRegister(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse,
                          UserLogin userLogin,String reKey);

        boolean UserLogin(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse,
                          UserLogin userLogin);

}
