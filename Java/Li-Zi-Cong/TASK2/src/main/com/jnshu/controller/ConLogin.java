//package main.com.jnshu.controller;
//import main.com.jnshu.dao.StudentInfoMapper;
//import main.com.jnshu.pojo.Admin;
//import main.com.jnshu.pojo.StudentInfo;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//@RequestMapping("/con")
//public class ConLogin {
//
// 没有用REST风格的
//
//
//     private StudentInfoMapper getConfig(){
//         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
//         return (StudentInfoMapper)applicationContext.getBean("userMapper");
//          }
//
//    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
//     public String checkLogin(String loginname,String password){
//         System.out.println("验证模块开始");
//         StudentInfoMapper studentInfoMapper = getConfig();
//         Admin admin1 = new Admin(null,loginname,password);
//         System.out.println("验证模块得到的消息"+admin1.toString());
//         Admin admin2 =null;
//         try {
//             admin2=studentInfoMapper.checkLogin(admin1);
//             System.out.println("验证模块返回的消息:"+admin2);
//         }catch (Exception e){
//            e.printStackTrace();
//             System.out.println("c验证模块执行异常:");
//         }
//         finally {
//             if (admin2==null){
//                 return null;
//             }else {
//                 System.out.println("验证通过准备跳转");
//                 return "redirect:/con/login";
//             }
//         }
//     }
//
//    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
//    public String login(Model model){
//        System.out.println("---login---");
//        try {
//            StudentInfoMapper studentInfoMapper = getConfig();
//            List<StudentInfo>lists = studentInfoMapper.listTable();
//            model.addAttribute("lists",lists);
//            System.out.println("登录模块执行成功:");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "list";
//    }
//
//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String register(String account,String password){
//        System.out.println("---register---");
//        Admin admin = new Admin(null,account,password);
//        System.out.println("收到来自表单的信息account:"+account+"password:"+password);
//        try {
//            StudentInfoMapper studentInfoMapper = getConfig();
//            studentInfoMapper.register(admin);
//            System.out.println("注册模块执行成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "login";
//    }
//    @RequestMapping(value = "/edit",method = RequestMethod.GET)
//    public String edit(String cmd,Integer id,Model model,String flag,StudentInfo studentInfo){
//        System.out.println("---edit---");
//        System.out.println("编辑模块1收到信息cmd:"+cmd+"-----id:"+id);
//        try {
//            StudentInfoMapper studentInfoMapper = getConfig();
//            if (flag==null||flag.equals("")) {
//                if (cmd.equals("delete")) {
//                    studentInfoMapper.deleteByID(id);
//                    return "redirect:/con/login";
//                } else if (cmd.equals("update")) {
//                    model.addAttribute("studentInfo", studentInfoMapper.findByStudentID(id));
//                    return "edit";
//                } else if (cmd.equals("create")) {
//                    return "edit";
//                }
//            } else if (flag.equals("save")){
//                System.out.println("编辑模块.新增收到消息flag:"+flag+"studentInfo:"+studentInfo);
//                studentInfoMapper.insertSTU(studentInfo);
//                return "redirect:/con/login";
//            }else if (flag.equals("update")) {
//                System.out.println("编辑模块.修改收到消息flag:"+flag+"studentInfo:"+studentInfo);
//                studentInfoMapper.updateByID(studentInfo);
//                return "redirect:/con/login";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("编辑模块 没有匹配项");
//         return null;
//    }
//
//    @RequestMapping(value = "/edit2",method = RequestMethod.GET)
//    public String edit2(Model model,StudentInfo studentInfo){
//        System.out.println(studentInfo.toString());
//        System.out.println("222222");
////        System.out.println(studentInfo.toString());
//         return null;
//
////        }
//    }
//}