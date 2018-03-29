package jnshu.tasknine.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-11
 * @Time: 下午 4:26
 * Description:
 **/
public class FileConversionUtil {


    /**
     *  把流转化为数组形式 （顺便存入缓存）
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] streamToByte(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

}