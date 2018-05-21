package jnshu.tasknine.APIUtil;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-11-06
 * @Time: 下午 5:26
 * Description:
 **/

@Service("attestSmsService")
public interface AttestSmsService {

    /**
     * 验证短信的服务
     * @param phoneNumber
     * @return 返回随机出来的6位数验证码
     */
    String sendVerificationSMS(String phoneNumber);

    /**
     * 从缓存中取出的手机验证码，并使缓存失效
     * @param phoneNumber
     * @return 从缓存中取出的手机验证码
     */
    String getCachePhoneNumber(String phoneNumber);
}