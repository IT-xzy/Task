package com.service;

import com.model.Code;

import java.util.List;

public interface TelCodeService extends BaseService{
    void addTel(Code code);

    Code findTel(long tel);

    List findTelList(long tel);

    void updateSum(Code code);
}
