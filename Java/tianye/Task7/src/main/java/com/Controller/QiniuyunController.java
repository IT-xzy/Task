package com.Controller;

import com.Tool.SdkTools;
import com.API.qiniuyun.OssApiQiNiuYun;
import com.Pojo.User;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@Component
public class QiniuyunController {
    private static Logger logger = Logger.getLogger(QiniuyunController.class);
    @Resource
    private UserService userService;
    @Autowired
    OssApiQiNiuYun ossApiQiNiuYun;
    @Autowired
    SdkTools sdkTools;
    @RequestMapping(value = "/updateImage", method = RequestMethod.GET)
    public String updateImg() {
        return "updateImage";
    }
    //调用七牛云方法，上传图片
    @RequestMapping("/updateImage")
    @ResponseBody
    public JSONObject updateImage(MultipartFile item_pic, String userId){
        String fileName=ossApiQiNiuYun.updateFile(userId,item_pic);
        logger.info(userId);
        logger.info(fileName);
        JSONObject jsonObject=new JSONObject();
        if(fileName.equals("error")){
            jsonObject.put("data","注册失败");
            return jsonObject ;
        }else {

              User user=userService.selectById(userId);
              user.setUserPhoto(fileName);
              jsonObject.put("data","图像上传成功");
              this.userService.update(user);
        }
        return jsonObject;
    }
    //调用阿里云方法，上传图片
//    @RequestMapping("/updaImage")
//    @ResponseBody
//    public JSONObject updaImage(MultipartFile item_pic, String userId) {
//        aliyunSDK= (aliyunSDK) applicationContext.getBean("aliyunSDK");
//         String fileName=aliyunSDK.updateFile(userId,item_pic);
//         logger.info(userId);
//         logger.info(fileName);
//         JSONObject jsonObject=new JSONObject();
//        if(fileName.equals("error")){
//            jsonObject.put("data","注册失败");
//            return jsonObject ;
//        }else {
//
//              User user=userService.selectById(userId);
//              logger.info(user);
//              user.setUserPhoto(fileName);
//              jsonObject.put("data","图像上传成功");
//              this.userService.update(user);
//        }
//        return jsonObject;
//
//    }
    //图片迁移
    @RequestMapping(value = "/fileRemoval", method = RequestMethod.GET)
    @ResponseBody
    public Boolean test(){

        return sdkTools.qiNiuFileToAliyun("wan-an", "http://pc7i8ttn1.bkt.clouddn.com/");
    }
}




