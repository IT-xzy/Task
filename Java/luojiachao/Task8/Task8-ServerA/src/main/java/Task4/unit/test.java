//package Task4.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//
//public class test {
//    public static void main(String args[]) {
//        String str = "bunanpo";
//        String pattern = "^[a-zA-Z0-9]{5,10}$";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
//    }
//
//}
public class test {
    String str = "bunanpo2";
    String pattern = "^[a-zA-Z0-9]{8,16}$";
    ///^\w+@\w+(\.\w+)+$/ 邮箱
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    boolean confirm = m.matches();
}