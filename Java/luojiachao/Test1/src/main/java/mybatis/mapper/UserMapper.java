package mybatis.mapper;

import mybatis.modle.User;

import java.util.List;

public interface UserMapper {

    void add(User user);

    boolean delete(int id);
        //根据id查询
    User findById(int id);
        //根据姓名模糊查询
    List<User> findByName(String name) throws Exception;

    boolean update(User user) throws Exception;

    void reset() throws Exception;

    }