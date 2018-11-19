package task7.dao;

        import task7.pojo.User;
        import task7.pojo.UserImpl;

public interface UserDao1 {
    UserImpl queryUser1(Integer id);

    Integer saveUser(User user);

    Integer updateUser(User user);
}
