package email;

import com.jns.utils.Email;

import java.io.IOException;

public class emailTest {
    public static void main(String args[]) throws IOException {
        String[] datas=new String[]{"http://api.sendcloud.net/apiv2/mail/send","Does_test_P9bt0O","oLoiKbJ6m1Jv8MRU","sendcloud@sendcloud.org","李志明的爷爷","704269008@qq.com","来自B608室友的第一封邮件！","你太棒了！请发送好的邮件信息。"};
        Email email=new Email();
        email.params(datas);
    }
}
