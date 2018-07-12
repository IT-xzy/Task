package com.ptteng.service;

import com.ptteng.model.SignedUser;

import java.util.List;

public interface SignUserService {
    List<SignedUser> get() throws Exception;
    SignedUser getById(long id) throws Exception;
}
