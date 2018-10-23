package yxpTask6.util.loginUtil;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class LoginAccountRegex
{

    /*    写一个方法，传入loginid和loginpassword，
    然后利用正则表达式，对传入的loginid和loginpassword进行判断；
    两者都为字符串，账号为字母数字和下划线，只能字母开头，限制长度为8-12位；
    密码为字母数字和下划线，限制长度为6-10位；不规定字母或数字开头；
    */

    public Boolean getLoign(String loginAccount,String loginPassword)
    {
        /*得到账号密码，
        * 1.进行正则字母的限定
        * 2.对给定的字符进行匹配；
        * 3.根据返回值来判断条件的符合性
        * 4.返回值为true，则匹配成功；
        * 5.有一个匹配不成功即返回fales值；
        * */
        Boolean boo=false;
        //账号的限定，正则限定位数和字母及下划线，账户的匹配,字母开头，总位数8-10位；
        String regex="^[A-Za-z]\\w{7,11}$";
        //密码的匹配，位数6-10位；
        String regex2="^\\w{6,10}$";
        //利用regex创建patternId对象，判断账号；
        //Pattern patternId=Pattern.compile(regex);
        //利用regex2创建patternPass对象，判断密码；
        //Pattern patternPass=Pattern.compile(regex2);
        //判断账号的字符，字符是字母开头，并且只有字符数字下划线组成；
        Boolean accBoolean=Pattern.matches(regex,loginAccount);
        //判断密码的字符，限制位数；
        Boolean passBoolean=Pattern.matches(regex2,loginPassword);
        //判断字符的长度;
        //System.out.println(idBoolean);
        //System.out.println(passBoolean);
        //账号和密码均匹配成功才返回准确值；
        if(accBoolean&&passBoolean)
        {
            return boo=true;
        }
        return boo;
    }

/*    //用来测试的main方法；
    public static void main(String args[])
    {
        JavaRegex javaRegex=new JavaRegex();
        Boolean buer=javaRegex.getLoign("O123456opopo7890","tetret");
        System.out.println(buer);
    }*/
}
