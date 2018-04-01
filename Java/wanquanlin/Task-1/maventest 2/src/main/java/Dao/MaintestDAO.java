package Dao;
import POJO.User;
import java.io.IOException;
import java.util.List;
public interface MaintestDAO {
        public User findUserById(int id) throws IOException;//查询
        public void insertUser(String s, User user) throws  Exception;//增加
        public  void deleteUser(int id) throws  Exception;//删除指定id的记录
        public void updateUser(User user) throws Exception;//更改指定id的数据
}
