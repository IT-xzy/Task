package service;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;

import java.util.List;

/**
 * 实现业务层进行判断CRUD是否成功
 * 添加数据返回ID，删除或更新数据返回True/False
 */

public class UserServiceImpl implements UserService {
    @Autowired
    UserService userService;

    /**
     * 插入数据
     * @param user
     */
    public int insert(User user) {
            int count =userService.insert(user);
            return  count;
    }

    /**
     *删除数据
     * @param id
     * @return
     */
    public int delete(int id) {
        int count=userService.delete(id);
        return count;
    }

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    public User select(int id) {
        User user =userService.select(id);
        return user;
    }

    public List<User> selectByName(String name) {
        List<User> users =userService.selectByName(name);
        return users;
    }

    public int update(User user) {
         int count =userService.update(user);
        return count;
    }


//    添加数据后返回id

    public int returnId(User user){
        userService.insert(user);
        return user.getId();
    }

    //    删除数据后返回True/False

    public boolean isDelete(int id){

        int count = userService.delete(id);
        if(count>0)
            return true;

        else
            return false;
        }

//     更新数据后返回True/False
    public boolean isUpdate(User user){
        int count = userService.update(user);
        if(count>0)
            return true;
        else
            return false;
    }


}
