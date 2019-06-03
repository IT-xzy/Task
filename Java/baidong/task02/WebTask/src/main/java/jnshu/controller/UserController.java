//package jnshu.controller;
//
//import jnshu.dao.UserDao;
//import jnshu.model.User;
//import jnshu.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.annotation.Resource;
//import java.util.AbstractList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/user")
////@RequestMapping("/user")
//public class UserController {
//    @Resource
//    //多态
//    public UserDao userDao;
//
////    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    //查找全部
//    @RequestMapping("/list")
//    public String list(Model model) {
//
//        System.out.println("进来没===================");
//        List<User> list = userService.findAll();
//        System.out.println("list is ===========" + list);
//        model.addAttribute("list", list);
//        model.addAttribute("code", "1");
//        model.addAttribute("message", "查找成功");
//        return "jsp/User";
//    }
//
//    //增加(有跳转页面）
//    //增添用户的时候会指向这个地址，这个地址将会自动跳转到add。jsp页面，
//    // 等你提交数据的时候，他会将里面的数据执行第二个方法增添到数据库，并显示师傅增添成功
////    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
//    @RequestMapping("/adduser")
////    用这个方法来转到增加的页面，类型为String，返回到add.jsp页面
//    public String adduser() {
//        return "jsp/add";
//    }
//
//    //增加页面跳转完毕后，点击修改跳转到add方法的地址，进行数据库的操作，这里可以不反回User.jsp，可以重写页面显示修改成功与否
//    @RequestMapping("/add")
////    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(User user, Model model) {
//        System.out.println("user is ===========" + user);
//        int userAdd = userService.add(user);
//        if (userAdd == 1) {
//            System.out.println("add is ===========" + userAdd);
//            model.addAttribute("code", "1");
//            model.addAttribute("message", "增加成功");
//        } else {
//            model.addAttribute("code", "0");
//            model.addAttribute("message", "增加失败");
//        }
//        return "jsp/User";
//    }
//
//    //删除（在主页面直接删除不需要跳转页面）
////    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//
//    @RequestMapping("/delete")
//    public String delete(int id, Model model) {
//        int userDelete = userService.delete(id);
//        if (userDelete == 1) {
//            System.out.println("delete is ===========" + userDelete);
//            model.addAttribute("code", "1");
//            model.addAttribute("message", "删除成功");
//        } else {
//            model.addAttribute("code", "0");
//            model.addAttribute("message", "删除失败");
//        }
//        return "jsp/User";
//    }
//
//    //修改：修改是先进行查找出这条数据，再对这条数据进行修改，弹出界面，修改完毕之后进行提交
//    //查找一个
////    @RequestMapping(value = "/findById", method = RequestMethod.GET)
//
//    @RequestMapping("/findById")
//    public String update(int id, Model model) {
//        System.out.println("查找" + id + "行");
//        User userFindById = userService.findById(id);
//        model.addAttribute("find", userFindById);
//        System.out.println("findnoe is ===========" + userFindById);
//        return "jsp/update";
//    }
//
//    //修改
////    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    @RequestMapping("/update")
//    public String update(User user, Model model) {
//        System.out.println("修改数据=====" + user);
//        int userUpdate = userService.update(user);
//        if (userUpdate == 1) {
//            System.out.println("修改数据=====" + userUpdate);
//            model.addAttribute("code", "1");
//            model.addAttribute("message", "修改成功");
//        } else {
//            model.addAttribute("code", "0");
//            model.addAttribute("message", "修改失败");
//        }
//        return "jsp/User";
//    }
//
////    @RequestMapping(value = "/task", method = RequestMethod.GET)
//    @RequestMapping("/task")
//    public String pagination(Model model, @RequestParam(value = "number", defaultValue = "1") int pageNow) {
//
//        System.out.println("now" + pageNow);
//        //声明上一页、下一页、每页数据数量，数据总量
//        int prePage;
//        int nextPage;
//        int pageSize = 10;
//        int allRow = userService.selectCount();
//        int totalPages = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
//        //*上一页设定
//        // 如果输入的当前页大于一，那么前一页就是减一，否则就是当前页
//        if (pageNow > 1) {
//            prePage = pageNow - 1;
//        } else {
//            prePage = pageNow;
//        }
//        //*下一页设定
//        // 如果输入的当前页小于总页数，那么下一页就是加一，否则就是当前页
//        if (pageNow < totalPages) {
//            nextPage = pageNow + 1;
//        } else {
//            nextPage = pageNow;
//        }
//        /*分页思路：分页需要的几个元素：首页，上一页，下一页。尾页，当前页，总页数，跳页
//         *首页可以直接设定为页码数为1.。。。。尾页可以直接设定为总页数。
//         * 上一页需要用if条件与第一页进行判定。。。。。。下一页需要用if条件和尾页进行判定
//         * 跳转页可以直接输入数字，当前页可以直接读取
//         * 跳页也是由两个if条件来设定范围的
//        */
//        List<User> users = userService.selectPage((pageNow - 1) * 10, 10);
//        System.out.println("总页数" + totalPages);
//        model.addAttribute("number", pageNow);
//        model.addAttribute("prePage", prePage);
//        model.addAttribute("user", users);
//        model.addAttribute("nextPage", nextPage);
//        model.addAttribute("totalPages", totalPages);
//        return "jsp/User";
//    }
//
//}