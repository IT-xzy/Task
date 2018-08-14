package com.task6.util;

/**
 * Create by SongWu on 2018/7/13
 */
public class RegExUtil {

    /**
     * 正则表达式验证昵称
     * @param nickName
     * @return
     */
    public static boolean rexCheckNickName(String nickName) {
        // 昵称格式：限16个字符，支持中英文、数字、减号或下划线
        String regStr = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$";
        return nickName.matches(regStr);
    }

    /**
     * 正则表达式验证密码
     * @param input
     * @return
     */
    public static boolean rexCheckPassword(String input) {
        // 6-20 位，字母、数字、字符
        //String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){6,20}$";
        return input.matches(regStr);
    }

    public static void main(String[] args){
        System.out.println("rexCheckPassword is： "+ rexCheckPassword("14`~!@#$%^&*(\\)+=|{}"));
        System.out.println("rexCheckNickName is： "+ rexCheckNickName("中英文-数字_减号或下划线"));
        System.out.println("rexCheckNickName is： "+ rexCheckNickName("12文、数字、@"));
    }
}
