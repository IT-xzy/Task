public interface UserMapper {
    //根据id查询用户信息
    public User findUserById(int id)throws Exception;
    public User findUserByName(String name)throws Exception;
    public void insertUser (User user) throws Exception;
    public void deleteUser (int id) throws Exception;
    public void updateUser (User user)throws Exception;
}
