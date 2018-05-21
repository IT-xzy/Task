package jnshu.tasknine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-28
 * @Time: 上午 12:39
 * Description:
 **/
public class SMRMISocket  extends RMISocketFactory {

    private  static Logger logger = LoggerFactory.getLogger(SMRMISocket.class);

    @Override
    public  Socket createSocket(String host, int port) throws IOException {
        return new Socket(host,port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) {
            port = 2182; //不指定就随机分配了
            logger.info("port服务端端口号：" + port);
        }
        logger.info("服务端端口号：" + port);
        return new ServerSocket(port);
    }
}