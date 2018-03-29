package jnshu.tasksix.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/** MD5的加密和解密
 * @author ruchengyuan
 * @date 2017/10/20
 */
@Component("MD5")
public class Md5Utils {
    private static Logger logMD5 = LoggerFactory.getLogger(Md5Utils.class);

    public  String getMD5(String message){
        String md5str = "";
        try{
            //创建一个提供信息的摘要算法，初始化为md5对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //将消息变为byte数组
            byte[] input = message.getBytes();
            //计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);
            //把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHrx(buff);
        }catch (Exception e){
            e.printStackTrace();
            logMD5.error("e.getMessage()： " + e.getMessage());
        }

        //16位加密
        return md5str.substring(8, 24);

        //32位加密
        //return md5str;
    }

    //二进制转换为16进制
    public static String bytesToHrx(byte[] bytes){
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++){
            digital = bytes[i];
            if(digital < 0){
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

}
