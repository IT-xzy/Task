package com.ptteng.controller;

        import com.ptteng.client.MyRMIClient;
        import com.ptteng.entity.User;
        import com.ptteng.service.UserService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import java.rmi.RemoteException;
        import java.util.List;

@Controller
public class UserController {

    MyRMIClient myRMIClient;
    //UserService userServiceImpl = (UserService) myRMIClient.object("myRMIServer1-1", "myRMIServer2-1");

    public UserController() {
        System.out.println("进入UserController");
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) throws RemoteException {
        List<User> user = ( (UserService) myRMIClient.object("myRMIServer1-1", "myRMIServer2-1")).getAll();
        model.addAttribute("user", user);
        model.addAttribute("size", user.size());
        long time = System.currentTimeMillis();
        model.addAttribute("time", time);
        return "index1";
    }
}
