package mybatis.test;


import mybatis.datasource.DataConnection;
import mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MyBatisTest {

    public DataConnection dataConn=new DataConnection();
    @Test
    public void TestSelect() throws Exception{
        SqlSession sqlSession= dataConn.getSqlSession();
        User user=sqlSession.selectOne("test.findUserById",6);
        //System.out.println("id:"+user.getId());
        //System.out.println("name:"+user.getName());
        //System.out.println("emp:"+user.getEmp());
        //System.out.println("salary:"+user.getSalary());
//        return user;
        System.out.println(user.toString());
        sqlSession.close();
    }
    @Test
    public void TestSelectMore() throws Exception{
        SqlSession sqlSession= dataConn.getSqlSession();
        List<User> userList = sqlSession.selectList("test.findUserByName","小");
        for (int i=0;i<userList.size();i++){
        User u=userList.get(i);
//        User user=sqlSession.selectOne("test.findUserByName","小");
//        System.out.println("id:"+u.getId());
//        System.out.println("name:"+u.getName());
//        System.out.println("emp:"+u.getEmp());
//        System.out.println("salary:"+u.getSalary());
            System.out.println(userList.toString());}
//        return user;
        sqlSession.close();
    }

    @Test
    public void TestInsert() throws Exception{
        SqlSession sqlSession=dataConn.getSqlSession();
        User user = new User();
        user.setName("黄海");
        user.setEmp("高级运维工程师");
        user.setSalary(9800.85);
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestUpdate() throws  Exception{
        SqlSession sqlSession = dataConn.getSqlSession();
        User user = new User();
        user.setName("小庄");
        user.setEmp("分公司副总经理");
        user.setSalary(58995.55);
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestDelete() throws IOException {
SqlSession sqlSession=dataConn.getSqlSession();
sqlSession.delete("test.deleteUser","黄海");
sqlSession.commit();
sqlSession.close();
    }
}
