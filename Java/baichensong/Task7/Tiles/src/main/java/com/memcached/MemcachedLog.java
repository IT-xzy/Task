package com.memcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @program: taskTwo
 * @description: Memcached日志记录
 * @author: Mr.xweiba
 * @create: 2018-05-18 23:00
 **/

public class MemcachedLog {
    private static Logger logger = LoggerFactory.getLogger(MemcachedLog.class);
    private final static String MEMCACHED_LOG = "D:\\memcached.log";
    private final static String LINUX_MEMCACHED_LOG = "/usr/local/logs/memcached.log";
    private static FileWriter fileWriter;
    private static BufferedWriter logWrite;

    // 获取PID，可以找到对应的JVM进程
    private final static RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    private final static String PID = runtime.getName();

    // 初始化写入流
    static {
        try {
            String osName = System.getProperty("os.name");
            // 判断是否为Windows系统 指定日志路径
            if (osName.indexOf("Windows") == -1) {
                fileWriter = new FileWriter(MEMCACHED_LOG, true);
            } else {
                fileWriter = new FileWriter(LINUX_MEMCACHED_LOG, true);
            }
            logWrite = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            logger.error("memcached 日志初始化失败", e);
            closeLogStream();
        }
    }

    /*
     * @Description: 写入日志文件
     * @Param: [content] 日志内容
     * @return: void
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static void writeLog(String content) {
        try {
            logWrite.write("[" + PID + "] " + "- [" + new SimpleDateFormat("yyyy年-MM月-dd日 hh时:mm分:ss秒").format(new Date().getTime()) + "]\r\n"
                    + content);
            logWrite.newLine();
            logWrite.flush();
        } catch (IOException e) {
            logger.error("memcached 写入日志信息失败", e);
        }
    }

    /*
     * @Description: 关闭文件流
     * @Param: []
     * @return: void
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    private static void closeLogStream() {
        try {
            fileWriter.close();
            logWrite.close();
        } catch (IOException e) {
            logger.error("memcached 日志对象关闭失败", e);
        }
    }
}