package yxpTask6.rmi;

import org.springframework.beans.factory.annotation.Autowired;
import yxpTask6.pojo.Login;
import yxpTask6.pojo.Student;
import yxpTask6.service.LoginService;
import yxpTask6.service.StudentService;

public class HelloRmiImp implements HelloRmi {
    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;
    public Student helloOne(String str){
        String str2=str;
        System.out.println("rmi的输出内容为"+str2);
        Login login=loginService.selectLogin(str);
        System.out.println(login);
        Student student=new Student();
        student.setStudyId(str);
        student=studentService.selectByStudyId(str);
        return student;
//        return login;
    }
}
