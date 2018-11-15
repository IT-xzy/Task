package task7.service.strategy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import task7.pojo.UserImpl;
import task7.service.UserService;
import task7.util.QNOSSUtil;

import javax.annotation.Resource;


public class QiniuyunStrategyImpl implements Strategy {
    private static Logger logger = Logger.getLogger(QiniuyunStrategyImpl.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Override
    public void uploadImage(CommonsMultipartFile file, UserImpl user) {
        user.setImage(QNOSSUtil.uploadImage(file));
        userService.updateUserService(user);
    }
}
