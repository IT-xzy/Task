package com.mutesaid.service;

import com.mutesaid.model.Expert;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
public interface ExpertService {
    List<Expert> findList();
}
