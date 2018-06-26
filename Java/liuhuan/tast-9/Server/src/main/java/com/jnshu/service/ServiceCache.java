package com.jnshu.service;

import org.oasisopen.sca.annotation.Remotable;

import java.util.Date;

@Remotable
public interface ServiceCache {
    void delete(String key);
    void setDefault(String key, Object object);
    void setDate(String key, Object object, Date date);
    Object getKey(String key);
}
