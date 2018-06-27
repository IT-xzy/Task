package com.jnshu.service;
import com.jnshu.model.Checks;

public interface ChecksService {
    public int insert(Checks checks);
    public int countByPhone(String phone);
    public Checks selectByPhone(String tel);
    public int countByEmail(String email);
    public Checks selectByEmail(String email);
}
