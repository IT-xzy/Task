package com.ptteng.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName NoteService
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/10  10:23
 * @Version 1.0
 **/

public interface NoteService {
    long insertCodePhone(@Param("code") long code, @Param("phone") long phone, @Param("createAt") long create);

    int selectTime(@Param("dayStart") long dayStart, @Param("dayEnd") long dayEnd, @Param("phone") long phone);
}
