package wyq.webapp.service.impl;

import wyq.webapp.pojo.Engineer;
import org.springframework.beans.factory.annotation.Autowired;
import wyq.webapp.mapper.EngineerMapper;
import wyq.webapp.service.EngineerService;

import java.util.List;

public class EngineerServiceImpl implements EngineerService {
    @Autowired
    EngineerMapper engineerMapper;

    @Override
    public List<Engineer> get(){
        return engineerMapper.get();
    }
}
