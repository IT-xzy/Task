import com.jnshu.entity.Profession;
import com.jnshu.mapper.ProfessionMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProfessionMapper {
    Logger logger = LogManager.getLogger(TestProfessionMapper.class.getName());
    @Autowired
    ProfessionMapper professionMapper;
    
    @Test//新增职业
    public void testInsert() {
        for (int i = 0; i < 5; i++) {
            Profession profession = new Profession();
            profession.setStudentId(2l);
            profession.setImg("D:\\task4Images\task42");
            profession.setDirection((byte) 0);//学习方向1：前端开发方向2:后端反向2：0运维方向
            profession.setJob("运维工程师");
            profession.setDoor((byte) 5);//入学门槛0：一星，2星，最多5星
            profession.setDifficulty((byte) 1);//0：1星,1:二星
            profession.setGrowth("1-2");
            profession.setYears(4);//工作年限1，3，5，薪资5，20，30；
            profession.setSalary(10);
            profession.setCreateBy("王伟");
            profession.setCreateAt(System.currentTimeMillis());
            profession.setUpdateAt(0l);
            profession.setUpdateBy("");
            logger.info("添加结果：" + professionMapper.insert(profession));
        }
    }
}
