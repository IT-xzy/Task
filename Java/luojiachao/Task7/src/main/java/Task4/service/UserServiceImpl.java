package Task4.service;


import Task4.cache.RedisCache;
import Task4.exception.MyException;
import Task4.mapper.UserMapper;
import Task4.pojo.User;
import Task4.unit.SHA;
import Task4.unit.Verification;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    //引入spring的配置文件获取上下文
    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //通过上下文和bean的名字获取userMapper实例
    private static UserMapper userMapper=context.getBean(UserMapper.class);
    @Autowired
    private  RedisCache redisCache;

    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public void add(User user) throws Exception {
        try{
            user.setCreate_at(System.currentTimeMillis());
            user.setUpdate_at(System.currentTimeMillis());
            userMapper.add(user);
        }
        catch (DuplicateKeyException e){
            //插入学员时可能发生的异常
            throw new DuplicateKeyException("Insert failed ,id exists.");
        }

    }      //System.out.println(studentDao);//NullPointerException,userMapper确实是null

    @Override
    public int findAll() {
        return userMapper.findAll();
    }

    @Override
    public int findByStudy() {
        int study;
        System.out.println("开始判断study缓存");
        if (redisCache.get("Study") != null) {

            study = (int) redisCache.get("Study");
            logger.info("已有study缓存,直接获取");
        } else {
            logger.info("没有study缓存，创建新的缓存");
            redisCache.set("Study",userMapper.findByStudy(),900);

            study = (int) redisCache.get("Study");
        }return study;

    }

    @Override
    public int findByWork() {
        int work;
        System.out.println("开始判断study缓存");
        if (redisCache.get("work") != null) {

            work = (int) redisCache.get("work");
            logger.info("work,直接获取");
        } else {
            logger.info("work，创建新的缓存");
            redisCache.set("work",userMapper.findByWork(),900);

            work = (int) redisCache.get("work");
        }return work;
    }
    //必须在所有使用dao的地方，包括调用它的service都要进行@Autowired注入，否则之后的注入就会失败
    //不用注解了，直接读取配置文件，getBean
    //System.out.println(studentDao);


    @Override
    public void regist(User user) {
        // TODO Auto-generated method stub
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.add(user);
    }

    @Override
    public User login(User entity) throws Exception {
        // TODO Auto-generated method stub
        String username = entity.getUsername();
        String password = entity.getPassword();
        boolean userp = Verification.regexPhone(username);
        boolean usere = Verification.regexEmailAddress(username);

        if (userp==true) {
            User user = userMapper.findByPhone(username);
            if (user == null) {
                throw new MyException("手机号错误");
            }
            //获得salt值
            String salt = user.getSalt();
            String pwd = user.getPassword();
            //判断账户密码是否匹配
            if (SHA.getSHAwithSalt(password, salt).equals(pwd)) {
                return user;
            }throw new MyException("密码错误");
        }
        if (usere==true) {
            User user = userMapper.findByEmail(username);
            if (user == null) {
                throw new MyException("邮箱输入错误");
            }
            //获得salt值
            String salt = user.getSalt();
            String pwd = user.getPassword();
            //判断账户密码是否匹配
            if (SHA.getSHAwithSalt(password, salt).equals(pwd)) {
                return user;
            }throw new MyException("密码错误");
        }
        User user=findByUsername(username);
        if (user == null) {
            throw new MyException("用户名输入错误");
        }
        //获得salt值
        String salt = user.getSalt();
        String pwd = user.getPassword();
        //判断账户密码是否匹配
        if (SHA.getSHAwithSalt(password, salt).equals(pwd)) {
            return user;
        }throw new MyException("密码错误");

    }




    @Override
    public boolean delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public User findByEmail(String email) throws Exception{
        return userMapper.findByEmail(email);
    }

    @Override
    public User findByPhone(String phone) throws Exception{
        return userMapper.findByPhone(phone);
    }
    @Override
    public User findById(int id) {
        User user;
        System.out.println("开始user判断缓存");
        if (redisCache.get("user"+id) != null) {

            user = (User) redisCache.get("user"+id);
            logger.info("已有user缓存,直接获取"+id);
        } else {
            logger.info("没有user缓存，创建新的缓存"+id);
            redisCache.set("user"+id,userMapper.findById(id),900);

            user = (User) redisCache.get("user"+id);
        }return user;
    }

    @Override
    public List<User> findByName(String name) throws Exception {
        return userMapper.findByName(name);
    }

    @Override
    public boolean update(User user) throws Exception {
        user.setUpdate_at(System.currentTimeMillis());
        return userMapper.update(user);
    }

    @Override
    public void reset() throws Exception {
        userMapper.reset();
    }
    public List<User> list(){
        return userMapper.list();
    }

    @Override
    public User findByUsername(String username) throws Exception {
        return userMapper.findByUsername(username);
    }

}