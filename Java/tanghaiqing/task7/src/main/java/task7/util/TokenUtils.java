package task7.util;

import org.apache.log4j.Logger;

public class TokenUtils {
    private static Logger logger =Logger.getLogger(TokenUtils.class);
    /**
     * 获取Token
     * @param memberNumber	用户会员号
     * @return
     */
    static{
        try {
            DESUtil.init();
            logger.info("DES加密方法初始化成功！");
        } catch (Exception e) {
            logger.error("DES加密方法初始化错误！");
            e.printStackTrace();
        }
    }
    public static String getToken( String token){
        logger.info("token 生成串，data = " + token);
        try {
            //DesUtil.init();//误区，只调用一次
            token  = DESUtil.encrypt(token);
        } catch (Exception e) {
            logger.error("生成TOKEN DES加密错误！");
            e.printStackTrace();
        }
        return token;
    }
    public static String decryptToken(String str){
        logger.info("token 解密,token="+str);
        try {
            str =DESUtil.decrypt(str);
        } catch (Exception e) {
            logger.error("解密错误！");
            e.printStackTrace();
        }
        return str;
    }
    private TokenUtils() {
        super();
    }
}
