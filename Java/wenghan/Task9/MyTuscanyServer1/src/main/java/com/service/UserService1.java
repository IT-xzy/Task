package com.service;

import com.Plug.PageBean;
import com.pojo.User;
import org.oasisopen.sca.annotation.Remotable;
import java.util.List;

@Remotable
public interface UserService1 {
    //添加一条记录
     boolean addUser(User user);
    //根据id删除一条记录
     boolean cutUserById(long id);
    //更新一条记录
     boolean reviseUserById(User user);
    //根据id查询一条记录
    User queryUserById(long id);
    //查询全表
     List<User> queryUser();
    //查询分页信息
    PageBean findAllUserWithPage(int pageNum, int pageSize);
}
