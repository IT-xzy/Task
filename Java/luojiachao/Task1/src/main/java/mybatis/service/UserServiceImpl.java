package mybatis.service;

import mybatis.mapper.UserMapper;
import mybatis.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import mybatis.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static UserMapper userMapper=context.getBean(UserMapper.class);



//    @Autowired
//    private static UserMapper userMapper;



    @Override
    public int add(User user) throws Exception {
        try{
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.add(user);
        return user.getid();}
        catch (DuplicateKeyException e){
        //插入学员时可能发生的异常
        throw new DuplicateKeyException("Insert failed ,id exists.");
    }

    }      //System.out.println(studentDao);//NullPointerException,studentDao确实是null
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
        return null;
    }

    @Override
    public boolean update(User user) throws Exception {
        return userMapper.update(user);
    }

    @Override
    public void reset() throws Exception {
        userMapper.reset();
    }
}

