import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import com.mybatis.util.DataUtils;
import com.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * mybatis的CRUD单元测试
 * created by suger on 2018/9/26
 */
public class UserDaoTest {

    static Logger log = Logger.getLogger(UserDaoTest.class);
    static  SqlSession sqlSession = null;

    User user = new User(DataUtils.getName(),DataUtils.getNumber(10),DataUtils.getProfession(),
            DataUtils.getDateTime(), DataUtils.getCollege(),DataUtils.getIntNumber(),DataUtils.getLink(),
            DataUtils.getWish(), DataUtils.getName(),DataUtils.getWay(),DataUtils.getTime(),DataUtils.getTime());
    @Test
    public void insert() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.insert(user);
        long id = user.getUserId();
        log.info(id);
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void update() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        user.setProfession(DataUtils.getProfession());
        user.setUpdateAt(DataUtils.getTime());
        user.setUserId(10000L);
        int i = userDao.update(user);
        boolean flag = false;
        if(i!=0){
            flag= true;
        }
        log.info(flag);
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void delete() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        long userId = 20000L;
        int i = userDao.delete(userId);
        boolean flag = false;
        if(i!=0){
            flag= true;
        }
        log.info(flag);
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void getUsers() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
       log.info(userDao.getUsers());
        if(sqlSession != null){
            sqlSession.close();
        }

    }

    @Test
    public void getByName() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        String userName = DataUtils.getName();
        log.info(userDao.getUserByName(userName));
        if(sqlSession != null){
            sqlSession.close();
        }

    }

    @Test
    public void getUserByonlineId() throws Exception {
        sqlSession = MybatisUtils.getSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int onlineId = DataUtils.getIntNumber();
        log.info(userDao.getUserByonlineId(onlineId));
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}