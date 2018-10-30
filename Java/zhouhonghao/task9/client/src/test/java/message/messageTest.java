package message;
import com.jns.utils.SMS;
import java.util.Random;
public class messageTest {
    public static void main(String[] args) {
        //随机码
        Random random=new Random();
        String code="";
        for(int i=0;i<6;i++){
            //6位随机数字组合的字符串
            int num=random.nextInt(10);
            code+=num;
        }
        //code随机码，"1"为限制一分钟内，不能再次发送验证码
        String[] datas=new String[]{code,"1"};
        SMS sms=new SMS();
        sms.sendTemplateSMS("15093750300","1",datas);
    }
}
