package com.ptteng.service.impl;

import com.ptteng.dao.NoteMapper;
import com.ptteng.model.Note;
import com.ptteng.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName NoteServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/10  10:47
 * @Version 1.0
 **/
@Service
public class NoteServiceImp implements NoteService {
    @Autowired
    NoteMapper noteMapper;


    @Override
    public long insertCodePhone(long code, long phone, long createAt) {
        System.out.println("code ande phone hahahah=======" + code + "======" + phone);
        return noteMapper.insertCodePhone(code, phone, createAt);
    }

    @Override
    public int selectTime(long dayStart,long dayEnd, long phone) {
        return noteMapper.selectTime(dayStart,dayEnd, phone);
    }
}
