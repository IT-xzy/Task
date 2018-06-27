package com.fangyuyang.service;

import com.fangyuyang.model.User;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
//    public Object memCacheGet(String key) throws IOException, InterruptedException, MemcachedException, TimeoutException;
//    public void memCacheDelete(String key) throws IOException, InterruptedException, MemcachedException, TimeoutException;
//    public void memCacheReplace(String key,int i,Object object) throws InterruptedException, MemcachedException, TimeoutException, IOException;
//    public void memCacheAdd(String key,int i,Object object) throws IOException, InterruptedException, MemcachedException, TimeoutException;
    User findUserById(int id);
    User findByName(String name);
    Object memCacheGet(String key);
//    void memCacheSet(String key,int time,Object value);
//    void memCacheReplace(String key,int time,Object value);
//    void memCacheDelete(String key);
    int countAll();


}
