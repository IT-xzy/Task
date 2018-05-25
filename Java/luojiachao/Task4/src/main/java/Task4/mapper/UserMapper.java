package Task4.mapper;



import Task4.pojo.User;


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

//    List<Student> list(Page page);
//
//    int total();


}