package jnshu.tool;

import org.apache.log4j.Logger;

//token工具类，
public class TokenUtil {
    private static Logger logger = Logger.getLogger (TokenUtil.class);//引入日志配置

    /**
     * 生成Token
     *
     * @return
     */
//    传入角色的id和用于MD5加密的jSalt
    public static String makeToken(long id, String salt) {

        String token1 = String.valueOf (System.currentTimeMillis () + "," + id);
        logger.info ("需要验证的未加密的字符串：" + token1);

        String ms = MD5.encoder (token1, salt);//加密，作为验证一致性的依据

        String token = String.valueOf (token1 + "," + ms);

        try {
            String eToken = DesUtil.encrypt (token);
            return eToken;
        } catch ( Exception e ) {
            return null;
        }
    }

    //    自定义一个假盐，用于验证token的一致性
    public static String jSalt() {
        String salt0 = "ljfosfjf1fe5sf1515";
        return salt0;
    }

    public static Boolean check(String eToken, long time) {
        logger.info ("传到token工具类检查方法里的参数有：" + eToken + "," + time);

        long time00 = System.currentTimeMillis ();
        logger.info ("当前时间戳为：" + time00);
        if (eToken == null) {
            return false;
        }
        try {
            String token1 = DesUtil.decrypt (eToken);//解密token
            String i = (token1.split (","))[0];//获取token的时间戳
            String ii = (token1.split (","))[1];//获取token里的id
            String iii = (token1.split (","))[2];//获得要验证的信息

            String tk = (i + "," + ii);
            logger.info ("看看跟未加盐的时候是否一样" + tk);

            Boolean rs = MD5.verify (iii, tk, jSalt ());//验证是否一致
            if (!rs) {
                logger.info ("一致性不通过，检查token是否被修改过");
                return false;
            }//不一致返回false

            long t = Long.valueOf (i);
            logger.info ("取出的时间戳为：" + t);
            if ((System.currentTimeMillis () - t) < time) {
                return true;
            }//判断有没有超时
            else {
                logger.info ("时间过时");
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

    }
}
