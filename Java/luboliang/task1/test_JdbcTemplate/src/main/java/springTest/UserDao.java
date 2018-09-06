package springTest;

public interface UserDao {

    long add(User user);
    boolean delete(long id);
    boolean update(User user);
    User select(long id);
    String findUser();


}
