package hzw.util;

import hzw.service.StudentRmi;
import hzw.service.StudentService;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIServer {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(RMIServer.class);
    private static StudentService studentService;
    private static StudentRmi studentRmi;

    public static StudentService getStudentService() throws RemoteException, NotBoundException, MalformedURLException {
        try{
            // Math.random() 获取0-1之间的随机数, 乘以2 最大值为2, 范围变为0-2之间, 加1, 范围到1-2之间, int强制转换后就只有两个值: 1 和 2
            int random = (int) (Math.random() * 2 + 1);
            if (random == 1) {
                try {
                    logger.info("调用RMI服务端一studentService的远程对象方法");
                    studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8888/StudentService");
                    logger.info("调用RMI服务端一studentService远程对象方法成功");
                    return studentService;
                } catch (Exception e) {
                    logger.info("调用RMI服务端一studentService失败，尝试调用RMI服务端二");
                    studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:9999/StudentService");
                    logger.info("调用RMI服务端二studentService远程对象方法成功");
                    return studentService;
                }
            } else {
                try {
                    logger.info("调用RMI服务端二studentService的远程对象方法");
                    studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:9999/StudentService");
                    logger.info("调用RMI服务端二studentService远程对象方法成功");
                    return studentService;
                } catch (Exception e) {
                    logger.info("调用RMI服务端二studentService失败，尝试调用RMI服务端一");
                    studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8888/StudentService");
                    logger.info("调用RMI服务端一studentService远程对象方法成功");
                    return studentService;
                }
            }
        }catch (Exception e){
            logger.info("===========StudentService全over=============");
        }
        return studentService;
    }
    public static StudentRmi getStudentRmi() throws RemoteException, NotBoundException, MalformedURLException {
        try{
            // Math.random() 获取0-1之间的随机数, 乘以2 最大值为2, 范围变为0-2之间, 加1, 范围到1-2之间, int强制转换后就只有两个值: 1 和 2
            int random = (int) (Math.random() * 2 + 1);
            if (random == 1) {
                try {
                    logger.info("调用RMI服务端一的studentRmi远程对象方法");
                    studentRmi = (StudentRmi) Naming.lookup("rmi://127.0.0.1:8888/StudentRmi");
                    logger.info("调用RMI服务端一studentRmi远程对象方法成功");
                    return studentRmi;
                } catch (Exception e) {
                    logger.info("调用RMI服务端一studentRmi失败，尝试调用RMI服务端二");
                    studentRmi = (StudentRmi) Naming.lookup("rmi://127.0.0.1:9999/StudentRmi");
                    logger.info("调用RMI服务端二studentRmi远程对象方法成功");
                    return studentRmi;
                }
            } else {
                try {
                    logger.info("调用RMI服务端二studentRmi的远程对象方法");
                    studentRmi = (StudentRmi) Naming.lookup("rmi://127.0.0.1:9999/StudentRmi");
                    logger.info("调用RMI服务端二studentRmi远程对象方法成功");
                    return studentRmi;
                } catch (Exception e) {
                    logger.info("调用RMI服务端二studentRmi失败，尝试调用RMI服务端一");
                    studentRmi = (StudentRmi) Naming.lookup("rmi://127.0.0.1:8888/StudentRmi");
                    logger.info("调用RMI服务端一studentRmi远程对象方法成功");
                    return studentRmi;
                }
            }
        }catch (Exception e){
            logger.info("===========StudentRmi全over=============");
        }
        return studentRmi;
    }
}
