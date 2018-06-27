package Impl;

import POJO.Company;
import POJO.Cooperation;
import POJO.GreatStudent;
import POJO.HowToStudy;
import mapper.OtherPageMapper;
import org.springframework.stereotype.Service;
import service.OtherPageService;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task8serverB
 * @description: the implements of otherpageservice
 * @create: 2018/6/6 下午7:24
 */
@Service
public class OtherPageServiceImpl implements OtherPageService {
    @Resource
    private OtherPageMapper otherPageMapper;
    public OtherPageServiceImpl() throws RemoteException{
    
    }
    /**
     * 查找优秀学员
     * @return
     */
    @Override
    public List<GreatStudent> findStudentByName() throws RemoteException{
        return otherPageMapper.findStudentByName();
    }
    
    /**
     * 合作企业图标
     * @return
     */
    @Override
    public List<Cooperation> findCooperation() throws RemoteException{
        return otherPageMapper.findCooperation();
    }
    
    /**
     * 首页学习流程
     * @return
     */
    @Override
    public List<HowToStudy> findStudy() throws RemoteException {
        return otherPageMapper.findStudy();
    }
    
    /**
     * 推荐企业
     * @return
     */
    @Override
    public List<Company> findCompany() throws RemoteException {
        return otherPageMapper.findCompany();
    }
}
