package Task4.service;


import Task4.mapper.UserMapper;
import Task4.pojo.User;
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
//    @Autowired
//    private static UserMapper userMapper;

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
        return userMapper.findByStudy();
    }

    @Override
    public int findByWork() {
        return userMapper.findByWork();
    }
    //必须在所有使用dao的地方，包括调用它的service都要进行@Autowired注入，否则之后的注入就会失败
    //不用注解了，直接读取配置文件，getBean
    //System.out.println(studentDao);




    @Override
    public boolean delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
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
    };

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