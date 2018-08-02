import contror.SqlS;
import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/24$ 10:22$
 **/
public class TestTwo {

    SqlS sqlS=new SqlS();
    SqlSession sqlSession=sqlS.getSqlSession();
    UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    User user = new User();
    //增加用户，返回id
    @Test
    public void testAddUser() {
        user.setName("大米粒");
        user.setQq(2222222);
        user.setType("op");
        userMapper.addUser(user);
        long id =userMapper.selectUser(user).getId();
        System.out.println("添加用户的新id" + id);
    }

    //删除用户
    @Test
    public void testDeleteUser() {
        user.setId(3L);
        boolean b = userMapper.deleteUser(user);
        System.out.println("删除用户====" + b);
    }

    //更新用户信息
    @Test
    public void testUpdateUser() {
        user.setQq(33333);
        user.setName("一加");
        user.setType("java");
        boolean b = userMapper.updateUser(user);
        System.out.println("更新用户======" + b);
    }

    //通过name查询用户
    @Test
    public void testSelectUser() {
        user.setName("二米粒");
        User user1 = userMapper.selectUser(user);
        System.out.println("根据姓名选择用户======" + user1.toString());
    }

    @Test
    public void testSelectUser1() {
        user.setName("杯子");
        List<User> list = new ArrayList<>();
        list = userMapper.selectUsers(user);
        System.out.println("根据姓名选择用户======" + list.toString());
    }

    //批量插入
    @Test
    public void testAddAll() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            user.setName("唐僧");
            user.setQq(12123131);
            user.setType("web");
            list.add(user);
        }
        userMapper.addAll(list);
        System.out.println("批量插入");
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}
