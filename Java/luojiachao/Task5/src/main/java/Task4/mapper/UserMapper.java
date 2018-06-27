package Task4.mapper;



import Task4.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserMapper {

    void add(User user);

    int findAll();

    int findByStudy();

    int findByWork();

    boolean delete(int id);
    //根据id查询
    User findById(int id);
    //根据姓名模糊查询
    List<User> findByName(String name) throws Exception;

    boolean update(User user) throws Exception;

    void reset() throws Exception;

    List<User> list();

    User findByUsername(String username) throws Exception;
    //用户注册
    void regist(User user);
    //用户登录
     User findUserByName(@Param("username")String username, @Param("password")String password);




//    List<Student> list(Page page);
//
//    int total();


}