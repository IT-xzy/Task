package cn.wp.service.impl;

import cn.wp.dao.MobileDao;
import cn.wp.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 15:05 @Version: 1.0 */
@Service
public class MobileServiceImpl implements MobileService {
  @Autowired MobileDao mobileDao;

  @Override
  public long insertCodePhone(long phone, long code, long create) {
    return mobileDao.insertCodePhone(phone, code, create);
  }

  @Override
  public int selectTime(long dayStart, long dayEnd, long phone) {
    return mobileDao.selectTime(dayStart, dayEnd, phone);
  }
}
