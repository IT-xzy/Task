package util;

import domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UsersService;
import util.desEncryption.DesUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *@Description: 该工具类作用是取出cookie中的用户名，并且查询相关信息，存入model类，在jsp页面做展示
 *@author:
 */
@Service
public class GetUserUtil {

    @Autowired
    public UsersService usersService;

    /**
     * @param request
     */
    //此处为何会用model类接收，因为日后可能会不仅仅显示用户名，所以日后复杂度提高时，model类接收最方便
    public Users getUser(HttpServletRequest request) {
        //从request中取出cookie数组
        Cookie[] cookies = request.getCookies();
        //声明个Usres模型接收cookie的值
        Users user = new Users();
        //如果cookie数组为空，证明不存在，返回空。
        if (cookies == null) {
            return user;
        }
        else {
            //循环访问cookie数组，根据name找到需要的cookie
            for (Cookie cookie : cookies) {
                try {
                    if (cookie.getName().equals("username")) {

                        //把username解密
                        String username = DesUtil.decrypt(cookie.getValue());

                        //此处无法直接return值，必须用变量接收，跳出循环
                        user = usersService.getByName(username);
                        break;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            //根据结果返回模型值。
            return  user;
        }
    }
}
