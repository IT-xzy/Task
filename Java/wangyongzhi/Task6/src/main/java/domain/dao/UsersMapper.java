package domain.dao;


import domain.entity.Users;

public interface UsersMapper {

    public int insert(Users user);

    public int deleteByName(String username);

    public int update(Users user);

    public Users getByName(String username);

    public int updateloginTime(Users user);

}
