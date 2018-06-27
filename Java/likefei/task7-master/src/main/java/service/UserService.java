package service;

import org.springframework.stereotype.Service;
import pojo.User;
import utils.json.JsonResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Service
public interface UserService {
    JsonResult testphonecode(HttpSession httpSession,String phonecode,User user,HttpServletRequest httpServletRequest);
    JsonResult phonecode(HttpSession httpSession,User user);
    JsonResult testemailcode(HttpSession httpSession, String emailcode, User user);
    JsonResult emailcode(HttpSession httpSession,User user);
    JsonResult testcommon(User user,String signcode,HttpSession httpSession);
    JsonResult phonelogin(User user,String phonecode,HttpSession httpSession);
    JsonResult emaillogin(User user,String emailcode,HttpSession httpSession,String signcode);
    JsonResult commonlogin(User user,String signcode,HttpSession httpSession);
    boolean emailtest(User user);
    boolean nametest(User user);
    boolean phonenumbertest(User user);
    boolean signcodetest(HttpSession httpSession,String signcode);
    boolean passwordtest(User user);
    Long insert(User user) throws Exception;
}
