package lujing.serviceimpl;

import lujing.mapper.GoodStudentMapper;
import lujing.mapper.LearnMapper;
import lujing.mapper.StudentMapper;
import lujing.pojo.GoodStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lujing
 * Create_at 2017/12/28 15:21
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})

public class GoodStudentServiceImplTest {
    @Autowired
    GoodStudentServiceImpl GoodStudentServiceImpl;
    
    
    @Test
    public void cuntStudying() {
        System.out.println(GoodStudentServiceImpl.countStudying());
        
    }
    
    @Test
    public void countWorking() {
        System.out.println(GoodStudentServiceImpl.countWorking());
    }
    
    @Test
    public void getGoodStudents() {
        List<GoodStudent> gs = GoodStudentServiceImpl.getGoodStudents();
        for (GoodStudent g : gs) {
            System.out.println(g);
        }
    }
}