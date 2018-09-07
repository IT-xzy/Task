package com.iceneet.service;

import com.iceneet.entity.Member;

import java.util.List;

public interface Memberservice {
    int countWorkingMember();
    int countMember();
    List<Member> selectByExcellent();
}
