package service.Impl;

import mapper.ProfMapper;
import model.Prof;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProfService;

import java.io.Serializable;
import java.rmi.RemoteException;


@Service
public class ProfServiceImpl implements ProfService, Serializable {
    private static Logger logger = LoggerFactory.getLogger(ProfServiceImpl.class);

    private static final long serialVersionUID = 4077329385999640331L;

    @Autowired
    private ProfMapper mapper;

    @Override
    //根据名称查询职业信息
    public Prof getByProf(String profession) {
        logger.info("ProfServiceB接口方法已经调用；");
        Prof prof = mapper.getByProf(profession);
        return prof;
    }
}
