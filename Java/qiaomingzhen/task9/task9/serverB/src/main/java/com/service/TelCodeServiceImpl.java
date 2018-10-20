package com.service;

import com.mapper.TelCodeMapper;
import com.model.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelCodeServiceImpl implements TelCodeService {

    @Autowired
    private TelCodeMapper telCodeMapper;

    @Override
    public void addTel(Code code) {
        telCodeMapper.addTel(code);
    }

    @Override
    public Code findTel(long tel) {
        return telCodeMapper.findTel(tel);
    }

    @Override
    public List findTelList(long tel) {
        return telCodeMapper.findTelList(tel);
    }

    @Override
    public void updateSum(Code code) {
        telCodeMapper.updateSum(code);
    }

    @Override
    public void checkService() {

    }
}
