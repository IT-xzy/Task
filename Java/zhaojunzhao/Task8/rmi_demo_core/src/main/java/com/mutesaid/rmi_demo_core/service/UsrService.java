package com.mutesaid.rmi_demo_core.service;

import com.mutesaid.rmi_demo_core.model.Usr;

import java.util.ArrayList;

public interface UsrService {

    ArrayList<Usr> findByValue(String value);

    Usr findById(Long id);

    Long insert(Usr usr);

    Long update(Usr usr);
}
