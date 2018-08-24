import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public static void main(String[] args) {

/*        Date date = new Date(System.currentTimeMillis());
        //系统时间long型(java里面时间的通用语言精确到毫秒)转换成date型
        System.out.println(date);                   //输出当前时间
        //获取的年份是1900年开始的需要加上1900，月份是从0开始的
        System.out.println((1900+date.getYear())+"-"+(1+date.getMonth())+"-"+
        date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());*/

        //Calendar类获取时间
        Calendar rightNow = Calendar.getInstance();
        Date date = rightNow.getTime();    //得到date型的时间
        System.out.println("Calender类获取系统时间:"+date);   //当前时间date型的
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));
    }
}
