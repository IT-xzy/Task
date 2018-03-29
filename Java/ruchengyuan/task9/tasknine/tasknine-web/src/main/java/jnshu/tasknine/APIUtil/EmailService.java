package jnshu.tasknine.APIUtil;

import org.springframework.stereotype.Service;

/**
 * 邮箱业务的接口
 * Created by Administrator on 2017-11-07.
 * @author Administrator
 */

@Service("emailService")
public interface EmailService  {

    /**
     * 验证邮箱接口
     * @param toAddress
     * @param user
     * @return 返回状态信息
     */
    String verificationEmail(String toAddress, String user);

    String getCacheEmailNumber(String email);
}
