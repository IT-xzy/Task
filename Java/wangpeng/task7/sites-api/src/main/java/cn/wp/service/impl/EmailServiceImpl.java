package cn.wp.service.impl;

import cn.wp.dao.EmailDao;
import cn.wp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 15:04 @Version: 1.0 */
@Service
public class EmailServiceImpl implements EmailService {
  @Autowired EmailDao emailDao;

  @Override
  public int insertCodeMail(String mailAddress, String code, long create) {
    return emailDao.insertCodeMail(mailAddress, code, create);
  }
}
