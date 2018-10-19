package mybatis_spring.dao;

import mybatis_spring.POJO.Trainee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/*让测试在Spring环境下运行*/
@RunWith(SpringJUnit4ClassRunner.class)
/*自动注解方式加载Spring配置文件*/
@ContextConfiguration("classpath:Springconfig.xml")

@Component
public class TraineeMapperTest {
    @Autowired(required = false)
    private TraineeMapper traineeMapper;
    private Long create_time = System.currentTimeMillis();

    @Test
    public void addTn() {
        Trainee trainee=new Trainee(create_time,create_time,25,"张四","男","9531","link2");
        traineeMapper.addTn(trainee);
        System.out.println("学员ID："+trainee.getT_id());
    }

    @Test
    public void updateByNo() throws Exception {
        Trainee trainee=new Trainee(create_time,27,"赵三","男","9527","link3");
        int result=traineeMapper.updateByNo(trainee);
        if(result==0){
            System.out.println("更新失败"+false);
        }else {
            System.out.println("更新成功"+true);
        }
    }

    @Test
    public void deleteById() throws Exception {
        int result=traineeMapper.deleteById(2);
        System.out.println(result);
        if(result==1){
            System.out.println("删除成功"+true);
        }else {
            System.out.println("删除失败"+false);
        }
    }

    @Test
    public void getInfoByNo() throws Exception {
        String No="9532";
        Trainee trainee=traineeMapper.getInfoByNo(No);
        System.out.println("学号"+No+"学员信息："+trainee);
    }

    @Test
    public void getInfoByName() throws Exception {
        String name="赵三";
        Trainee trainee=traineeMapper.getInfoByName(name);
        System.out.println("学员"+name+"信息："+trainee);
    }

    @Test
    public void getRecentInfo() throws Exception {
        List<Trainee> traineeList=traineeMapper.getRecentInfo();
        for(Trainee each:traineeList){
            System.out.println(each);
        }
    }

    @Test
    public void getLink() throws Exception{
        String name="张四";
        String No="9532";
        Trainee trainee=traineeMapper.getLink(name,No);
        System.out.println("学员"+name+"，学号"+No+"；报名链接："+trainee.getRegisterLink());
    }


 /*
        手动设置配置文件的方式 ，和注解方式同样的效果
        @Before
        public void initialize(){
            ApplicationContext cont=new ClassPathXmlApplicationContext("Springconfig.xml");
            traineeMapperTest =(TraineeMapperTest) cont.getBean("traineeMapperTest");
        }
       @Test
        public void addTn() {
            trainee=new Trainee(25,"张四","男","9530","link2");
            traineeMapperTest.traineeMapper.addTn(trainee);
            System.out.println("学员ID："+trainee.getT_id());
        }*/
}