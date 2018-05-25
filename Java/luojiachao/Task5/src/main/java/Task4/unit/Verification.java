package Task4.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
    public static boolean regexUsername(String username) {
        //用户名匹配结果
        //如果isUsername_matcheris true , 则return true , else  return false
        return username.matches("^[a-zA-Z0-9]{8,16}$");

    }
    public static boolean regexPassword(String password) {
        //密码匹配结果
        //如果password_matcheris true , 则return true , else  return false
        return password.matches("^[a-zA-Z0-9]{8,16}$");
    }
    public static boolean regexEmailAddress(String email){

        //邮箱匹配结果
        //如果isEmail_matcher value is true , 则 return true , else return false
        return email.matches("[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,3}");

    }
    //        String pattern = "^[a-zA-Z0-9]{8,16}$";
//        ^\w+@\w+(\.\w+)+$/ 邮箱
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        boolean confirm = m.matches();
}
