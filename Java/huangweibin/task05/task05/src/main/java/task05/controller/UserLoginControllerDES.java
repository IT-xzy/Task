package task05.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserLoginControllerDES {
//    @Autowired
//    public UserLoginServices userLoginServices;
//    private UserLogin userLogin;
//    private static final Charset CHARSET = Charset.forName("gb2312");
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        System.out.println("-----------------------------------");
//        return "/login";
//    }
//
//    //    实现跳转
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register1() {
//        return "register";
//    }

//    /**
//     * 使用 DES 来加密
//     * @param userLogin
//     * @return
//     */
//
//    @RequestMapping(value ="/tologin",method = RequestMethod.POST)
//    public String tologin(UserLogin userLogin){
//        String despassword1 ="";
//        System.out.println("---------login------------");
////        根据前端返回的数据，获取整体信息
//        UserLogin loginResult = userLoginServices.login(userLogin);
//        System.out.println("--------1---------------");
//        System.out.println(loginResult.toString());
//        System.out.println("--------2---------------");
//
//        try {
////            对前端传回来的数据进行解码，前端传回来的只有 name password ,因此 salt 需要从数据库中取出来
//            despassword1 =DesUtil.decrypt(loginResult.getDespassword(),CHARSET,loginResult.getSalt());
//            System.out.println("对输入的密码进行解码，解码后为："+despassword1);
//        }catch (Exception e1){
//            e1.printStackTrace();
//        }
//        System.out.println("对输入的密码进行解码，解码后为："+despassword1);
//
////        判断是否为空且为相等
//        if (despassword1.equals(userLogin.getPassword())&&loginResult.getName().equals(userLogin.getName())){
//            return "redirect:/occupation";//一个登陆成功的页面
//        } else {
//            return "redirect:/login";
//        }
//    }
//
//
//    /**
//     * 使用 DES 来加密
//     * @param userLogin
//     * @return
//     */
////    注册页面
//    @RequestMapping(value ="/toregister",method = RequestMethod.POST)
//    public String register (UserLogin userLogin){
//
////        获取一个八位数的随机数
//        String salt =CharacterUtils.getRandomString(8);
//        System.out.println("-------------salt="+salt+"---------------" );
////        开始加密
//        System.out.println(userLogin.getPassword());
//        String despassword =DesUtil.encrypt(userLogin.getPassword(),CHARSET,salt);
//        System.out.println(despassword);
//        userLogin.setSalt(salt);
//        userLogin.setDespassword(despassword);
//        System.out.println(userLogin.toString());
//        userLoginServices.register(userLogin);
//
//
////        model.addAttribute("返回通知", "注册成功,请登陆");
//
//        return  "redirect:/occupation";
//    }
//


}

