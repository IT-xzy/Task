package com.jnshu.service;

import java.util.Date;

public interface ServiceCache {
    void delete(String key);
    void set(String key, Object object);
    void set(String key, Object object, Date date);
    Object get(String key);
}
