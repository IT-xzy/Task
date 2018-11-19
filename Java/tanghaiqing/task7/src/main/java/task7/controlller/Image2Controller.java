package task7.controlller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import task7.pojo.UserImpl;
import task7.service.strategy.Strategy;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class Image2Controller {
    private static Logger logger = Logger.getLogger(ImageController.class);
    @Resource(name = "uploadImageStrategy")
    private Strategy strategy;
    @RequestMapping(value = "/u/user", method = RequestMethod.POST)
    public String putUserStrategy(@RequestParam("image1") CommonsMultipartFile file, UserImpl user, HttpSession session) {
        System.out.println("+++++++++++++-------------------++++++++++++++----------+++++++++++");
        logger.info("前user:" + user);
        logger.info("数据file:" + file);
        //向user里面加入需要加的数据
        user.setUserID(Integer.parseInt(session.getAttribute("userID").toString()));
        user.setUpdateTime(System.currentTimeMillis());
        strategy.uploadImage(file, user);
        return "redirect:user";
    }
}
