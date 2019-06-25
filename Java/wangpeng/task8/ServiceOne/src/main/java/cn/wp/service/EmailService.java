package cn.wp.service;

import org.apache.ibatis.annotations.Param;

/** @author 老王 */
public interface EmailService {
  int insertCodeMail(
          @Param("mailAddress") String mailAddress,
          @Param("code") String code,
          @Param("createAt") long create);
}
