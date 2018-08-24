package com.baidu.task8.server;

import com.baidu.task8.service.StudentService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author huangdongjiang
 * @date 2018/8/16 21:34
 */
public class test {
	@Test
	public void test() throws RemoteException, NotBoundException, MalformedURLException {
		StudentService studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:2222/StudentService");
		System.out.println(studentService.findStudentById(1));
	}
}
