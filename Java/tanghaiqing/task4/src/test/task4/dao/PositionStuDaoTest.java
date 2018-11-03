package task4.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task4.pojo.PositionStu;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionStuDaoTest {
    @Resource(name = "positionStuDao")
    private PositionStuDao positionStuDao;

    @Test
    public void goodShow() {
        List<PositionStu> positionStus=positionStuDao.goodShow();
        for (PositionStu p:positionStus){
            System.out.println(p);
        }
    }

    @Test
    public void savePosition() {
        PositionStu p=new PositionStu();
        p.setName("唐海清");
        p.setPosition("java后端工程师");
        p.setIntro("后端工程师是一个跟数据打交道的工作，所以一定要耐得住寂寞，在爬虫中寻找快乐！");
        p.setImage("haiqing");
        p.setSalary(4D);
        p.setCreateTime(System.currentTimeMillis());
        p.setUpdateTime(System.currentTimeMillis());
        Integer i=positionStuDao.savePosition(p);
        System.out.println(i);
    }
}