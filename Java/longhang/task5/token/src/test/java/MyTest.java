import com.longhang.model.User;
import com.longhang.server.UserService;
import com.longhang.util.DES;
import com.longhang.util.Md5Utils;
import com.longhang.util.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")

public class MyTest {
    @Autowired
    private UserService user;

    @Test
    public void s() {
        final String password = "1234567887654321";
        String str = "你好";
        String s = DES.encryptDES(str, password);
        System.out.println(s);
        try {
            String s1 = DES.decryptDES(s, password);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ss() {
        Token t = new Token();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(s);
//
        String s=t.makeToken(String.valueOf(123456L));
        System.out.println(s);
//        String s1=t.SolveToken(s);
//        System.out.println(s1);
//        String a=t.SolveToken("4e1b3a3e2d10b570d23b0ffa998b1d90");
//        System.out.println(a);
        String ss=t.SolveToken(s);
        //System.out.println(ss);
        Long keytime=Long.valueOf(t.SolveToken(s));
        System.out.println(keytime);
    }

    @Test
    public void sss() {
        Md5Utils md = new Md5Utils();
        String psw = md.MD5("我很帅");
        String psw1 = md.MD5("我真很帅");
        System.out.println("我很帅:" + psw);
        System.out.println("4321:" + psw1);
    }

    @Test
    public void ssss() {
        User s = user.getSelects("f4202ca535787323a330909083c1c80d");
        System.out.println(s.toString());
    }

    @Test
    public void sssss() {
        user.getInsert("阿喀琉斯","123456","123456",15648989984l,16516516l);
        User s=user.getSelects("阿喀琉斯");
        System.out.println(s.toString());
    }
}