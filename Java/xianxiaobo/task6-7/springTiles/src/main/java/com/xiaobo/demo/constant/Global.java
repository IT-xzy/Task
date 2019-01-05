package com.xiaobo.demo.constant;

public interface Global {
    String USER_SESSION_KEY = "userId"; // 存在session中的key值
    long LOG_WARN_EXECUTE_TIME = 2000; // 超过了2s的请求进行error打印
//    String UPLOAD_FILE_SAVE_PATH = "D:/upload/"; //本地上传的图片保存地址
//    String SERVER_IP_PORT="http://localhost:8080";
//    String IP_NGINX_IMAGE_ADDRESS = "http://localhost/file/"; //本地地址加上nginx代理地址


    String UPLOAD_FILE_SAVE_PATH = "/usr/local/upload/"; //服务器上传的图片保存地址
    String SERVER_IP_PORT="http://106.12.103.127:8001";
    //    String IP_NGINX_IMAGE_ADDRESS = "http://106.12.103.127/file/"; //服务器地址加上nginx代理地址
    Integer DEFAULT_STATUS = 2; // 1为上架，2为下架
}
