package controller;

import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UsersService;
import util.EncryptionUtil;
import util.RegexUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 修改密码模块
 */
@Controller
@RequestMapping(value = "/")
public class UpdatePasswordController {
    private static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    UsersService usersService;

    //修改密码模块
    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    public String getUpdatePassword() {
        return "updatePassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String postUpdatePassword(@RequestParam String username,
                                           String oldpassword, String newpassword, String repassword, Model model) {

        Map<String, String> msg = new HashMap<String, String>();

        Users user = usersService.getByName(username);

        if (user == null) {
            user = new Users();
            user.getMsg().put("username", "该用户名不存在，请重新输入");
            model.addAttribute("user", user);
            logger.info("There is no current user!");
            return "updatePassword";
        }
        //对用户输入的密码加盐加密，得到临时密码
        String salt = user.getSalt();
        String temporaryPassword = EncryptionUtil.getSHA256Str(oldpassword + salt);

        //比较临时密码和数据库密码是否匹配
        if (!temporaryPassword.equals(user.getPassword())) {
            user.getMsg().put("password", "密码不正确，请重新输入");
            user.setPassword(null);
            model.addAttribute("user", user);
            logger.info("Wrong old password!");
            return "updatePassword";

            //调用正则工具类验证新密码格式
        } else if (!RegexUtil.validate(newpassword, repassword, msg)) {
            user.setMsg(msg);
            user.setPassword(oldpassword);
            user.setRepassword(repassword);
            model.addAttribute("newpassword", newpassword);
            model.addAttribute("user", user);
            logger.info("The old and new passwords are different!");
            return "updatePassword";

            //条件全部符合，插入数据库
        } else {
            newpassword = EncryptionUtil.getSHA256Str(newpassword + salt);
            user.setPassword(newpassword);
            usersService.update(user);
            logger.info("Update password successfully！");
            return "redirect:/login";
        }
    }
}
