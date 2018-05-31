package ServiceImpl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;
import utils.Md5;

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
    public void insertUser(User user){
        user.setCreate_time(System.currentTimeMillis());
        user.setUpdate_time(System.currentTimeMillis());
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
}
