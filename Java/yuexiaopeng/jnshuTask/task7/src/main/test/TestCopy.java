import java.io.*;
import java.net.URI;

public class TestCopy
{
    public static void main(String[] args) throws Exception
    {
        String input="color.jpg";
        String outPut="c:\\imgFile\\03.jpg";
//        byte [] bytes=new byte[10241011];
        File oo=new File("c:\\gongzuofile\\");
        File fileIn=new File(oo,input);
        File fileOut=new File(outPut);
        //URI S=new URI("c:/gongzuo/other1.jpg");
        //System.out.println(S);
        InputStream inputStream=new FileInputStream(fileIn);
        System.out.println(inputStream.available());
        OutputStream outputStream=new FileOutputStream(fileOut);
        int i=inputStream.available();
        System.out.println("可利用的长度"+i);
        byte [] bytes=new byte[i];
        inputStream.read(bytes);
        outputStream.write(bytes);
//        int i=-1;
//        while ((i=inputStream.read(bytes))!=-1)
//        {
//            outputStream.write(bytes,0,i);
//        }
        inputStream.close();
        outputStream.close();
        System.out.println("复制成功：");
    }
}
