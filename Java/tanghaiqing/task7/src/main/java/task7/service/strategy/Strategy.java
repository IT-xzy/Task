package task7.service.strategy;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import task7.pojo.UserImpl;

public interface Strategy {
    public void uploadImage(CommonsMultipartFile file, UserImpl user);
}
