package jnshu.dao;

import jnshu.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface UserDao {
    //    增加方法，返回值为int，形参类型为user
    int add(User user);

    //    删除方法，返回值为int，形参类型为int
    int delete(int id);

    //    修改方法，返回值为int，形参为user
    int update(User user);

    //    查询全部方法，返回值为int，形参为user
    List<User> findAll();

    //    查询的单个方法，返回值为int，形参为user
    User findById(int id);

    //该分页sql语句的执行方法，查询每页一定量的数据
    List<User> selectPage(@Param("startNum") int start, @Param("pageSize") int pageSize);

    //查询数量sql语句的执行方法
    int selectCount();
}
