package Task4.controller;

import Task4.cache.RedisCache;
import Task4.exception.MyException;
import Task4.pojo.User;
import Task4.rmi.RandomService;
import Task4.service.UserService;
import Task4.unit.CookieUnit;
import Task4.unit.OSSUtil;
import Task4.unit.TokenJWT;
import Task4.unit.VerificationUtil;
import com.aliyun.oss.OSSClient;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping
public class UpdateController {


    @Autowired
    private RandomService randomService;

    @Autowired
    OSSClient ossClient;
    @Autowired
    private RedisCache redisCache;
    Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping(value = "/u/uploadPhoto")
    public String photo(){
        return "uploadPhoto";
    }


    @RequestMapping(value = "/u/vphoto",method = RequestMethod.POST)
    public ModelAndView uploadImage(@RequestParam MultipartFile file, HttpServletRequest request,@Value("avatarljc") String bucketName)throws Exception{
        UserService userService=randomService.getUserService();
        ModelAndView mav=new ModelAndView();
        if (file==null){
            throw new MyException("没有文件");
        }

        /*解析JWT，取出JWTusername*/
        String username;
        Cookie cookie= CookieUnit.getCookieByName(request,"token");
        Map<String, Claim> map = null;
        try {
            map = TokenJWT.verifyToken(cookie.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        username = map.get("username").asString();
        User user= null;
        try {
            user = userService.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(username);

        System.out.println(file.getOriginalFilename());
        /*得到图片的类型*/
        String[] photoName = file.getOriginalFilename().split("\\.");
        String photoType = photoName[photoName.length-1];
        System.out.println(photoType);
        if (!photoType.equals("png")&!photoType.equals("jpg")&!photoType.equals("img")){
            throw new MyException("图片格式不正确");
        }
        String code = VerificationUtil.getVerificationCode();
        /*图片存储路径*/
        String photoKey = "Task7/"+username+code+"."+photoType;
        try {
            ossClient.putObject(bucketName, photoKey, new ByteArrayInputStream(file.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ossClient.shutdown();
        String avatar = OSSUtil.getImgUrl(photoKey,bucketName);
        if (avatar.equals(user.getAvatar())){
            throw new MyException("中奖了 请重新上传");
        }
        user.setAvatar(avatar);
        System.out.println(user.getAvatar());

        if (userService.update(user)){
            mav.setViewName("redirect:/u/user");
        }else {
            mav.setViewName("redirect:/u/uploadPhoto");
        }

        return mav;
    }
}
