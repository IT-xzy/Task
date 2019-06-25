package cn.wp.service;

import cn.wp.model.Student;
import org.oasisopen.sca.annotation.Remotable;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/** @ClassName: @Description: @Author: WP @Date: 2019/6/19 13:35 @Version: 1.0 */
@Remotable
public interface StudentService extends Remote {

  List<Student> selectAll() throws RemoteException;
}
