package mapper;

import org.springframework.web.bind.annotation.ModelAttribute;
import pojo.User;

import java.util.List;

/**
 * mybatis CRUD （DAO层）
 */

public interface UserDAO {

    void insert(User user);
    int delete(int id);
    User select(int id);
    List<User> selectByName(String name);
    int update(User user);
}
