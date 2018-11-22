import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.service.Student4Service;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("ALL")
@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStudent4Mapper {
    Logger logger = LogManager.getLogger(TestStudent4Mapper.class.getName());
    @Autowired
    Student4Mapper student4Mapper;
    @Autowired
    @Qualifier("NoCache")
    Student4Service student4Service;


    @Test//新增学员
    public void testInsert() {

        for (int i = 0; i < 20; i++) {
            Student4 student4 = new Student4();
            student4.setName(RandomStringUtils.randomAlphanumeric(10));
            student4.setImg("/images/task42.jpg");
            student4.setProfessionId(1l);
            student4.setState(true);//学习方向1：前端开发方向2:后端反向2：0运维方向
            student4.setPosition("前端工程师");
            student4.setSalary("10K");//入学门槛0：一星，2星，最多5星
            student4.setGraduateAt(System.currentTimeMillis()-3);//0：1星,1:二星
            student4.setResume("百度技术总监：互联网基础服务领域，从事虚拟主机、" +
                    "云服务器、域名。曾任新网高级技术经理，负责技术研发、团队管理和建设");
            student4.setCreateBy("波波维奇");
            student4.setCreateAt(System.currentTimeMillis());
            student4.setUpdateAt(System.currentTimeMillis());
            student4.setUpdateBy("");
            logger.info("添加结果：" + student4Mapper.insert(student4));
        }

    }
    @Test
    public void test(){
        Student4 student4 = new Student4();
        student4.setPosition("前端工程师");
        student4.setState(false);
//        long count = student4Service.CountSelective(student4);
       System.out.println("总人数：" + student4Service.CountSelective(student4.getPosition(),true));
        student4 = student4Service.findStudent4ById(10L);
        logger.info("findStudent4ByIdStudent4ById:student4===="+student4.toString());
    }
}
