package com.service;

import com.model.Profession;

import java.util.List;

public interface ProfService extends BaseService {
    List<Profession> group();
}
