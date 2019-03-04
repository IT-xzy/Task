package com.jnshu.task7.service;

import com.jnshu.task7.beans.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService {
    List<Profession> showProfession();

    List<Profession> selectProfessionByName();
}
