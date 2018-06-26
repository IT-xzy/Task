package com.jnshu.service;


import java.util.Date;


public interface ServiceCache {
    void delete(String key);
    void setDefault(String key, Object object);
    void setDate(String key, Object object, Date date);
    Object getKey(String key);
}
