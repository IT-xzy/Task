package service;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
	public void updateUserPictureByName(String userName, String pictureDir);
}
