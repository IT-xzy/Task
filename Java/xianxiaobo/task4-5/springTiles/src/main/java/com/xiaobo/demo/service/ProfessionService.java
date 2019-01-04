package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProfessionService {
    public List<Profession> selectByDevelopmentDirection(Profession profession);
    public ArrayList createCountArrayList(List<Profession> professionList);
}
