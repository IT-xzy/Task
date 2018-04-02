import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.IOException;
import java.util.List;

public interface UserMapper2 {

        @Select("select * from user where id=#{id}")
        public User2 findUserById(int ID) throws IOException;//查询
        @Select("select * from user where username like  '%${value}%'")
        public List<User2> findUserByname(String name)throws IOException;
        @Delete("delete from user where id=#{id}")
        public  void deleteUser(int id) throws  Exception;//删除指定id的记录
        @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
        public void updateUser(User2 user2) throws Exception;//更改指定id的数据

}
