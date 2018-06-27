package hzw.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class demo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("demo.class");

        long time = System.currentTimeMillis();
        logger.info("time========="+time);
        long time1 = time+5000*1000;
        logger.info("time1=========="+time1);
        Date date1 = new Date();
        date1.setTime(time1);
        Date date2 = new Date();
        date2.setTime(time);
        logger.info("date1========"+date1);
        logger.info("date========="+date2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        logger.info("最后的时间是:"+simpleDateFormat.format(date1));
        logger.info("最后的时间是========:"+simpleDateFormat.format(date2));

    }

}
