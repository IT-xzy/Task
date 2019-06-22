package cn.wp.service;

import org.apache.ibatis.annotations.Param;

public interface MobileService {
  long insertCodePhone(
       @Param("code") long code,@Param("phone") long phone, @Param("createAt") long create);

  int selectTime(
      @Param("dayStart") long dayStart, @Param("dayEnd") long dayEnd, @Param("phone") long phone);
}
