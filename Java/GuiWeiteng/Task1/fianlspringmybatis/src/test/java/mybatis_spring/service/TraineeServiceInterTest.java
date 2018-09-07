package mybatis_spring.service;

import mybatis_spring.POJO.Trainee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;


/*让测试在Spring环境下运行*/
@RunWith(SpringJUnit4ClassRunner.class)
/*自动注解方式加载Spring配置文件*/
@ContextConfiguration("classpath:Springconfig.xml")

@Service
public class TraineeServiceInterTest {
    @Autowired(required = false)
    TraineeServiceInter traineeServiceInter;
    private Long create_time =System.currentTimeMillis();

    @Test
    public  void AddTn() throws Exception{
        Trainee trainee=new Trainee(create_time,create_time,25,"张四","男","9531","link2");
        traineeServiceInter.addTn(trainee);
        System.out.println("学员ID："+trainee.getT_id());

    }
    @Test
    public void deleteBtNo() throws Exception {
        int result= traineeServiceInter.deleteById(100);
        System.out.println(result);
        if(result==1){
            System.out.println("删除成功"+true);
        }else {
            System.out.println("删除失败"+false);
        }
    }

    @Test
    public void updateByNo() throws Exception {
        Trainee trainee=new Trainee(create_time,26,"赵二","男","9527","link3");
        int result=traineeServiceInter.updateByNo(trainee);
        if(result==0){
            System.out.println("更新失败"+false);
        }else {
            System.out.println("更新成功"+true);
        }
    }

    @Test
    public void getInfoByNo() throws Exception {
        String No="9529";
        Trainee trainee= traineeServiceInter.getInfoByNo("9527");
        System.out.println("学号"+No+"学员信息："+trainee);
    }

    @Test
    public void getInfoByName() throws Exception {
        String name="王五";
        Trainee trainee= traineeServiceInter.getInfoByName(name);
        System.out.println("学员"+name+"信息："+trainee);
    }

    @Test
    public void getRecentInfo() throws Exception {
        List<Trainee> traineeList= traineeServiceInter.getRecentInfo();
        for(Trainee each:traineeList){
            System.out.println(each);
        }
    }

}