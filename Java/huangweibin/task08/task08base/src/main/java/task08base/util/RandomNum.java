package task08base.util;

import java.util.Random;

public class RandomNum {
    /**
     *
     *  @return int ：
     *              1 or 2
     */
    public static int getRandomNun(){
        Random r = new Random();
        int num = r.nextInt(2)+1;
        System.out.println(num);
        return num;

    }

}
