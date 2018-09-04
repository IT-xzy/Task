package com.iceneet.service;

import com.iceneet.entity.Signup;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.NotSerializableException;
import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Signupservice {
    List<Signup> getSignupByPage(int start,int limit) throws InterruptedException, MemcachedException, TimeoutException, NotSerializableException;
    Signup GetSignupById(long id) throws InterruptedException, MemcachedException, TimeoutException;
    int updateByPrimaryKey(Signup signup) throws InterruptedException, MemcachedException, TimeoutException;
    int InsertSign(Signup signup) throws InterruptedException, MemcachedException, TimeoutException;
    List<Signup> getSignAll();
    int DeleteById(long id) throws InterruptedException, MemcachedException, TimeoutException;
}
