package com.fml.mapper;

import com.fml.pojo.Email;

public interface EmailMapper {
    boolean add(Email email);
    int getCount(long stuId, long sendTime);
    boolean delete();
}
