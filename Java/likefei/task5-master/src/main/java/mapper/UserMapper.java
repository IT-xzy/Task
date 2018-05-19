package mapper;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import pojo.User;

import java.sql.ResultSet;

public interface UserMapper {

    void insert(User user);

    User getbyname(String name);

    User getname(String name);
}
