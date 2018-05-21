package lujing.service;

import lujing.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/5 14:42
 */
@Service
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param user
     * @return
     */
    
    String  findUser (HttpSession session ,HttpServletResponse response , User user);
    
    String findUserByName(String name);
    
    String siginUser (User record , String RecordPassWord);
    
    
}
