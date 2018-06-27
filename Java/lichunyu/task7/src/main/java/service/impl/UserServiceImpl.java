package service.impl;

import dao.UserMapper;
import exception.LoginException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;
import utils.CookieUtil;
import utils.JwtUtil;
import utils.Md5Util;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    private static final long EXP = 60*60*1000; //token有效期60min
    private static final String REG = "^[a-zA-Z][a-zA-Z0-9_]*$"; //正则表达式.英文、数字、下划线，且英文开头
    private static final String INT = "^[0-9]*$"; //数字
    private static final String PHONE = "^1[3|5|7|8][0-9]{9}$"; //必须1开头的电话号码
    private static final String E_MAIL = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$"; //邮箱格式的正则表达式，格式必须为example@example.com
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) throws Exception {
           userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(String id) throws Exception {
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUserById(String id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) throws Exception {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUser(User user) throws Exception {
        return userMapper.getUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public void updatePhoto(User user) throws Exception {
        userMapper.updatePhoto(user);
    }


    /**
     * 注册时进行验证是否符合格式
     * @param user 用户
     * @return boolean 符合格式返回true
     * @throws Exception 不符合格式抛出异常
     */
    @Override
    public boolean register(User user) throws Exception {
        if(user.getName().isEmpty()||user.getPassword().isEmpty()||user.getQq().isEmpty()||user.getPhoneNum().isEmpty()||user.getEmail().isEmpty()){
            log.info("注册信息为空，重新注册");
            throw new LoginException("注册信息不能为空，请重新注册");
        }else if(!user.getName().matches(REG)){
            throw new LoginException("注册用户名只能为英文、数字、下划线，且必须英文开头");
        }else if(user.getName().length()>15){
            throw new LoginException("注册用户名称字符应不多于15个");
        }else if(user.getPassword().length()<6||user.getPassword().length()>16){
            throw new LoginException("密码过短或过长，请设置6-16位密码");
        }else if(!user.getQq().matches(INT) || (user.getQq().length()<8||user.getQq().length()>13) ){
            throw new LoginException("QQ号码必须是8-13位数字，请输入有效的QQ号码");
        } else if(!user.getEmail().matches(E_MAIL)){
            throw new LoginException("输入邮箱不符合格式!只能使用英文、数字、下划线、@，如：e_mail@example.com.cn");
        }else if(!user.getPhoneNum().matches(PHONE)){
            throw  new LoginException("手机号码必须是1开头的有效的手机号码");
        }else{
            return true;
        }
    }

    @Override
    public boolean login(User user, HttpServletResponse response) throws Exception {
        User user1 = userMapper.getUserByName(user.getName());
        if (user1 ==null){
            throw new LoginException("用户名不存在，请重新登录");
        }else if(Md5Util.verifySaltMd5(user.getPassword(),user1.getPassword())){
            Map<String,Object> payload = new HashMap<>();
            payload.put("id",user1.getId());
            payload.put("exp",System.currentTimeMillis()+EXP);
            String token = new JwtUtil().createJwt(payload);
            CookieUtil.addCookie(response,"token",token);
            return true;
        }
            return false;
    }

    @Override
    public boolean logout(User user) throws Exception {
        return false;
    }
}
