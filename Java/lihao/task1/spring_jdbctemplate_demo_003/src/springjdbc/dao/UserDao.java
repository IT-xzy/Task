package springjdbc.dao;

import springjdbc.pojo.User;

import java.util.List;

/**
 * @author lihoo
 * @Title: UserDao
 * @ProjectName spring_demo_003
 * @Description: TODO
 * @date 2018/7/14-18:20
 */


public interface UserDao {

    List<User> findAllUser();

    void create(String id, String name, String password);

    void execInsert(String sql);
}
