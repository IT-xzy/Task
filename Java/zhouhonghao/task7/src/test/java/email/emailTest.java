package email;

import com.jns.utils.Email;

import java.io.IOException;

public class emailTest {
    public static void main(String args[]) throws IOException {
        String[] datas=new String[]{"http://api.sendcloud.net/apiv2/mail/send","Does_test_P9bt0O","oLoiKbJ6m1Jv8MRU","sendcloud@sendcloud.org","李丽华","704269008@qq.com","来自SendCloud的第一封邮件！","你太棒了！你已成功的从SendCloud发送了一封测试邮件，接下来快登录前台去完善账户信息吧！"};
        Email email=new Email();
        email.params(datas);
    }
}
