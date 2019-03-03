package com.jnshu.task7.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Slf4j
public class HttpUtil {

    public static void httpMethod(){
        //创建实例httpClient;
        HttpClient client = new HttpClient();

        //创建方法
        HttpMethod method = new PostMethod("http://www.baidu.com");

        method.setRequestHeader("apiUser","yrxxxx_test_bacfgs");
        method.setRequestHeader("apiKey","yX3A9u20dOzRdOBd");
        method.setRequestHeader("subject","测试邮件,");
//        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler(3,false));

        try {
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK){
                log.info("method failed :" + method.getStatusLine());
            }
            //响应正文;
            byte[] responseBody = method.getResponseBody();
            System.out.println(new String (responseBody));
        } catch (HttpException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }


    public static void main(String[] args) {
//        HttpUtil.tcpPost("www.baidu.com","80","get");
        httpMethod();
    }


    private static final String URL = "www.baidu.com";
    private static final String CONTENT = "GET http://www.baidu.com/  HTTP/1.1\r\nHost: www.baidu.com\r\n\r\n" ;
    private static final int PORT = 80 ;

//    public static void sendHTTP(){
//        try {
//
//            Socket socket = new Socket(URL,PORT); //建立TCP/IP链接
//            OutputStream out = socket.getOutputStream() ;
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
//            out.write(CONTENT.getBytes());  //发送数据
//            int d = -1 ;
//            while((d=in.read())!=-1){       //接收
//                System.out.print((char)d);  //输出到控制台
//            }
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     * 向指定URL发送GET方法的请求
//     *
//     * @param url
//     *      发送请求的URL
//     * @param param
//     *      请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return URL 所代表远程资源的响应结果
//     */
//    public static String sendGet(String url, String param) {
//        String result = "";
//        BufferedReader in = null;
//        try {
//            String urlNameString = url + "?" + param;
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输入流
//        finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return result;
//    }



    //socket
    private static synchronized String tcpPost(String clientIp,String clientPort,String msg){
        String rs = "";

        if(clientIp==null||"".equals(clientIp)||clientPort==null||"".equals(clientPort)){
            log.error("Ip或端口不存在...");
            return null;
        }

        int clientPortInt = Integer.parseInt(clientPort);

        log.info("clientIp："+clientIp+" clientPort："+clientPort);

        Socket s = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            s = new Socket(clientIp, clientPortInt);
            s.setSendBufferSize(4096);
            s.setTcpNoDelay(true);
            s.setSoTimeout(60*1000);
            s.setKeepAlive(true);
            out = s.getOutputStream();
            in = s.getInputStream();

            //准备报文msg
            log.info("准备发送报文："+msg);

            out.write(msg.getBytes("GBK"));
            out.flush();

            byte[] rsByte = readStream(in);

            if(rsByte!=null){
                rs = new String(rsByte, "GBK");
            }

        } catch (Exception e) {
            log.error("tcpPost发送请求异常："+e.getMessage());
        }finally{
            log.info("tcpPost(rs)："+rs);
            try {
                if(out!=null){
                    out.close();
                    out = null;
                }
                if(in!=null){
                    in.close();
                    in = null;
                }
                if(s!=null){
                    s.close();
                    s = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return rs;

    }

    private static byte[] readStream(InputStream in){
        if(in==null){
            return null;
        }

        byte[] b = null;
        ByteArrayOutputStream outSteam = null;
        try {
            byte[] buffer = new byte[1024];
            outSteam = new ByteArrayOutputStream();

            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }

            b = outSteam.toByteArray();
        } catch (IOException e) {
            log.error("读取流信息异常"+e);
            e.printStackTrace();
        } finally{
            try {
                if(outSteam!=null){
                    outSteam.close();
                    outSteam = null;
                }
                if(in!=null){
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }
}
