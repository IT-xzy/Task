package com.fml.service;

import com.fml.pojo.Email;

public interface EmailService {
    boolean add(Email email);
    int getCount(long stuId, long sendTime);
    boolean delete();
}
