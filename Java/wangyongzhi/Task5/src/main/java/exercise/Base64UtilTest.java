package exercise;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
//自己写的，功能不够强，无法处理DES加密最后的问题。
//Base64加密数据方法简要实现
public class Base64UtilTest {

    private static Base64.Decoder decoder = Base64.getDecoder();
    private static Base64.Encoder encoder = Base64.getEncoder();

    public static byte[] encoder(byte[] src) {

        //把字符串解析为字节数组,如果不加参数，会默认是系统默认编码，不过最好加上，不容易出问题
//        byte[] testByte = src.getBytes();
        //针对字节数组加密
        byte[] testByte = encoder.encode(src);
        return testByte;


        //注意，encodeToString完成了加密并组合成字符串的过程，等于上面两句话的作用
//        return encoder.encodeToString(testByte);

    }

    public static byte[] decoder(byte[] src) {

//        byte[] testByte = src.getBytes();
        byte[] testByte = decoder.decode(src);

        //把对应字节数组按规定编码转换成字符串。如果不加编码方式，默认按系统编码
        return testByte;

    }

}
