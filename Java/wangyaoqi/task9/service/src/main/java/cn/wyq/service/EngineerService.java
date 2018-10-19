package cn.wyq.service;

import cn.wyq.pojo.Engineer;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

public interface EngineerService {
    List<Engineer> get();
}
