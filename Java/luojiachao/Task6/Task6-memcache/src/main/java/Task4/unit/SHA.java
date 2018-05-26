package Task4.unit;


import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {
    public static final String KEY_SHA = "SHA";

    public static  String  getResult(String passwood)
    {
        BigInteger sha =null;
        System.out.println("=======加密前的数据:"+passwood);
        byte[] inputData = passwood.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {e.printStackTrace();}
        return sha.toString(32);

    }
    public static String getSHAwithSalt(String passwood, String salt){
        return passwood+salt;
    }




//    public static void main(String args[])
//    {
//        try {
//            String inputStr = "简单加密";
//            getResult(inputStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
