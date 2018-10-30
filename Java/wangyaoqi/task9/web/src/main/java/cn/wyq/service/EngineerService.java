package cn.wyq.service;

import cn.wyq.pojo.Engineer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EngineerService {
    List<Engineer> get();
}
