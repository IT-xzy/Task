package com.mutesaid.bootdemo.service;

import com.mutesaid.bootdemo.model.Usr;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UsrService {
    ArrayList<Usr> findByValue(String value);

    Boolean matchPwd(String inputPwd, Usr usr);

    Usr findById(Long id);

    Long insert(Usr usr);

    Long update(Usr usr);
}
