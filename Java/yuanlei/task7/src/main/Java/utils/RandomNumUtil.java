package utils;

public class RandomNumUtil {
    //Math.random()产生的是0-1之间的随机小数,取不到0和1
    private String random = (int)((Math.random()*9+1)*100000)+"";
    public static String num ;
    public String getRandom(){
        return random;
    }
}
