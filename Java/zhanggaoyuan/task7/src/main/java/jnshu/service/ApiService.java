package jnshu.service;

import jnshu.model.RestUser;
import org.springframework.web.multipart.MultipartFile;

public interface ApiService {

    /**
     *
     * @param telNum 手机号码
     * @return
     */
    int checkTelNum(String telNum);

    /**
     * 手机注册验证
     * @param restUser 注册信息
     * @return
     */
    int phoneRegisterCheck (RestUser restUser);

    /**
     * 邮箱检查
     * @param email 要注册的邮箱
     * @return
     */
    int checkEmail(String email);

    /**
     * 邮箱注册验证
     * @param restUser 注册信息
     * @return
     */
    int emailRegisterCheck (RestUser restUser);

    /**
     * 上传图片
     * @return
     */
    String upload(RestUser user, String url);

    /**
     * 文件迁移，阿里云到腾讯云
     * @return
     * @throws Exception
     */
    String tranToCos() throws Exception;

    /**
     * 文件迁移，腾讯云到阿里云
     * @return
     * @throws Exception
     */
    String trantoOss()throws Exception;
}
