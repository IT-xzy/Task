package Impl;

import POJO.Profession;
import mapper.ProfessionMapper;
import org.springframework.stereotype.Service;
import service.ProfessionService;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task8serverB
 * @description: the implements of professionservice
 * @create: 2018/6/6 下午7:25
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Resource
    private ProfessionMapper professionMapper;
    public ProfessionServiceImpl() throws RemoteException{
    
    }
    @Override
    public List<Profession> findFront() throws RemoteException {
        return professionMapper.findFront();
    }
    @Override
    public List<Profession> findAfter() throws RemoteException {
        return professionMapper.findAfter();
    }
    @Override
    public List<Profession> findOP() throws RemoteException {
        return professionMapper.findOP();
    }
    @Override
    public List<Profession> findPM() throws RemoteException {
        return professionMapper.findPM();
    }
}
