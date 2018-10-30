package com.admincrud.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ExceptionBean {
    //e是目标组件抛出的异常对象
    @AfterThrowing(throwing="e",pointcut = "within(com.admincrud.service..*)")
    public void execute(Exception e){
        //将异常信息输入文件
        //这里要处理异常，try cath  sout（记录失败）
        try {
        FileWriter fw =new FileWriter("E:\\erro");
        //利用fw对象写入异常信息
        PrintWriter pw =new PrintWriter(fw);
        Date time =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str =sdf.format(time);
        pw.println("****************************************************");
        pw.println("异常类型："+e);
        pw.println("异常时间："+time);
        pw.println("****************异常的详细信息***********************");
        e.printStackTrace(pw);
        pw.close();
        fw.close();
        }catch (Exception ex){
            System.out.println("记录失败");
        }
    }
}
