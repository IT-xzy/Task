package com.ptteng.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface MailService {

    int insertCodeMail(@Param("code") String code,
                       @Param("mailAddress") String mailAddress,
                       @Param("createAt") long create);

}
