package task6.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task6.pojo.PositionStu;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionstuMemTest {
    @Resource(name = "positionstuMemImpl")
    private PositionstuMem positionstuMem;

    @Test
    public void queryPositionStuM() {
        List<PositionStu>  positionStus =positionstuMem.queryPositionStuM();
        for (Object p:positionStus){
            System.out.println(p);
        }
    }

    @Test
    public void savePositionStuM() {
        PositionStu p=new PositionStu();
        p.setName("唐海清");
        p.setPosition("java后端工程师");
        p.setIntro("后端工程师是一个跟数据打交道的工作，所以一定要耐得住寂寞，在爬虫中寻找快乐！");
        p.setImage("haiqing");
        p.setSalary(5D);
        p.setCreateTime(System.currentTimeMillis());
        p.setUpdateTime(System.currentTimeMillis());
        Integer i =positionstuMem.savePositionStuM(p);
        System.out.println(i);
    }
}