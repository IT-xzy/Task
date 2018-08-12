package task05.util.des;



import java.nio.charset.Charset;

public class DesUtil {


    public static String encrypt(String srcStr, Charset charset, String sKey) {

        byte[] src = srcStr.getBytes(charset);

        byte[] buf = Des.encrypt(src, sKey);

        return Des.parseByte2HexStr(buf);

    }


    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {

        byte[] src = Des.parseHexStr2Byte(hexStr);

        byte[] buf = Des.decrypt(src, sKey);

        return new String(buf, charset);

    }

}


