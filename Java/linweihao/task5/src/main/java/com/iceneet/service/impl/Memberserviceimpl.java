package com.iceneet.service.impl;

import com.iceneet.dao.MemberMapper;
import com.iceneet.entity.Member;
import com.iceneet.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Memberserviceimpl implements Memberservice{
    @Autowired
    private MemberMapper memberMapper;

    public int countWorkingMember(){
        return memberMapper.countWorkingMember();
    }

    public int countMember(){
        return memberMapper.countMember();
    }

    public List<Member> selectByExcellent(){
        return memberMapper.selectByExcellent();
    }
}
