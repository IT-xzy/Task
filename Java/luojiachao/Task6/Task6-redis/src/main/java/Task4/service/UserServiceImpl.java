package Task4.service;


import Task4.mapper.UserMapper;
import Task4.pojo.User;
import Task4.unit.MemcacheUnit;
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
    private MemcacheUnit memcacheUnit;

//    private static MemcacheUnit memcacheUnit = context.getBean(MemcacheUnit.class);
//    @Autowired
//    private static UserMapper userMapper;
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
    public int findByStudy() throws Exception {
        int study;
        System.out.println("开始判断study缓存");
        if (memcacheUnit.get("Study") != null) {

            study = (int) memcacheUnit.get("Study");
            logger.info("已有study缓存,直接获取");
        } else {
            logger.info("没有study缓存，创建新的缓存");
            memcacheUnit.set("Study",userMapper.findByStudy(),900);

            study = (int) memcacheUnit.get("Study");
        }return study;

    }

    @Override
    public int findByWork() throws Exception {
        int work;
        System.out.println("开始判断study缓存");
        if (memcacheUnit.get("work") != null) {

            work = (int) memcacheUnit.get("work");
            logger.info("work,直接获取");
        } else {
            logger.info("work，创建新的缓存");
            memcacheUnit.set("work",userMapper.findByWork(),900);

            work = (int) memcacheUnit.get("work");
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
    public User login(String username) throws Exception {
        // TODO Auto-generated method stub
        return  userMapper.findByUsername(username);

    }



    @Override
    public boolean delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public User findById(int id) throws Exception {
        User user;
        System.out.println("开始user判断缓存");
            if (memcacheUnit.get("user"+id) != null) {

                user = (User) memcacheUnit.get("user"+id);
                logger.info("已有user缓存,直接获取"+id);
            } else {
                logger.info("没有user缓存，创建新的缓存"+id);
                memcacheUnit.set("user"+id,userMapper.findById(id),900);

                user = (User) memcacheUnit.get("user"+id);
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



    ;

//    @Override
//    public List<student> list(Page page) {
//        // TODO Auto-generated method stub
//        return userMapper.list(page);
//    }
//
//    @Override
//    public int total() {
//        return userMapper.total();
//    }
}