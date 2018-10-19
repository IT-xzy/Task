package service.Impl;

import domain.dao.UsersMapper;
import domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper mapper;

    @Override
    public int insert(Users user){
        int result = mapper.insert(user);
        return result;
    }

    @Override
    public int deleteByName(String username){
        int result = mapper.deleteByName(username);
        return result;
    }

    @Override
    public int update(Users user){
        int result = mapper.update(user);
        return result;
    }

    @Override
    public Users getByName(String username){
        Users user = mapper.getByName(username);
        return user;
    }

    @Override
    public int updateloginTime(Users user){
        int result = mapper.updateloginTime(user);
        return result;
    }
}
