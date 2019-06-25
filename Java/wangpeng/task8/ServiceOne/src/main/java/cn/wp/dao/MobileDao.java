package cn.wp.dao;

import org.apache.ibatis.annotations.Param;


public interface MobileDao {
  long insertCodePhone(
          @Param("phone") long phone, @Param("code") long code, @Param("createAt") long create);

  int selectTime(
          @Param("dayStart") long dayStart, @Param("dayEnd") long dayEnd, @Param("phone") long phone);
}
