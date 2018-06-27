package Task4.service;

import Task4.mapper.PositionMapper;
import Task4.mapper.UserMapper;
import Task4.pojo.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    //引入spring的配置文件获取上下文
    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //通过上下文和bean的名字获取userMapper实例
    private static PositionMapper positionMapper=context.getBean(PositionMapper.class);



    public Position findById(int id) {
        return positionMapper.findById(id);
    }

    public Position findByClass(String classes){
        return positionMapper.findByClass(classes);
    }

    @Override
    public List<Position> list() {
        return positionMapper.list();
    }

    @Override
    public int findAll() {
        return positionMapper.findAll();
    }


}
