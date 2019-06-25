package cn.wp.dao;

import org.apache.ibatis.annotations.Param;

public interface EmailDao {
  int insertCodeMail(
          @Param("mailAddress") String mailAddress,
          @Param("code") String code,
          @Param("createAt") long create);
}
