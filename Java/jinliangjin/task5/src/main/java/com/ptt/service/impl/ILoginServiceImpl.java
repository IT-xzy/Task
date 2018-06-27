package com.ptt.service.impl;

import com.ptt.mapper.PersistentLoginsMapper;
import com.ptt.pojo.PersistentLogins;
import com.ptt.service.ILoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ILoginServiceImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:47
 * @Version: 1.0
 */
@Service
public class ILoginServiceImpl implements ILoginService {
    @Autowired
    private PersistentLoginsMapper loginsMapper;
    @Override
    public PersistentLogins selectByUsernameAndSeries(String username, String series) {
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(series))
            return loginsMapper.selectByUsernameAndSeries(username, series);
        return null;
    }

    @Override
    public PersistentLogins selectByUsername(String username) {
        if(StringUtils.isNotBlank(username))
            return loginsMapper.selectByUsername(username);
        return null;
    }

    @Override
    public void updatePersistentLoginsBySelective(PersistentLogins persistentLogins) {
        if(null != persistentLogins)
            loginsMapper.updateByPrimaryKeySelective(persistentLogins);
    }

    @Override
    public void deletePersistentLoginsByPrimaryKey(int id) {
        if(id > 0)
            loginsMapper.deleteByPrimaryKey(id);
    }
}
