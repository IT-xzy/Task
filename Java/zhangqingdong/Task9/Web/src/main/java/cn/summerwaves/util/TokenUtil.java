package cn.summerwaves.util;

public class TokenUtil {
    public static String makeToken(String username) throws Exception {
        String s1 = username;
        String s2 = System.currentTimeMillis() + "";
        String s3 = MD5Util.getMd5(s1 + s2 + "Md5key");
        DesUtil desUtil = new DesUtil("desKey");
        return desUtil.encrypt(s1 + "," + s2 + "," + s3);
    }

    public static boolean checkToken(String token) throws Exception {
        DesUtil desUtil = new DesUtil("desKey");
        String check = desUtil.decrypt(token);
        String[] str = check.split(",");
        String checkMd5 = MD5Util.getMd5(str[0] + str[1] + "Md5key");

        long now = System.currentTimeMillis();
        long before = Long.parseLong(str[1]);
        long time = now - before;
        return checkMd5.equals(str[2]) && time < 10000;
    }

    public static String getUsernameInToken(String token) throws Exception {
        DesUtil desUtil = new DesUtil("desKey");
        String check = desUtil.decrypt(token);
        String[] str = check.split(",");
        return str[0].trim();
    }

}
