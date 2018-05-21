package com.fml.service;

import com.fml.pojo.Email;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface EmailService {
    boolean add(Email email);
    int getCount(long stuId, long sendTime);
    boolean delete();
}
