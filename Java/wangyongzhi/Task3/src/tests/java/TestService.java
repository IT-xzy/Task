import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import model.Network1;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.NetworkService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestService {
    public static Logger logger = LogManager.getLogger(TestService.class);

    @Autowired
    public NetworkService service;


    //测试删除方法
    @Test
    public void delete() {
        Boolean result = service.deleteById(22L);
        if (result) {
            System.out.println("删除成功");

        } else {
            System.out.println("删除失败");
        }
    }

    //测试插入数据返回主键方法
    @Test
    public void insert() {
        Network1 one = new Network1();

        one.setName("Jack");
        one.setQQ("35135145");
        one.setType("PM");
        one.setEnrolmentTime("20181112");
        one.setGraduate("东海大学");
        one.setReportLink("www.dfgdxcvcbfgs.erfr");
        one.setWish("实现自己");
        one.setSenior("李恪非");
        one.setHowKnow("微信");
        one.setCreateAt(201845526L);
        one.setUpdateAt(201825225L);

        int result = service.insert(one);
        System.out.println("插入的数据ID是：" + one.getLineId());
    }

    //测试更新数据返回布尔值方法
    @Test
    public void update() {
        Network1 one = new Network1();
        one.setLineId(24L);
        one.setName("Helen");
        one.setQQ("35135145");
        one.setType("PM");
        one.setEnrolmentTime("20181112");
        one.setGraduate("东海大学");
        one.setReportLink("www.dfgdxcvcbfgs.erfr");
        one.setWish("实现自己");
        one.setSenior("李恪非");
        one.setHowKnow("微信");
        one.setCreateAt(201845526L);
        one.setUpdateAt(201825225L);

        Boolean result = service.update(one);
        if (result) {
            System.out.println("更新成功");

        } else {
            System.out.println("更新失败");
        }
    }

    //测试根据ID姓名查询单条数据
    @Test
    public void selectByIdName() {
        Network1 one = new Network1();
        one.setLineId(1L);
        one = service.selectByIdName(one);
        Assert.assertEquals("李思明", one.getName());

        one.setLineId(null);
        one.setName("张强");
        one = service.selectByIdName(one);
        Assert.assertEquals("874616216", one.getQQ());
    }

    //测试查询所有数据方法
    @Test
    public void selectAll(){
        List ones = service.selectAll();
        Network1 one = (Network1) ones.get(0); //索引从0开始
        Assert.assertEquals("李思明", one.getName());
    }



}
