package com.jnshu.task4.service;

import com.jnshu.task4.beans.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService {
    List<Profession> showProfession();
}
