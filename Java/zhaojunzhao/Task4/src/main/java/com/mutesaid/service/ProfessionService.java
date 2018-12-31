package com.mutesaid.service;

import com.mutesaid.pojo.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService {

    List<Profession> getProfesList(String direction);
}
