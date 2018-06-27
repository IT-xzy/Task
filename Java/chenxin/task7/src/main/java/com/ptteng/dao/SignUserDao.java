package com.ptteng.dao;

import com.ptteng.model.SignedUser;

import java.util.List;

public interface SignUserDao {
    List<SignedUser> get() throws Exception;
    SignedUser getById(long id) throws Exception;
}
