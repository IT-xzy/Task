package task7.service.strategy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import task7.controlller.loginController;
import task7.pojo.UserImpl;
import task7.service.UserService;
import task7.util.OSSClientUtil;

import javax.annotation.Resource;


public class AliyunStrategyImpl implements Strategy {
    private static Logger logger = Logger.getLogger(AliyunStrategyImpl.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Override
    public void uploadImage(CommonsMultipartFile file, UserImpl user) {
        logger.info("进入AliyunStrategyImpl.uploadImage();");
       user.setImage(OSSClientUtil.uploadImg2Oss(file));
        //调用业务层的方法，实现数据更新
        userService.updateUserService(user);
    }
}
