package jnshu.service;

import jnshu.model.Profession;

import java.util.List;

public interface ProfessionService {
    int insert(Profession record);
    List selectProfession();
}
