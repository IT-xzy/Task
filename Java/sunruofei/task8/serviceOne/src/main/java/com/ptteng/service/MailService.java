package com.ptteng.service;

import org.apache.ibatis.annotations.Param;

public interface MailService {

    int insertCodeMail(@Param("code") String code,
                       @Param("mailAddress") String mailAddress,
                       @Param("createAt") long create);

}
