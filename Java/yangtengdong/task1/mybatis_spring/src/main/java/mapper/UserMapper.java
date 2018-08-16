package mapper;

import java.util.List;

public interface UserMapper {
    public User findUserById(int id) throws Exception;
    public User findUserByName(String name)throws Exception;
    public List<User> findUserByName1(String name)throws Exception;//模糊查询
    public void Insert(User user)throws Exception;
    public void update(User user)throws Exception;
    public void delete(String name);
}
