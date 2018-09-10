import com.dao.UserDao;
import com.entity.Profession;
import com.entity.User;
import com.service.ProfessionService;
import com.service.UserService;
import com.util.DESUtil;
import com.util.DateUtil;
import com.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/spring-context.xml")
public class Task04 {
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Test
    public void insert01(){
        Profession profession =
                new Profession("android","互谅网技术","3颗星","难","5年",
                        "稀缺","10-40k","66","要有一定的基础","11");
        professionService.insert(profession);
        System.out.println(profession);
//        System.out.println(professionService.findById(2));
    }


    @Test
    public void findByStyle(){
        List<Profession> professions = professionService.findByStyle("全站");
        for (Profession list : professions){
            System.out.println(list);

        }
    }
    @Test
    public void insert02(){
        String loginTime = DateUtil.dateToYMDHMS(new Date());
        System.out.println(loginTime);
    }

    @Test
    public void DESTest(){
        String key = "123456789";
        String data = "!ytd1129097428";
        String des1 = DESUtil.encode(key,data);
        String des2 = DESUtil.decode(key,des1);
        System.out.println("加密前"+data);
        System.out.println("加密后"+des1);
        System.out.println("解密后"+des2);
    }

    @Test
    public void MD5Test(){
        String password = "!ytd1129097428";
        String md1 = MD5Util.MD5(password);
        String md2 = MD5Util.generate(password);
        System.out.println("加密前:"+password);
        System.out.println("普通MD5加密后:"+md1);
        System.out.println("加盐MD5加密后:"+md2);
        System.out.println("比较原文和加盐MD5加密之后是否一致:"+MD5Util.verify(password,md2));
    }

}
