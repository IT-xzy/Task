package com.stu.service;



import com.stu.model.Page;
import com.stu.model.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService {


    int findAllCount();

    Page<Profession> findByPage(int nowpage, int pagesize);

    List<Profession> findAll();


}
