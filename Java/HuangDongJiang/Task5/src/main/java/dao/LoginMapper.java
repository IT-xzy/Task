package dao;

import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("loginMapper")
public interface LoginMapper {
	/**
	 * 通过取出用户来获得用户的相关信息
	 * @param name
	 * @return
	 */
	User judgeUser(String name);
}
