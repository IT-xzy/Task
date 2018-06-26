
public interface SignMapper {
    public Sign findUserById(int id);
    public Sign findUserByName(String name);
    public int insertUser(Sign user);
    public int deleteUserById(int id);
    public int updateUserById(Sign user);
    public int deleteUserByName(String name);


}
