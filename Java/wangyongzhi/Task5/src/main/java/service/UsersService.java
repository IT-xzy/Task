package service;

import model.Users;

public interface UsersService {

    public int insert(Users user);

    public int deleteByName(String username);

    public int update(Users user);

    public Users getByName(String username);

    public int updateloginTime(Users user);
}
