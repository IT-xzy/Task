package ServiceImpl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;
import utils.Md5;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean nameTest(String name){
        if (userMapper.selectName(name)==null){
            return true;
        }
        else return false;
    }

    @Override
    public void insertUser(User user,String icon){
        user.setCreate_time(System.currentTimeMillis());
        user.setUpdate_time(System.currentTimeMillis());
        user.setIcon(icon);
        String  user_password= user.getPassword();
        Md5 md5 = new Md5();
        List<String> list = md5.passwordsalt(user_password);
        user.setSalt(list.get(0));
        user.setPassword(list.get(1));
        userMapper.insertUser(user);
    }

    @Override
    public boolean passwordTest(User user){
         String salt = userMapper.selectName(user.getName()).getSalt();
         String pass_word = user.getPassword();
         Md5 md5 = new Md5();
         String pd = md5.passwordtest(pass_word,salt);
         return pd.equals(userMapper.selectName(user.getName()).getPassword());
    }

    @Override
    public boolean checkCode(String code,String e_code,HttpSession session){
        String phone_code = (String) session.getAttribute("phone_code");
        String mail_code = (String) session.getAttribute("mail_code");
        if (code.equals(phone_code)&&e_code.equals(mail_code)){
            return true;
        }else return false;
    }
}
