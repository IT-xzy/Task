package com.tiles.service;

import com.tiles.model.Page;
import com.tiles.model.Profession;
import com.tiles.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ProfessionService {


    int findAllCount();

    Page<Profession> findByPage(int nowpage, int pagesize);

    List<Profession> findAll();


}
