package mybatis.Impl;

import mybatis.DAO.UserDao;
import mybatis.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;
    //需要向dao实现类中注入SqlSessionFactory，由于没和Spring整合，这里通过构造函数注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
//    @Override
//    public User findUserById(int id) throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = sqlSession.selectOne("test.find", id);
//        //释放资源
//        sqlSession.close();
//        return user;
//    }
    
//    @Override
//    public List<User> findUserByName(String name) throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> list = sqlSession.selectList("test.findUserByName", name);
//        //释放资源
//        sqlSession.close();
//        return list;
//    }
    

//
//    @Override
//    public void deleteUser(int id) throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.delete("test.deleteUser", id);
//        sqlSession.commit();//执行插入要先commit
//        sqlSession.close();
//    }
    
//    @Override
//    public void updateUser(User user) throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.update("test.updateUser", user);
//        sqlSession.commit();//执行插入要先commit
//        sqlSession.close();
//    }
    
    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();//执行插入要先commit
        sqlSession.close();
    }
    
}
