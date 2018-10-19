package main.com.jnshu.controller;
import com.alibaba.fastjson.JSON;
import main.com.jnshu.dao.StudentInfoMapper;
import main.com.jnshu.pojo.Admin;
import main.com.jnshu.pojo.StudentInfo;
import main.com.jnshu.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ConRest {
    Logger logger = Logger.getLogger(ConRest.class);
    public void execute(String flag,Integer id,StudentInfo studentInfo){
        try {
            StudentInfoMapper studentInfoMapper = getConfig();
            if (flag.equals("")||flag==null){
            }else {
                if (flag.equals("_INSERT")){
                    studentInfoMapper.insertSTU(studentInfo);
                }else if (flag.equals("_DELETE")){
                    studentInfoMapper.deleteByID(id);
                }else if (flag.equals("_QUERY")){

                }else if (flag.equals("_UPDATE")){
                    studentInfoMapper.updateByID(studentInfo);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("ID: " + id + " 发生异常的操作: " + flag+"\n" +
                    "\t异常内容:"+studentInfo.toString()+"\n" +
                    "异常代码信息:"+e);
        }
    }

//    @RequestMapping("/students")
//    public String getAllStuOne(Model model) {
//        System.out.println("--jack--");
//        try {
//            StudentInfoMapper studentInfoMapper = getConfig();
//            List<StudentInfo> studentInfos = studentInfoMapper.listTable();
//            model.addAttribute("students", studentInfos);
//            for (StudentInfo list:studentInfos){
//                System.out.println(list.toString());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "jackson";
//    }

    @RequestMapping(value="/students",method = RequestMethod.POST)
    @ResponseBody
    public String hello(HttpServletResponse response) throws Exception{
        User user=new User();
        user.setAge("21");
        user.setName("你好");
        User u2=new User();
        u2.setAge("21");
        u2.setName("你好");
        java.util.Map<String,User> map=new HashMap<String, User>();
        map.put("001", user);
        map.put("002", u2);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String insertSTU(StudentInfo studentInfo,Model model){
        System.out.println("---新增---");
        if (studentInfo.getStudentName()==null){
            return "insert";
        }else {
            execute("_INSERT",null,studentInfo);
        }
        return "redirect:/listInfo";
    }

    @RequestMapping(value = "/student",method = RequestMethod.DELETE)
    public String deleteSTU(Integer id,Model model){
        System.out.println("---删除---");
        execute("_DELETE",id,null);
        return "redirect:/listInfo";
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String querySTU(Integer id,Model model, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        System.out.println("---查询---");
        StudentInfoMapper studentInfoMapper = getConfig();
        model.addAttribute("studentInfo",studentInfoMapper.findByStudentID(id));
        System.out.println("查询"+studentInfoMapper.findByStudentID(id));
        return "update";
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public String updateSTU(Integer id, StudentInfo studentInfo, Model model, HttpServletRequest request)throws Exception{
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("studentName"));
        System.out.println("---修改---");
        System.out.println("修改"+id+"--"+studentInfo);
        execute("_UPDATE",id,studentInfo);
        return "redirect:/listInfo";
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public String checkLogin(String loginname,String password){
        System.out.println("---checkLogin---");
        StudentInfoMapper studentInfoMapper = getConfig();
        System.out.println("用户输入的信息为:loginName "+loginname+"-password: "+password);
        Admin admin =null;
        try {
             admin=studentInfoMapper.checkLogin(new Admin(null,loginname,password));
         }catch (Exception e){
            e.printStackTrace();
            System.out.println("!-验证模块执行异常");
            logger.error("用户登录异常，原因不明,记录异常代码位置及信息",e);
         }
         finally {
             if (admin==null){
                 System.out.println("!-验证失败执行异常，引导用户回登录页面");
                 logger.debug("用户输入信息未找到account:"+loginname+"  password:"+password);
                 return "login";
             }else {
                 System.out.println("*验证成功准备跳转");
                 return "redirect:/listInfo";
             }
         }
    }

    //分页
    @RequestMapping(value = "lastPage",method = RequestMethod.GET)
    public String lastPage(Integer pageCount,Model model){
        System.out.println("---上一页---");
        int increment=5;
        int addIndex=0;
        pageCount-=2;
        try {
            StudentInfoMapper studentInfoMapper = getConfig();
            List<StudentInfo> lists = studentInfoMapper.listTable();
            List<StudentInfo> lastPage = new ArrayList<>();
            if (pageCount<1){
                model.addAttribute("flag",1);
                pageCount=1;
            }
            for (int i=(pageCount*increment)-increment;i<=(pageCount*increment)-1;i++){
               lastPage.add(addIndex,lists.get(i));
               addIndex++;
            }
            pageCount+=1;
            model.addAttribute("lists", lastPage);
            model.addAttribute("pageIndex", pageCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "list";
    }

    @RequestMapping(value = "nextPage",method = RequestMethod.GET)
    public String nextPage(Integer pageCount,Model model){
        System.out.println("---下一页---");
        int increment=5;
        int addIndex=0;
        try {
            StudentInfoMapper studentInfoMapper = getConfig();
            List<StudentInfo> lists = studentInfoMapper.listTable();
            List<StudentInfo> nextPage = new ArrayList<>();
            if (pageCount*5>lists.size()&&(pageCount*increment-lists.size())>increment-1||
                    (pageCount*increment-lists.size())==1){
                model.addAttribute("flag",2);
                pageCount-=1;
            }
            for (int i=(pageCount*increment)-increment;i<=(pageCount*increment)-1;i++){
                if (pageCount*increment>lists.size()){
                    System.out.println("差:"+(pageCount*increment-lists.size()));
                    for (int j=(pageCount-1)*increment;j<lists.size();j++){
                        nextPage.add(addIndex,lists.get(j));
                        addIndex++;
                    }break; }
                else {
                    nextPage.add(addIndex,lists.get(i));
                    addIndex++;
                }
            }
            pageCount++;
            model.addAttribute("lists", nextPage);
            model.addAttribute("pageIndex",pageCount);
        }catch (Exception e){
            e.printStackTrace(); }return "list"; }

    @RequestMapping(value = "/listInfo",method = RequestMethod.GET)
    public String listInfo(Model model){
        System.out.println("---login---");
        int increment=5;
        logger.debug("123");
        try {
            StudentInfoMapper studentInfoMapper = getConfig();
            List<StudentInfo> lists = studentInfoMapper.listTable();
            List<StudentInfo> nextPage =new ArrayList<>();
            int pageCount=1;
            for(int i = 0;i<5;i++){
                nextPage.add(i,lists.get(i));
            }
            pageCount++;
//            Page page = new Page();
//            int sum=studentInfoMapper.listTable().size();
//            int surplus=sum%increment;
//            int count=sum/increment;
//            System.out.println("sum:"+sum+"  surplus:"+surplus);
//            for(int i= 0;i<count;i++){
//                page.setIndex(i);
//            }
//            System.out.println("page:"+page);
//            List index = new ArrayList();
//            index.add(0,count);
//            index.add(1,surplus);
            System.out.println("login:"+pageCount);
            model.addAttribute("lists",nextPage);
            model.addAttribute("pageIndex",pageCount);
//            model.addAttribute("pageCount",index);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("展示数据异常，原因不明,记录异常代码位置及信息",e);
        }
        System.out.println("*登录模块执行成功,准备跳转到list");
        return "list";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(String account,String password){
        System.out.println("---register---");
        Admin admin = new Admin(null,account,password);
        System.out.println("收到来自表单的信息account:"+account+"password:"+password);
        try {
            StudentInfoMapper studentInfoMapper = getConfig();
            studentInfoMapper.register(admin);
            System.out.println("注册模块执行成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }

    private StudentInfoMapper getConfig(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        return (StudentInfoMapper)applicationContext.getBean("userMapper");
    }

}
