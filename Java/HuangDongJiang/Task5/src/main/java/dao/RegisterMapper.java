package dao;

import org.springframework.stereotype.Repository;
import pojo.User;

@Repository
public interface RegisterMapper {
	/**
	 * 注册用户
	 * @param user
	 */
	void addUser(User user);
}
