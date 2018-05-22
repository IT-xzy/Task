import com.jnshu.lh.stuService.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class Tests {
    @Autowired
    private StuService stu;
    @Test
    public void test(){
       int s=stu.getGetCount();
        System.out.println("总数"+s);
        int ss=stu.getGetCountG();
        System.out.println("好工作"+ss);
    }
    @Test
    public void testsss(){
        stu.getUpdateCuByName("java工程师",3);
    }
    @Test
    public void tt(){
        int a =stu.getGetMajor("web");
        System.out.println("总数————————"+a);
    }
    @Test
    public void tts(){
        ArrayList<String> a =stu.getGetAllCuName();
        Iterator<String> it=a.iterator();
        while(it.hasNext())
        {
            String s1=(String)it.next();
            String REGEX_CHINESE = "[\u4e00-\u9fa5]";
            Pattern pat = Pattern.compile(REGEX_CHINESE);
            Matcher mat = pat.matcher(s1);
            System.out.println(mat.replaceAll(""));
        }

    }
}
