package com.restful.util;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.util
 * @ClassName: NumberPlaceUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:33
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public class NumberPlaceUtil {
    public static int LongTakePlace(Long number){
        number = number >0 ?number:-number;
        if(number ==0){
            return 1;
        }
        //注意别用成log()，这个底数是e
        return (int)Math.log10(number)+1;
    }
    public static int IntTakePlace(int number){
        number = number >0 ?number:-number;
        if(number ==0){
            return 1;
        }
        return (int)Math.log10(number)+1;
    }

}
