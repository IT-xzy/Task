package Task4.Tag;

import org.apache.ibatis.ognl.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTag {



    public static String longToString(Long time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
        /*
         *String stringTime = simpleDateFormat.format(date);
         *return stringTime;
         */
    }

}

