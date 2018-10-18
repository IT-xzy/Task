//package com.task5.main;
//
//import org.apache.log4j.Logger;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.rmi.server.RMISocketFactory;
//
//public class SMRMISocket extends RMISocketFactory {
//
//    private  static Logger logger = Logger.getLogger(SMRMISocket.class);
//
//    @Override
//    public Socket createSocket(String host, int port) throws IOException {
//        return new Socket(host,port);
//    }
//
//    @Override
//    public ServerSocket createServerSocket(int port) throws IOException {
//        if (port == 0) {
//            port = 8089; //不指定就随机分配了
//            logger.info("port服务端端口号：" + port);
//        }
//        logger.info("服务端端口号：" + port);
//        return new ServerSocket(port);
//    }
//}
