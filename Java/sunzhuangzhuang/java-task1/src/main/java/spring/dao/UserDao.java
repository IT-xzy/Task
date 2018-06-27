package spring.dao;

import spring.demo.User;
import java.util.List;

public interface UserDao {
        Integer add(User user);
        void delete(int id);
        void update(User user);
        List<User> select(User user);
        List<User> query();
}
