package mybatis;

import javax.annotation.Resource;
import java.util.List;
@Resource
public interface Mapper {
    public User findUser(long id);

    public List<User> findAll();

    public boolean deleteUser(long id);

    public long addUser(User user);

    public boolean updateUser(User user);


}
