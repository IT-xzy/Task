package utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static Logger logger = LoggerFactory.getLogger(RandomUtils.class);
    public static int randomnumber(int min,int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1)+min;
        logger.info("产生随机数:{}",s);
        return s;
    }
}
