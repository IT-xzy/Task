package com.ptt.service.Impl;

import com.ptt.mapper.ITProfessionMapper;
import com.ptt.pojo.ITProfession;
import com.ptt.service.ITProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.Service
 * @ClassName: ITProfessionServiceImpl
 * @Description: Implements the ITProfessionService.
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:16
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 10:16
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service
public class ITProfessionServiceImpl implements ITProfessionService {
    @Autowired
    ITProfessionMapper itProfessionMapper;

    @Override
    public List<ITProfession> query(){
        return itProfessionMapper.selectAll();
    }

    public List<ITProfession> getProfessions(String develop){
        List<ITProfession> professions;
        if(develop==null || develop.isEmpty()){
            return null;
        } else if(develop.contains("前端")){
            professions = itProfessionMapper.selectFrontEndDevelop("前端");
            return professions;
        } else if(develop.contains("后端")){
            professions = itProfessionMapper.selectBackEndDevelop("后端");
            return professions;
        } else if(develop.contains("整站")){
            professions = itProfessionMapper.selectFullStackDevelop("整站");
            return professions;
        } else if (develop.contains("移动")){
            return itProfessionMapper.selectMobileDevelop("移动");
        } else if(develop.contains("运维")){
            return itProfessionMapper.selectOperations("运营维护");
        }
        return null;
    }
}
