package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void updateUserPictureByName(String userName, String pictureDir) {
	    userMapper.updateUserPictureByName(userName, pictureDir);
	}
}
