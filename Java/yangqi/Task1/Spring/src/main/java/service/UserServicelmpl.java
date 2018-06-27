package service;

import model.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.User;

import java.util.List;
//事务层
@Service("UserService")
public class UserServicelmpl implements UserService {

    @Autowired//自动注入配置文件里的bean
    private Userdao userdao;//这里是写入dao接口里面的增删查改，（自动写入）

    @Override // 方法重写注释
    //这里是写入 接口里面的增删查改方式，输出一个业务层 增删查改，回滚（返回）一个dao层的增删查改。
    public User findUserById(int id){
        return userdao.getUserById(id);
    }

    @Override //插入
    public boolean insertUser(User user){
        return userdao.getinsertUser(user);
    }

    @Override //删除
    public boolean deleteUser(int id) {
        return userdao.deleteId(id);
    }

    @Override//查询全部id
    public List<User> AllId(){
        return userdao.findAllId();
    }

    @Override//更新
    public boolean updateUser(User user){
        return userdao.UpdateUser(user);
    }

    @Override//根据姓名查询
    public User findName(User user){
        return userdao.findName(user);
    }
}
