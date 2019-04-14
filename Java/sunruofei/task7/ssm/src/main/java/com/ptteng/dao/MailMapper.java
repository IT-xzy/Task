package com.ptteng.dao;

import org.apache.ibatis.annotations.Param;

public interface MailMapper {

    int insertCodeMail(@Param("code")String code,
                       @Param("mailAddress")String mailAddress,
                       @Param("createAt")long create);

}
