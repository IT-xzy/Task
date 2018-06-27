import org.junit.Test;

/**
 * 正则表达式测试
 */
public class StandardTest {
    private static final String E_MAIL = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$"; //邮箱格式的正则表达式，格式必须为example@example.com
    private static final String PHONE = "^1[3|5|7|8][0-9]{9}$"; //必须1开头的电话号码
    private static final String CHECK_CODE = "^@+[./+%]*[3-8]*[a-gH-N]*+#$";//校验码

    @Test
    public void test3(){
        String str = "@.%.345abH#";
        String str1 = "@.%&!#";
        String str2 = "@..%&#";
        String str3 = "@.%&!";
        System.out.println(str.matches(CHECK_CODE));
        System.out.println(str1.matches(CHECK_CODE));
        System.out.println(str2.matches(CHECK_CODE));
        System.out.println(str3.matches(CHECK_CODE));


    }


    @Test
    public void test1(){
        String ph1 = "12356";
        String ph2 ="0123";
        String ph3 ="13665515654";
        String e1 = "a_@a.a.a.a";
        String e2 = "1@a.a";
        String e3 = "a@1.b";
        System.out.println(ph1.matches(PHONE)+"|"+ph2.matches(PHONE)+"|"+ph3.matches(PHONE));
        System.out.println(e1.matches(E_MAIL));
        System.out.println(e2.matches(E_MAIL));
        System.out.println(e3.matches(E_MAIL));
    }
    @Test
    public void standardTest(){
        String name = "abcABC123";
        String n ="123";
        int t =123;
        String str ="abc";
        String num = "123456a";
        String reg = "^[a-zA-Z][a-zA-Z0-9_]*$";
        String Int = "^[0-9]*$";
        System.out.println(String.valueOf(t).matches(Int));
        System.out.println(n.matches(Int));
        System.out.println(name.matches(reg));
        System.out.println(n.matches(reg));
        System.out.println(str.matches(reg));
        System.out.println(num.matches(reg));
    }

    @Test
    public void test2(){
        System.out.println(false||true||false);
        System.out.println(!(false||true||false));
        System.out.println(!false||!true||!false);
        System.out.println(!false & !false & !false);
        System.out.println(!false && !false && !false);
    }


}
