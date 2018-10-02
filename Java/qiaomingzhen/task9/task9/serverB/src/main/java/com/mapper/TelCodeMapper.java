package com.mapper;

import com.model.Code;

import java.util.List;

public interface TelCodeMapper {

    void addTel(Code code);

    Code findTel(long tel);

    List findTelList(long tel);

    void updateSum(Code code);
}
